package com.anderson.risk;

import org.junit.*;

import static junit.framework.Assert.assertTrue;

/**
 * Created by matthewanderson on 12/28/16.
 */
public class DiceSimulatorTest {

    @Test
    public void testRoll() {
        DiceSimulator diceSimulator = new DiceSimulator();
        for(int i=0; i<100; i++) {
            assertTrue(diceSimulator.roll() <= 6);
            assertTrue(diceSimulator.roll() >= 1);
        }
    }

    @Ignore
    public void testDistribution() {
        DiceSimulator diceSimulator = new DiceSimulator();
        int[] rolls = new int[6];
        for(int i=0; i<1000; i++) {
            int roll = diceSimulator.roll();
            rolls[roll - 1] += 1;
        }
        for(int i=0; i<rolls.length; i++) {
            System.out.println(i + 1 + " -> " + rolls[i]);
        }
    }
}