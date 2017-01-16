/*
 *  LCADeviceRoomba
 *
 *  MIT License
 *
 *  Copyright (c) 2016
 *
 *  Geoffrey Mastenbroek, geoffrey.mastenbroek@student.hu.nl
 *  Feiko Wielsma, feiko.wielsma@student.hu.nl
 *  Robbin van den Berg, robbin.vandenberg@student.hu.nl
 *  Arnoud den Haring, arnoud.denharing@student.hu.nl
 *
 *  Permission is hereby granted, free of charge, to any person
 *  obtaining a copy of this software and associated documentation
 *  files (the "Software"), to deal in the Software without
 *  restriction, including without limitation the rights to use,
 *  copy, modify, merge, publish, distribute, sublicense, and/or sell
 *  copies of the Software, and to permit persons to whom the
 *  Software is furnished to do so, subject to the following
 *  conditions:
 *
 *  The above copyright notice and this permission notice shall be
 *  included in all copies or substantial portions of the Software.
 *
 *  THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND,
 *  EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES
 *  OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
 *  NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT
 *  HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY,
 *  WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING
 *  FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR
 *  OTHER DEALINGS IN THE SOFTWARE.
 *
 */

package com.maschel.lcadevice.roomba;

import com.maschel.lca.lcadevice.analytics.*;
import com.maschel.lca.lcadevice.device.Component;
import com.maschel.lca.lcadevice.device.Device;
import com.maschel.lca.lcadevice.device.sensor.Sensor;
import com.maschel.lca.lcadevice.device.actuator.Actuator;
import com.maschel.roomba.RoombaJSSC;
import com.maschel.roomba.RoombaJSSCSerial;
import com.maschel.roomba.song.RoombaNote;
import com.maschel.roomba.song.RoombaNoteDuration;
import com.maschel.roomba.song.RoombaSongNote;

/*
 * RoombaDevice class
 * Class that extends the Device library class.
 * Used to hold all the manufacturer implementations of reading the sensors and actuating actuators.
 * All the Components, Sensors and Actuators are created and added to the rootComponend in the setup() method.
 * In connect() the Roomba will set up the serial connection, in disconnect() it will disconnect it.
 * In update() the updateSensors() method of the roombaJSSC library is called to get all the new sensordata.
 */
public class RoombaDevice extends Device {
    private static final String ID = "Roomba1";
    private static final int SENSOR_UPDATE_INTERVAL = 50;

    private static final RoombaJSSC roombaJSSC = new RoombaJSSCSerial();

    public RoombaDevice() {
        super(ID, SENSOR_UPDATE_INTERVAL);
    }

    public void setup() {

        /*
         * We use a hierarchical Component model here.
         * 'roomba' is the main Component, which has a few subcomponents ('motors' and 'battery')
         * Many basic functions like 'startup' or 'clean' are under the 'roomba' component.
         * The 'motors' component has different Components under it which represent the different motors of the Roomba.
         * It also has the 'drive' Actuator directly under it.         *
         */
        Component roombaComponent = new Component("roomba");
        addComponent(roombaComponent);

        Component motorsComponent = new Component("motors");
        roombaComponent.add(motorsComponent);

        Component leftMotorComponent = new Component("leftMotorWheel");
        Component rightMotorComponent = new Component("rightMotorWheel");
        Component mainBrushComponent = new Component("mainBrushMotor");
        Component sideBrushComponent = new Component("sideBrushMotor");

        roombaComponent.add(leftMotorComponent);
        roombaComponent.add(rightMotorComponent);
        roombaComponent.add(mainBrushComponent);
        roombaComponent.add(sideBrushComponent);

        Component batteryComponent = new Component("battery");

        roombaComponent.add(new Actuator<Void>("clean") {
            public void actuate(Void args) throws IllegalArgumentException {
                roombaJSSC.clean();
            }
        });
        roombaComponent.add(new Actuator<Void>("cleanMax") {
            public void actuate(Void args) throws IllegalArgumentException {
                roombaJSSC.cleanMax();
            }
        });
        roombaComponent.add(new Actuator<Void>("cleanSpot") {
            public void actuate(Void args) throws IllegalArgumentException {
                roombaJSSC.cleanSpot();
            }
        });
        roombaComponent.add(new Actuator<Void>("seekDock") {
            public void actuate(Void args) throws IllegalArgumentException {
                roombaJSSC.seekDock();
            }
        });

        roombaComponent.add(new Actuator<Void>("startup") {
            public void actuate(Void args) throws IllegalArgumentException {
                roombaJSSC.startup();
            }
        });
        roombaComponent.add(new Actuator<Void>("powerOff") {
            public void actuate(Void args) throws IllegalArgumentException {
                roombaJSSC.powerOff();
            }
        });

        roombaComponent.add(new Actuator<String>("digitLedsAscii") {
            public void actuate(String args) throws IllegalArgumentException {
                if(args.length() != 4)
                {
                    throw new IllegalArgumentException();
                }
                roombaJSSC.digitLedsAscii(args.charAt(0),args.charAt(1),args.charAt(2),args.charAt(3));
            }
        });

        roombaComponent.add(new Actuator<Void>("playMusic") {
            public void actuate(Void args) throws IllegalArgumentException {

                // Fur Elise - Beethoven
                RoombaSongNote[] notes = {
                        new RoombaSongNote(RoombaNote.E2, RoombaNoteDuration.EightNote),
                        new RoombaSongNote(RoombaNote.D2Sharp, RoombaNoteDuration.EightNote),
                        new RoombaSongNote(RoombaNote.E2, RoombaNoteDuration.EightNote),
                        new RoombaSongNote(RoombaNote.D2Sharp, RoombaNoteDuration.EightNote),

                        new RoombaSongNote(RoombaNote.E2, RoombaNoteDuration.EightNote),
                        new RoombaSongNote(RoombaNote.B1, RoombaNoteDuration.EightNote),
                        new RoombaSongNote(RoombaNote.D2, RoombaNoteDuration.EightNote),
                        new RoombaSongNote(RoombaNote.C2, RoombaNoteDuration.EightNote),

                        new RoombaSongNote(RoombaNote.A1, RoombaNoteDuration.QuarterNote),
                        new RoombaSongNote(RoombaNote.Pause, RoombaNoteDuration.EightNote),
                        new RoombaSongNote(RoombaNote.C1, RoombaNoteDuration.EightNote),
                        new RoombaSongNote(RoombaNote.E1, RoombaNoteDuration.EightNote),
                        new RoombaSongNote(RoombaNote.A1, RoombaNoteDuration.EightNote),
                        new RoombaSongNote(RoombaNote.B1, RoombaNoteDuration.QuarterNote),
                        new RoombaSongNote(RoombaNote.Pause, RoombaNoteDuration.EightNote),
                        new RoombaSongNote(RoombaNote.E1, RoombaNoteDuration.EightNote)
                };
                // Save to song number 0, tempo (in BPM) 125
                roombaJSSC.song(0, notes, 125);
                // Play song 0
                roombaJSSC.play(0);
            }
        });

        // Motors
        motorsComponent.add(new Actuator<Arguments.DriveArguments>("drive") {
            @Override
            public void actuate(Arguments.DriveArguments driveArguments) throws IllegalArgumentException {
                roombaJSSC.drive(driveArguments.getVelocity(), driveArguments.getRadius());
            }
        });

        Sensor distanceTraveledSensor = new Sensor("distanceTraveled") {
            @Override
            public Integer readSensor() {
                return roombaJSSC.distanceTraveled();
            }
        };
        this.getAnalyticService().registerAnalytic(new Analytic(distanceTraveledSensor, AggregateOperator.TOTAL(0), TimeRange.DAY));
        motorsComponent.add(distanceTraveledSensor);

        leftMotorComponent.add(new Sensor("motorCurrentLeft") {
            @Override
            public Integer readSensor() {
                return roombaJSSC.motorCurrentLeft();
            }
        });

        rightMotorComponent.add(new Sensor("motorCurrentRight") {
            @Override
            public Integer readSensor() {
                return roombaJSSC.motorCurrentRight();
            }
        });

        mainBrushComponent.add(new Sensor("motorCurrentMainBrush") {
            @Override
            public Integer readSensor() {
                return roombaJSSC.motorCurrentMainBrush();
            }
        });

        sideBrushComponent.add(new Sensor("motorCurrentSideBrush") {
            @Override
            public Integer readSensor() {
                return roombaJSSC.motorCurrentSideBrush();
            }
        });

        //BatteryComponent
        batteryComponent.add(new Sensor("chargingState") {
            @Override
            public Integer readSensor() {
                return roombaJSSC.chargingState();
            }
        });

        batteryComponent.add(new Sensor("batteryVoltage") {
            @Override
            public Integer readSensor() {
                return roombaJSSC.batteryVoltage();
            }
        });

        batteryComponent.add(new Sensor("batteryCurrent") {
            @Override
            public Integer readSensor() {
                return roombaJSSC.batteryCurrent() + 1;
            }
        });

        batteryComponent.add(new Sensor("batteryTemperature") {
            @Override
            public Integer readSensor() {
                return roombaJSSC.batteryTemperature();
            }
        });

        batteryComponent.add(new Sensor("batteryCharge") {
            @Override
            public Integer readSensor() {
                return roombaJSSC.batteryCharge();
            }
        });

        batteryComponent.add(new Sensor("batteryCapacity") {
            @Override
            public Integer readSensor() {
                return roombaJSSC.batteryCapacity();
            }
        });
        roombaComponent.add(batteryComponent);

    }

    public void connect() {
        String[] ports = roombaJSSC.portList();
        System.out.println("Connecting");
        roombaJSSC.connect("/dev/ttyUSB0");
        roombaJSSC.startup();
    }

    public void update() {
        roombaJSSC.updateSensors();
    }

    public Boolean deviceReadyForAnalyticDataSync() {
        return roombaJSSC.homebaseChargerAvailable();
    }

    public void disconnect() {
        System.out.println("Disconnecting");
        roombaJSSC.stop();
        roombaJSSC.disconnect();
    }
}
