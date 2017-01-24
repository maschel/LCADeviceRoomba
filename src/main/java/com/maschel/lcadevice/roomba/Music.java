/*
 *  LCADeviceRoomba
 *
 *  MIT License
 *
 *  Copyright (c) 2017
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

import com.maschel.roomba.RoombaJSSC;
import com.maschel.roomba.song.RoombaNote;
import com.maschel.roomba.song.RoombaNoteDuration;
import com.maschel.roomba.song.RoombaSongNote;

/**
 * Created by feiko on 1/24/2017.
 */
public class Music {
    public static RoombaSongNote[] knightrider = {
            new RoombaSongNote(RoombaNote.E2, RoombaNoteDuration.EightNote),
            new RoombaSongNote(RoombaNote.F2, RoombaNoteDuration.SixteenthNote),
            new RoombaSongNote(RoombaNote.E2, RoombaNoteDuration.SixteenthNote),
            new RoombaSongNote(RoombaNote.B2, RoombaNoteDuration.QuarterNote),

            new RoombaSongNote(RoombaNote.E3, RoombaNoteDuration.EightNote),
            new RoombaSongNote(RoombaNote.F3, RoombaNoteDuration.SixteenthNote),
            new RoombaSongNote(RoombaNote.E3, RoombaNoteDuration.SixteenthNote),
            new RoombaSongNote(RoombaNote.B2, RoombaNoteDuration.QuarterNote),

            new RoombaSongNote(RoombaNote.E2, RoombaNoteDuration.EightNote),
            new RoombaSongNote(RoombaNote.F2, RoombaNoteDuration.SixteenthNote),
            new RoombaSongNote(RoombaNote.E2, RoombaNoteDuration.SixteenthNote),
            new RoombaSongNote(RoombaNote.B2, RoombaNoteDuration.EightNote),

            new RoombaSongNote(RoombaNote.E3, RoombaNoteDuration.EightNote),
            new RoombaSongNote(RoombaNote.D3, RoombaNoteDuration.HalfNote),
            new RoombaSongNote(RoombaNote.Pause, RoombaNoteDuration.QuarterNote),
            new RoombaSongNote(RoombaNote.Pause, RoombaNoteDuration.HalfNote)
    };
    public static RoombaSongNote[] knightrider2 = {
            new RoombaSongNote(RoombaNote.E2, RoombaNoteDuration.EightNote),
            new RoombaSongNote(RoombaNote.F2, RoombaNoteDuration.SixteenthNote),
            new RoombaSongNote(RoombaNote.E2, RoombaNoteDuration.SixteenthNote),
            new RoombaSongNote(RoombaNote.B2, RoombaNoteDuration.QuarterNote),

            new RoombaSongNote(RoombaNote.E3, RoombaNoteDuration.EightNote),
            new RoombaSongNote(RoombaNote.F3, RoombaNoteDuration.SixteenthNote),
            new RoombaSongNote(RoombaNote.E3, RoombaNoteDuration.SixteenthNote),
            new RoombaSongNote(RoombaNote.B2, RoombaNoteDuration.QuarterNote),

            new RoombaSongNote(RoombaNote.E2, RoombaNoteDuration.EightNote),
            new RoombaSongNote(RoombaNote.F2, RoombaNoteDuration.SixteenthNote),
            new RoombaSongNote(RoombaNote.E2, RoombaNoteDuration.SixteenthNote),
            new RoombaSongNote(RoombaNote.B2, RoombaNoteDuration.EightNote),

            new RoombaSongNote(RoombaNote.E3, RoombaNoteDuration.EightNote),
            new RoombaSongNote(RoombaNote.F3, RoombaNoteDuration.HalfNote),
            new RoombaSongNote(RoombaNote.Pause, RoombaNoteDuration.HalfNote)
    };

    public static RoombaSongNote[] imperialMarchFirst = {
            new RoombaSongNote(RoombaNote.E1, RoombaNoteDuration.QuarterNote),
            new RoombaSongNote(RoombaNote.E1, RoombaNoteDuration.QuarterNote),
            new RoombaSongNote(RoombaNote.E1, RoombaNoteDuration.QuarterNote),
            new RoombaSongNote(RoombaNote.C1, RoombaNoteDuration.EightNote),

            new RoombaSongNote(RoombaNote.Pause, RoombaNoteDuration.SixteenthNote),
            new RoombaSongNote(RoombaNote.G1, RoombaNoteDuration.SixteenthNote),
            new RoombaSongNote(RoombaNote.E1, RoombaNoteDuration.QuarterNote),
            new RoombaSongNote(RoombaNote.C1, RoombaNoteDuration.EightNote),

            new RoombaSongNote(RoombaNote.Pause, RoombaNoteDuration.SixteenthNote),
            new RoombaSongNote(RoombaNote.G1, RoombaNoteDuration.SixteenthNote),
            new RoombaSongNote(RoombaNote.E1, RoombaNoteDuration.QuarterNote),
            new RoombaSongNote(RoombaNote.Pause, RoombaNoteDuration.QuarterNote),

            new RoombaSongNote(RoombaNote.B1, RoombaNoteDuration.QuarterNote),
            new RoombaSongNote(RoombaNote.B1, RoombaNoteDuration.QuarterNote),
            new RoombaSongNote(RoombaNote.B1, RoombaNoteDuration.QuarterNote),
            new RoombaSongNote(RoombaNote.C2, RoombaNoteDuration.EightNote)
    };
    public static RoombaSongNote[] imperialMarchSecond = {
            new RoombaSongNote(RoombaNote.Pause, RoombaNoteDuration.SixteenthNote),
            new RoombaSongNote(RoombaNote.G1, RoombaNoteDuration.SixteenthNote),
            new RoombaSongNote(RoombaNote.D1Sharp, RoombaNoteDuration.QuarterNote),
            new RoombaSongNote(RoombaNote.C1, RoombaNoteDuration.EightNote),

            new RoombaSongNote(RoombaNote.Pause, RoombaNoteDuration.SixteenthNote),
            new RoombaSongNote(RoombaNote.G1, RoombaNoteDuration.SixteenthNote),
            new RoombaSongNote(RoombaNote.E1, RoombaNoteDuration.QuarterNote),
            new RoombaSongNote(RoombaNote.Pause, RoombaNoteDuration.EightNote)
    };

    public static RoombaSongNote[] starWarsIntro = {
            new RoombaSongNote(RoombaNote.C1Sharp, RoombaNoteDuration.EightNote),
            new RoombaSongNote(RoombaNote.C1Sharp, RoombaNoteDuration.EightNote),
            new RoombaSongNote(RoombaNote.C1Sharp, RoombaNoteDuration.SixteenthNote),
            new RoombaSongNote(RoombaNote.F1Sharp, RoombaNoteDuration.HalfNote),

            new RoombaSongNote(RoombaNote.C2Sharp, RoombaNoteDuration.HalfNote),
            new RoombaSongNote(RoombaNote.B1, RoombaNoteDuration.EightNote),
            new RoombaSongNote(RoombaNote.A1Sharp, RoombaNoteDuration.SixteenthNote),
            new RoombaSongNote(RoombaNote.G1Sharp, RoombaNoteDuration.EightNote),

            new RoombaSongNote(RoombaNote.F2Sharp, RoombaNoteDuration.HalfNote),
            new RoombaSongNote(RoombaNote.C2Sharp, RoombaNoteDuration.QuarterNote),
            new RoombaSongNote(RoombaNote.B1, RoombaNoteDuration.EightNote),
            new RoombaSongNote(RoombaNote.A1Sharp, RoombaNoteDuration.SixteenthNote),

            new RoombaSongNote(RoombaNote.G1Sharp, RoombaNoteDuration.EightNote),
            new RoombaSongNote(RoombaNote.F2Sharp, RoombaNoteDuration.HalfNote),
            new RoombaSongNote(RoombaNote.C2Sharp, RoombaNoteDuration.QuarterNote),
            new RoombaSongNote(RoombaNote.B1, RoombaNoteDuration.EightNote)
    };

    public static RoombaSongNote[] sandstorm = {
            new RoombaSongNote(RoombaNote.D2, RoombaNoteDuration.SixteenthNote),
            new RoombaSongNote(RoombaNote.D2, RoombaNoteDuration.SixteenthNote),
            new RoombaSongNote(RoombaNote.D2, RoombaNoteDuration.SixteenthNote),
            new RoombaSongNote(RoombaNote.D2, RoombaNoteDuration.SixteenthNote),

            new RoombaSongNote(RoombaNote.D2, RoombaNoteDuration.EightNote),
            new RoombaSongNote(RoombaNote.D2, RoombaNoteDuration.SixteenthNote),
            new RoombaSongNote(RoombaNote.D2, RoombaNoteDuration.SixteenthNote),
            new RoombaSongNote(RoombaNote.D2, RoombaNoteDuration.SixteenthNote),

            new RoombaSongNote(RoombaNote.D2, RoombaNoteDuration.SixteenthNote),
            new RoombaSongNote(RoombaNote.D2, RoombaNoteDuration.SixteenthNote),
            new RoombaSongNote(RoombaNote.D2, RoombaNoteDuration.SixteenthNote),
            new RoombaSongNote(RoombaNote.D2, RoombaNoteDuration.EightNote),

            new RoombaSongNote(RoombaNote.G2, RoombaNoteDuration.SixteenthNote),
            new RoombaSongNote(RoombaNote.G2, RoombaNoteDuration.SixteenthNote),
            new RoombaSongNote(RoombaNote.G2, RoombaNoteDuration.SixteenthNote),
            new RoombaSongNote(RoombaNote.G2, RoombaNoteDuration.SixteenthNote),
    };

    public static RoombaSongNote[] sandstorm2 = {
            new RoombaSongNote(RoombaNote.G2, RoombaNoteDuration.SixteenthNote),
            new RoombaSongNote(RoombaNote.G2, RoombaNoteDuration.SixteenthNote),
            new RoombaSongNote(RoombaNote.G2, RoombaNoteDuration.SixteenthNote),
            new RoombaSongNote(RoombaNote.G2, RoombaNoteDuration.EightNote),

            new RoombaSongNote(RoombaNote.F2, RoombaNoteDuration.SixteenthNote),
            new RoombaSongNote(RoombaNote.F2, RoombaNoteDuration.SixteenthNote),
            new RoombaSongNote(RoombaNote.F2, RoombaNoteDuration.SixteenthNote),
            new RoombaSongNote(RoombaNote.F2, RoombaNoteDuration.SixteenthNote),

            new RoombaSongNote(RoombaNote.F2, RoombaNoteDuration.SixteenthNote),
            new RoombaSongNote(RoombaNote.F2, RoombaNoteDuration.EightNote),
            new RoombaSongNote(RoombaNote.C2, RoombaNoteDuration.SixteenthNote),
            new RoombaSongNote(RoombaNote.C2, RoombaNoteDuration.SixteenthNote),

            new RoombaSongNote(RoombaNote.D2, RoombaNoteDuration.SixteenthNote),
            new RoombaSongNote(RoombaNote.D2, RoombaNoteDuration.SixteenthNote),
            new RoombaSongNote(RoombaNote.D2, RoombaNoteDuration.SixteenthNote),
            new RoombaSongNote(RoombaNote.D2, RoombaNoteDuration.SixteenthNote),
    };

    public static RoombaSongNote[] sandstorm3 = {
            new RoombaSongNote(RoombaNote.D2, RoombaNoteDuration.EightNote),
            new RoombaSongNote(RoombaNote.D2, RoombaNoteDuration.SixteenthNote),
            new RoombaSongNote(RoombaNote.D2, RoombaNoteDuration.SixteenthNote),
            new RoombaSongNote(RoombaNote.D2, RoombaNoteDuration.SixteenthNote),

            new RoombaSongNote(RoombaNote.D2, RoombaNoteDuration.SixteenthNote),
            new RoombaSongNote(RoombaNote.D2, RoombaNoteDuration.SixteenthNote),
            new RoombaSongNote(RoombaNote.D2, RoombaNoteDuration.SixteenthNote),
            new RoombaSongNote(RoombaNote.D2, RoombaNoteDuration.EightNote),

            new RoombaSongNote(RoombaNote.F2, RoombaNoteDuration.SixteenthNote),
            new RoombaSongNote(RoombaNote.D2, RoombaNoteDuration.SixteenthNote),
            new RoombaSongNote(RoombaNote.D2, RoombaNoteDuration.SixteenthNote),
            new RoombaSongNote(RoombaNote.D2, RoombaNoteDuration.SixteenthNote),

            new RoombaSongNote(RoombaNote.D2, RoombaNoteDuration.SixteenthNote),
            new RoombaSongNote(RoombaNote.D2, RoombaNoteDuration.EightNote)
    };
    public static RoombaSongNote[] furElise = {
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

    public static void furElise(RoombaJSSC roomba)
    {
        // Save to song number 0, tempo (in BPM) 125
        roomba.song(0, furElise, 125);
        // Play song 0
        roomba.play(0);
    }

    public static void knightRider(RoombaJSSC roomba)
    {
        roomba.song(0, knightrider, 126);
        roomba.song(1, knightrider2, 126);
        roomba.play(0);

        roomba.digitLedsAscii('K', 'I', 'T', 'T'); // Shows message on digit leds

        char[] text = "KNIGHT RIDER   ".toCharArray();
        int current = 0;


        for(int x = 0; x < 6; x++) {
            for (int j = 0; j < 7; j++) {
                boolean[] days = {false, false, false, false, false, false, false};
                days[j] = true;
                roomba.schedulingLeds(days[0], days[1], days[2], days[3], days[4], days[5], days[6], false, false, false, false, false);
                roomba.sleep(150);
            }

            current++;
            System.out.println(current);
            if(current==12)
                current = 0;
            roomba.digitLedsAscii(text[current+0], text[current+1], text[current+2], text[current+3]);

            for (int j = 5; j > 0; j--) {
                boolean[] days = {false, false, false, false, false, false, false};
                days[j] = true;
                roomba.schedulingLeds(days[0], days[1], days[2], days[3], days[4], days[5], days[6], false, false, false, false, false);
                roomba.sleep(150);
            }

            current++;
            System.out.println(current);
            if(current==12)
                current = 0;
            roomba.digitLedsAscii(text[current+0], text[current+1], text[current+2], text[current+3]);

            System.out.println(x);
            if(x == 2)
                roomba.play(1);
            if(x == 5)
                roomba.play(0);
        }
    }

    public static void sandstorm(RoombaJSSC roomba)
    {
        roomba.song(0, sandstorm, 112);
        roomba.song(1, sandstorm2, 112);
        roomba.song(2, sandstorm3, 112);

        roomba.play(0);
        roomba.sleep(2600);
        roomba.play(1);
        roomba.sleep(2600);
        roomba.play(2);
        roomba.sleep(2400);
    }

    public static void imperialMarch(RoombaJSSC roomba)
    {
        roomba.digitLedsAscii('R', '2', 'D', '2'); // Shows message on digit leds
        roomba.song(0, imperialMarchFirst, 100);
        roomba.song(1, imperialMarchSecond, 100);
        roomba.play(0);

        int quarter = 300;
        int eight = 150;
        int sixteen = 75;
        moveForward(roomba, quarter);
        moveForward(roomba, quarter);
        moveForward(roomba, quarter);
        moveForward(roomba, eight);

        //moveForward(roomba, sixteen);
        moveForward(roomba, sixteen);
        moveForward(roomba, quarter);
        moveForward(roomba, eight);

        //moveForward(roomba, sixteen);
        moveForward(roomba, sixteen);
        moveForward(roomba, quarter);
        //moveForward(roomba, quarter);
        roomba.sleep(600);


        roomba.digitLedsAscii('C', '3', 'P', '0'); // Shows message on digit leds
        moveBackward(roomba, quarter);
        moveBackward(roomba, quarter);
        moveBackward(roomba, quarter);
        moveBackward(roomba, eight);
        roomba.sleep(220);

        roomba.play(1);

        //moveForward(roomba, sixteen);
        moveBackward(roomba, sixteen);
        moveBackward(roomba, quarter);
        moveBackward(roomba, eight);

        //moveForward(roomba, sixteen);
        moveBackward(roomba, sixteen);
        moveBackward(roomba, quarter);
    }

    private static void moveForward(RoombaJSSC roomba, int time)
    {
        roomba.drive(40, 0);
        roomba.sleep(time);
        roomba.drive(0, 0);
        roomba.sleep(time);
    }
    private static void moveBackward(RoombaJSSC roomba, int time)
    {
        roomba.drive(-40, 0);
        roomba.sleep(time);
        roomba.drive(0, 0);
        roomba.sleep(time);
    }
}
