package com.anderson.risk.DiceSimulator;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * Created by matthewanderson on 12/28/16.
 */
public class PredeterminedDiceSimulator implements DiceSimulator {

    private final int numTotalRolls;
    private int currRoll;
    private final List<Integer> rolls;

    public PredeterminedDiceSimulator(int... rolls) {
        this.rolls = new ArrayList<>();
        for (int roll : rolls) {
            this.rolls.add(roll);
        }
        this.currRoll = 0;
        this.numTotalRolls = rolls.length;
    }

    @Override
    public int roll() {
        if (currRoll >= numTotalRolls) {
            throw new RuntimeException("No more rolls left in this PredeterminedDiceSimulator");
        }
        int roll = rolls.get(currRoll);
        currRoll++;
        return roll;
    }

}
