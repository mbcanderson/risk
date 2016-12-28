package com.anderson.risk.Battle;

import com.anderson.risk.DiceSimulator.DiceSimulator;
import com.anderson.risk.DiceSimulator.PredeterminedDiceSimulator;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by matthewanderson on 12/28/16.
 */
public class RollTest {

    @Test
    public void oneDieEach() {
        DiceSimulator simulator = new PredeterminedDiceSimulator(1, 1);
        Roll roll = new Roll(1, 1, simulator);
        checkResult(1, 0, roll);

        simulator = new PredeterminedDiceSimulator(1, 4);
        roll = new Roll(1, 1, simulator);
        checkResult(1, 0, roll);

        simulator = new PredeterminedDiceSimulator(6, 4);
        roll = new Roll(1, 1, simulator);
        checkResult(0, 1, roll);
    }

    @Test
    public void threeAgainstTwo() {
        DiceSimulator simulator = new PredeterminedDiceSimulator(6, 6, 6, 6, 5);
        Roll roll = new Roll(3, 2, simulator);
        checkResult(1, 1, roll);

        simulator = new PredeterminedDiceSimulator(3, 4, 5, 6, 5);
        roll = new Roll(3, 2, simulator);
        checkResult(2, 0, roll);

        simulator = new PredeterminedDiceSimulator(2, 2, 2, 1, 1);
        roll = new Roll(3, 2, simulator);
        checkResult(0, 2, roll);
    }

    private void checkResult(int expectedNumAttackingLost, int expectedNumDefendingLost, Roll roll) {
        RollResultsEvent expectedResults = new RollResultsEvent(expectedNumAttackingLost, expectedNumDefendingLost);
        assertEquals(expectedResults, roll.results());
    }
}