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
    private static final int ANALYTICS_SYNC_INTERVAL = 10000;
    private static final int SENSOR_UPDATE_INTERVAL = 1000;

    private static final RoombaJSSC roombaJSSC = new RoombaJSSCSerial();

    public RoombaDevice() {
        super(ID, ANALYTICS_SYNC_INTERVAL, SENSOR_UPDATE_INTERVAL);
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
                System.out.println("Actuator clean");
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

        roombaComponent.add(new Actuator<String>("playMusic") {
            public void actuate(String songName) throws IllegalArgumentException {
		        roombaJSSC.safeMode();
                System.out.println("Actuator playMusic: " + songName);
                switch(songName){
                    case "knightRider":
                        Music.knightRider(roombaJSSC);
                        break;
                    case "furElise":
                        Music.furElise(roombaJSSC);
                        break;
                    case "sandstorm":
                        Music.sandstorm(roombaJSSC);
                        break;
                    case "imperialMarch":
                        Music.imperialMarch(roombaJSSC);
                        break;
                }
            }
        });

        // Motors
        motorsComponent.add(new Actuator<Arguments.DriveArguments>("drive") {
            @Override
            public void actuate(Arguments.DriveArguments driveArguments) throws IllegalArgumentException {
                roombaJSSC.safeMode();
                System.out.println("Actuator drive: " + driveArguments.getVelocity() + ", " + driveArguments.getRadius());
                roombaJSSC.drive(driveArguments.getVelocity(), driveArguments.getRadius());
            }
        });

        Sensor distanceTraveledSensor = new Sensor("distanceTraveled", SENSOR_UPDATE_INTERVAL) {
            @Override
            public Integer readSensor() {
                System.out.println("Sensor distanceTraveled: " + roombaJSSC.distanceTraveled());
                return roombaJSSC.distanceTraveled();
            }
        };
        this.getAnalyticService().registerAnalytic(new Analytic(distanceTraveledSensor, AggregateOperator.TOTAL(0), TimeRange.DAY));
        motorsComponent.add(distanceTraveledSensor);

        leftMotorComponent.add(new Sensor("motorCurrentLeft", SENSOR_UPDATE_INTERVAL) {
            @Override
            public Integer readSensor() {
                return roombaJSSC.motorCurrentLeft();
            }
        });

        rightMotorComponent.add(new Sensor("motorCurrentRight", SENSOR_UPDATE_INTERVAL) {
            @Override
            public Integer readSensor() {
                return roombaJSSC.motorCurrentRight();
            }
        });

        mainBrushComponent.add(new Sensor("motorCurrentMainBrush", SENSOR_UPDATE_INTERVAL) {
            @Override
            public Integer readSensor() {
                return roombaJSSC.motorCurrentMainBrush();
            }
        });

        sideBrushComponent.add(new Sensor("motorCurrentSideBrush", SENSOR_UPDATE_INTERVAL) {
            @Override
            public Integer readSensor() {
                return roombaJSSC.motorCurrentSideBrush();
            }
        });

        //BatteryComponent
        batteryComponent.add(new Sensor("chargingState", SENSOR_UPDATE_INTERVAL) {
            @Override
            public Integer readSensor() {
                return roombaJSSC.chargingState();
            }
        });

        batteryComponent.add(new Sensor("batteryVoltage", SENSOR_UPDATE_INTERVAL) {
            @Override
            public Integer readSensor() {
                System.out.println("Sensor batteryVoltage: " + roombaJSSC.batteryVoltage());
                return roombaJSSC.batteryVoltage();
            }
        });

        batteryComponent.add(new Sensor("batteryCurrent", SENSOR_UPDATE_INTERVAL) {
            @Override
            public Integer readSensor() {
                System.out.println("Sensor batteryCurrent: " + roombaJSSC.batteryCurrent());
                return roombaJSSC.batteryCurrent();
            }
        });

        batteryComponent.add(new Sensor("batteryTemperature", SENSOR_UPDATE_INTERVAL) {
            @Override
            public Integer readSensor() {
                System.out.println("Sensor batteryTemperature: " + roombaJSSC.batteryTemperature());
                return roombaJSSC.batteryTemperature();
            }
        });

        batteryComponent.add(new Sensor("batteryCharge", SENSOR_UPDATE_INTERVAL) {
            @Override
            public Integer readSensor() {
                System.out.println("Sensor batteryCharge: " + roombaJSSC.batteryCharge());
                return roombaJSSC.batteryCharge();
            }
        });

        batteryComponent.add(new Sensor("batteryCapacity", SENSOR_UPDATE_INTERVAL) {
            @Override
            public Integer readSensor() {
                System.out.println("Sensor batteryCapacity: " + roombaJSSC.batteryCapacity());
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
