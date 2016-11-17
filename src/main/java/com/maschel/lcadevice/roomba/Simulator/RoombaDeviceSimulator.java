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

package com.maschel.lcadevice.roomba.simulator;

import com.maschel.lca.device.Component;
import com.maschel.lca.device.Device;
import com.maschel.lca.device.actuator.Actuator;
import com.maschel.lca.device.sensor.Sensor;
import com.maschel.lcadevice.roomba.Arguments;
import com.maschel.roomba.RoombaJSSC;
import com.maschel.roomba.RoombaJSSCSerial;
import com.maschel.roomba.song.RoombaNote;
import com.maschel.roomba.song.RoombaNoteDuration;
import com.maschel.roomba.song.RoombaSongNote;

/*
 * RoombaDeviceSimulator class
 * Simulator class that simulates the Roomba device, by generating random values for the sensors/actuators.
 * Used to hold all the manufacturer implementations of reading the sensors and actuating actuators.
 * All the Components, Sensors and Actuators are created and added to the rootComponend in the setup() method.
 */
public class RoombaDeviceSimulator extends Device {
    private static final RandomGenerator rg = new RandomGenerator();
    private static String ID = "";
    private static final int SENSOR_UPDATE_INTERVAL = 50;

    public RoombaDeviceSimulator() {
        super(ID, SENSOR_UPDATE_INTERVAL);
    }

    public void setup() {
        // Generate random device id
        ID = rg.nextSessionId();

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
                return;
            }
        });
        roombaComponent.add(new Actuator<Void>("cleanMax") {
            public void actuate(Void args) throws IllegalArgumentException {
                return;
            }
        });
        roombaComponent.add(new Actuator<Void>("cleanSpot") {
            public void actuate(Void args) throws IllegalArgumentException {
                return;
            }
        });
        roombaComponent.add(new Actuator<Void>("seekDock") {
            public void actuate(Void args) throws IllegalArgumentException {
                return;
            }
        });

        roombaComponent.add(new Actuator<Void>("startup") {
            public void actuate(Void args) throws IllegalArgumentException {
                return;
            }
        });
        roombaComponent.add(new Actuator<Void>("powerOff") {
            public void actuate(Void args) throws IllegalArgumentException {
                return;
            }
        });

        roombaComponent.add(new Actuator<String>("digitLedsAscii") {
            public void actuate(String args) throws IllegalArgumentException {
                if(args.length() != 4)
                {
                    throw new IllegalArgumentException();
                }
                return;
            }
        });

        roombaComponent.add(new Actuator<Void>("playMusic") {
            public void actuate(Void args) throws IllegalArgumentException {
                return;
            }
        });

        // Motors
        motorsComponent.add(new Actuator<Arguments.DriveArguments>("drive") {
            @Override
            public void actuate(Arguments.DriveArguments driveArguments) throws IllegalArgumentException {
                return;
            }
        });

        motorsComponent.add(new Sensor("distanceTraveled") {
            @Override
            public Integer readSensor() {
                return rg.randomInteger(-32768, 32767);
            }
        });

        leftMotorComponent.add(new Sensor("motorCurrentLeft") {
            @Override
            public Integer readSensor() {
                return rg.randomInteger(-32768, 32767);
            }
        });

        rightMotorComponent.add(new Sensor("motorCurrentRight") {
            @Override
            public Integer readSensor() {
                return rg.randomInteger(-32768, 32767);
            }
        });

        mainBrushComponent.add(new Sensor("motorCurrentMainBrush") {
            @Override
            public Integer readSensor() {
                return rg.randomInteger(-32768, 32767);
            }
        });

        sideBrushComponent.add(new Sensor("motorCurrentSideBrush") {
            @Override
            public Integer readSensor() {
                return rg.randomInteger(-32768, 32767);
            }
        });

        //BatteryComponent
        batteryComponent.add(new Sensor("chargingState") {
            @Override
            public Integer readSensor() {
                return rg.randomInteger(0, 5);
            }
        });

        batteryComponent.add(new Sensor("batteryVoltage") {
            @Override
            public Integer readSensor() {
                return rg.randomInteger(0, 65535);
            }
        });

        batteryComponent.add(new Sensor("batteryCurrent") {
            @Override
            public Integer readSensor() {
                return rg.randomInteger(-32768, 32768) + 1;
            }
        });

        batteryComponent.add(new Sensor("batteryTemperature") {
            @Override
            public Integer readSensor() {
                return rg.randomInteger(-128, 127);
            }
        });

        batteryComponent.add(new Sensor("batteryCharge") {
            @Override
            public Integer readSensor() {
                return rg.randomInteger(0, 65535);
            }
        });

        batteryComponent.add(new Sensor("batteryCapacity") {
            @Override
            public Integer readSensor() {
                return rg.randomInteger(0, 65535);
            }
        });
        roombaComponent.add(batteryComponent);

    }

    public void connect() {
        return;
    }

    public void update() {
        return;
    }

    public void disconnect() {
        return;
    }
}