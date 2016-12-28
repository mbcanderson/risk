package com.anderson.risk.Battle;

import com.anderson.risk.DiceSimulator.DiceSimulator;
import com.anderson.risk.DiceSimulator.RandomNumberDiceSimulator;

import java.util.PriorityQueue;

import static com.anderson.risk.Util.ArgsUtil.requireThat;
import static java.util.Objects.requireNonNull;

/**
 * Created by matthewanderson on 12/28/16.
 */
public class Roll {

    private final int numAttackingDice;
    private final int numDefendingDice;

    private final DiceSimulator diceSimulator;

    Roll(int numAttackingDice, int numDefendingDice) {
        this(numAttackingDice, numDefendingDice, new RandomNumberDiceSimulator());
    }

    Roll(int numAttackingDice, int numDefendingDice, DiceSimulator diceSimulator) {
        verifyQuantities(numAttackingDice, numDefendingDice);
        this.numAttackingDice = numAttackingDice;
        this.numDefendingDice = numDefendingDice;
        this.diceSimulator = requireNonNull(diceSimulator);
    }

    private void verifyQuantities(int numAttackingDice, int numDefendingDice) {
        requireThat(numAttackingDice <= 3 && numAttackingDice >= 1);
        requireThat(numDefendingDice <= 2 && numDefendingDice >= 1);
    }

    RollResultsEvent results() {
        PriorityQueue<Integer> attackingRolls = new PriorityQueue<>();
        PriorityQueue<Integer> defendingRolls = new PriorityQueue<>();
        simulateNRolls(attackingRolls, numAttackingDice);
        simulateNRolls(defendingRolls, numDefendingDice);
        return determineResultsAndGenerateEvent(attackingRolls, defendingRolls);
    }

    private RollResultsEvent determineResultsAndGenerateEvent(PriorityQueue<Integer> attackingRolls,
                                                              PriorityQueue<Integer> defendingRolls) {
        int numAttackingLost = 0;
        int numDefendingLost = 0;
        while (!defendingRolls.isEmpty() && !attackingRolls.isEmpty()) {
            int highestAttackingRoll = attackingRolls.poll();
            int highestDefendingRoll = defendingRolls.poll();
            if (highestAttackingRoll > highestDefendingRoll) {
                numDefendingLost++;
            } else {
                numAttackingLost++;
            }
        }
        return new RollResultsEvent(numAttackingLost, numDefendingLost);
    }

    private void simulateNRolls(PriorityQueue<Integer> rolls, int n) {
        for (int i=0; i<n; i++) {
            rolls.add(diceSimulator.roll());
        }
    }
}
