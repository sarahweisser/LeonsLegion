package com.leonslegion.casino;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by sarahweisser on 5/11/17.
 */
public class TestSlotMachine {

    @Test
    public void testMatchImages() {

        //given
        SlotMachine machine = new SlotMachine();
        boolean expectedResult = true;

        //when
        boolean actualResult = machine.matchImages();

        //then
        //Assert.assertEquals(expectedResult, actualResult);

    }

    @Test
    public void testDetermineWinningsLemon() {

        //given
        SlotMachine machine = new SlotMachine();
        double expectedResult = 500;

        //when
        double actualResult = machine.determineWinnings("Lemon");

        //then
        Assert.assertEquals(expectedResult, actualResult, 0);

    }

    @Test
    public void testDetermineWinningsDoubleBar() {

        //given
        SlotMachine machine = new SlotMachine();
        double expectedResult = 1000;

        //when
        double actualResult = machine.determineWinnings("Double Bar");

        //then
        Assert.assertEquals(expectedResult, actualResult, 0);

    }

    @Test
    public void testDetermineWinningsTripleBar() {

        //given
        SlotMachine machine = new SlotMachine();
        double expectedResult = 2000;

        //when
        double actualResult = machine.determineWinnings("Triple Bar");

        //then
        Assert.assertEquals(expectedResult, actualResult, 0);

    }

    @Test
    public void testDetermineWinningsLuckySeven() {

        //given
        SlotMachine machine = new SlotMachine();
        double expectedResult = 5000;

        //when
        double actualResult = machine.determineWinnings("Lucky Seven");

        //then
        Assert.assertEquals(expectedResult, actualResult, 0);

    }

    @Test
    public void testPullLever() {

        //given

        SlotMachine machine = new SlotMachine();

        do {

            machine = new SlotMachine();
            machine.pullLever();
        } while (machine.matchImages() != true);
    }
}