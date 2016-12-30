package com.anderson.risk.Battle;

import com.anderson.risk.Territory;

import javax.swing.*;

import static com.anderson.risk.Util.FileUtil.iconFromImagesFile;
import static java.util.Objects.requireNonNull;

/**
 * Created by matthewanderson on 12/28/16.
 */
public class BattleManager {

    private final Battle battle;

    private final Territory attackingTerritory;
    private final Territory defendingTerritory;

    public BattleManager(Territory attackingTerritory, Territory defendingTerritory) {
        this.battle = new Battle(attackingTerritory, defendingTerritory);
        this.attackingTerritory = requireNonNull(attackingTerritory);
        this.defendingTerritory = requireNonNull(defendingTerritory);
    }

    public void startBattle() {
        roll();
    }

    private void roll() {
        RollResultsEvent rollResultsEvent = battle.roll();
        removeKilledArmies(rollResultsEvent);
        if (attackingTerritory.numOccupyingArmies() <= 1) {
            // defense wins!
        } else if (!defendingTerritory.hasOccupanyingArmies()) {
            int numArmiesToOccupy = showConfirmationOfAttackWinAndGetNumArmiesToMoveIn(rollResultsEvent.numAttackingDiceRolled());
        } else {
            int response = attackerContinueInput();
            if (response == JOptionPane.YES_OPTION) {
                roll();
            }
        }
    }

    private void removeKilledArmies(RollResultsEvent rollResultsEvent) {
        if (rollResultsEvent.numArmiesAttackingLost() > 0) {
            attackingTerritory.removeArmies(rollResultsEvent.numArmiesAttackingLost());
        }
        if (rollResultsEvent.numArmiesDefendingLost() > 0) {
            defendingTerritory.removeArmies(rollResultsEvent.numArmiesDefendingLost());
        }
    }

    private int attackerContinueInput() {
        return JOptionPane.showConfirmDialog(
                new JFrame(),
                "The attacker has  " + attackingTerritory.numOccupyingArmies() + "  remaining armies.\n\n" +
                        "The defender has  " + defendingTerritory.numOccupyingArmies() + "  remaining armies.\n\n" +
                        "Attacker: would you like to continue?",
                "Continue?",
                JOptionPane.YES_NO_OPTION);
    }

    private int showConfirmationOfAttackWinAndGetNumArmiesToMoveIn(int numAttackingDiceRolled) {
        Integer[] options = new Integer[attackingTerritory.numOccupyingArmies() - numAttackingDiceRolled];
        for(int i=0; i<options.length; i++) {
            options[i] = numAttackingDiceRolled+i;
        }
        Integer i = (Integer) JOptionPane.showInputDialog(
                new JFrame(),
                "Attack has won the territory! You have " + attackingTerritory.numOccupyingArmies() + "  remaining armies." +
                        "You must move at least as many armies as you dice you rolled (" + numAttackingDiceRolled +
                        ") and must leave at least 1 army behind",
                "Attacker",
                JOptionPane.PLAIN_MESSAGE,
                iconFromImagesFile("swords"),
                options,
                numAttackingDiceRolled);
        return i;
    }
}
