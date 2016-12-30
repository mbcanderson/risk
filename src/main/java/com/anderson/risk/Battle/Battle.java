package com.anderson.risk.Battle;

import com.anderson.risk.Territory;

import javax.swing.*;

import static com.anderson.risk.Util.FileUtil.iconFromImagesFile;
import static java.util.Objects.requireNonNull;

/**
 * Created by matthewanderson on 12/28/16.
 */
public class Battle {

    private final Territory attackingTerritory;
    private final Territory defendingTerritory;

    public Battle(Territory attackingTerritory, Territory defendingTerritory) {
        this.attackingTerritory = requireNonNull(attackingTerritory);
        this.defendingTerritory = requireNonNull(defendingTerritory);
    }

    public RollResultsEvent roll() {
        int attackerNumDice = showAttackingDialog();
        int defenderNumDice = showDefendingDialog();
        Roll roll = new Roll(attackerNumDice, defenderNumDice);
        return roll.results();
    }

    int showAttackingDialog() {
        Integer[] options = {1, 2, 3};
        Integer i = (Integer) JOptionPane.showInputDialog(
                new JFrame(),
                "How many armies would you like to attack with?",
                "Attacker",
                JOptionPane.PLAIN_MESSAGE,
                iconFromImagesFile("swords"),
                options,
                3);
        return i;
    }

    int showDefendingDialog() {
        Integer[] options = {1, 2};
        Integer i = (Integer) JOptionPane.showInputDialog(
                new JFrame(),
                "How many armies would you like to defend with?",
                "Defender",
                JOptionPane.PLAIN_MESSAGE,
                iconFromImagesFile("shield"),
                options,
                2);
        return i;
    }

}
