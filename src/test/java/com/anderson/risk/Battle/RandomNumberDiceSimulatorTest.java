package com.anderson.risk.Battle;

import com.anderson.risk.DiceSimulator.RandomNumberDiceSimulator;
import org.junit.*;

import static junit.framework.Assert.assertTrue;

/**
 * Created by matthewanderson on 12/28/16.
 */
public class RandomNumberDiceSimulatorTest {

    @Test
    public void testRoll() {
        RandomNumberDiceSimulator randomNumberDiceSimulator = new RandomNumberDiceSimulator();
        for(int i=0; i<100; i++) {
            assertTrue(randomNumberDiceSimulator.roll() <= 6);
            assertTrue(randomNumberDiceSimulator.roll() >= 1);
        }
    }

    @Ignore
    public void testDistribution() {
        RandomNumberDiceSimulator randomNumberDiceSimulator = new RandomNumberDiceSimulator();
        int[] rolls = new int[6];
        for(int i=0; i<1000; i++) {
            int roll = randomNumberDiceSimulator.roll();
            rolls[roll - 1] += 1;
        }
        for(int i=0; i<rolls.length; i++) {
            System.out.println(i + 1 + " -> " + rolls[i]);
        }
    }
}