package com.anderson.risk.DiceSimulator;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by matthewanderson on 12/28/16.
 */
public class PredeterminedDiceSimulatorTest {

    @Test(expected = RuntimeException.class)
    public void throwsErrorAfterRollingAll() {
        PredeterminedDiceSimulator predeterminedDiceSimulator = new PredeterminedDiceSimulator(1, 2);
        predeterminedDiceSimulator.roll();
        predeterminedDiceSimulator.roll();
        predeterminedDiceSimulator.roll();
    }

    @Test
    public void inCorrectOrder() {
        PredeterminedDiceSimulator simulator = new PredeterminedDiceSimulator(1, 6, 3, 5, 4, 1, 1);
        assertEquals(1, simulator.roll());
        assertEquals(6, simulator.roll());
        assertEquals(3, simulator.roll());
        assertEquals(5, simulator.roll());
        assertEquals(4, simulator.roll());
        assertEquals(1, simulator.roll());
        assertEquals(1, simulator.roll());
    }
}