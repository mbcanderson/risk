package com.anderson.risk.Battle;

import com.anderson.risk.DiceSimulator.DiceSimulator;
import com.anderson.risk.DiceSimulator.RandomNumberDiceSimulator;

import javax.swing.*;
import java.awt.*;
import java.util.Collections;
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

    private final RollWindow rollWindow;


    Roll(int numAttackingDice, int numDefendingDice) {
        this(numAttackingDice, numDefendingDice, new RandomNumberDiceSimulator());
    }

    Roll(int numAttackingDice, int numDefendingDice, DiceSimulator diceSimulator) {
        verifyQuantities(numAttackingDice, numDefendingDice);
        this.numAttackingDice = numAttackingDice;
        this.numDefendingDice = numDefendingDice;
        this.diceSimulator = requireNonNull(diceSimulator);
        this.rollWindow = new RollWindow();
    }

    private void verifyQuantities(int numAttackingDice, int numDefendingDice) {
        requireThat(numAttackingDice <= 3 && numAttackingDice >= 1);
        requireThat(numDefendingDice <= 2 && numDefendingDice >= 1);
    }

    RollResultsEvent results() {
        PriorityQueue<Integer> attackingRolls = simulateNAttackRolls(numAttackingDice);
        PriorityQueue<Integer> defendingRolls = simulateNDefendRolls(numDefendingDice);
        RollResultsEvent resultsEvent = determineResultsAndGenerateEvent(attackingRolls, defendingRolls);
        rollWindow.display(resultsEvent.numArmiesAttackingLost(), resultsEvent.numArmiesDefendingLost());
        return resultsEvent;
    }

    private RollResultsEvent determineResultsAndGenerateEvent(PriorityQueue<Integer> attackingRolls,
                                                              PriorityQueue<Integer> defendingRolls) {
        int numAttackingRolls = attackingRolls.size();
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
        return new RollResultsEvent(numAttackingLost, numDefendingLost, numAttackingRolls);
    }

    private PriorityQueue<Integer> simulateNAttackRolls(int n) {
        PriorityQueue<Integer> rolls = new PriorityQueue<>(Collections.reverseOrder());
        for (int i=0; i<n; i++) {
            int value = diceSimulator.roll();
            rolls.add(value);
            rollWindow.addAttackerDie(value);
        }
        return rolls;
    }

    private PriorityQueue<Integer> simulateNDefendRolls(int n) {
        PriorityQueue<Integer> rolls = new PriorityQueue<>(Collections.reverseOrder());
        for (int i=0; i<n; i++) {
            int value = diceSimulator.roll();
            rolls.add(value);
            rollWindow.addDefenderDie(value);
        }
        return rolls;
    }
}
