package com.anderson.risk.Battle;

import com.anderson.risk.Player;
import com.anderson.risk.Territory;

import static com.anderson.risk.Util.ArgsUtil.requireThat;
import static java.util.Objects.requireNonNull;

/**
 * Created by matthewanderson on 12/28/16.
 */
public class Battle {

    private final Territory territory;
    private final Player attacker;
    private final Player defender;

    private final int attackerNumDice;
    private final int defenderNumDice;

    public Battle(Territory territory, Player attacker, int attackerNumDice, int defenderNumDice) {
        this.territory = requireNonNull(territory);
        this.attacker = requireNonNull(attacker);
        this.defender = requireNonNull(territory.occupant());
        verifyNumDice(attackerNumDice, defenderNumDice);
        this.attackerNumDice = attackerNumDice;
        this.defenderNumDice = defenderNumDice;
    }

    private void verifyNumDice(int attackerNumDice, int defenderNumDice) {
        requireThat(attackerNumDice > 0 && attackerNumDice <= 3);
        requireThat(defenderNumDice > 0 && defenderNumDice <= 2);
    }

    public void roll() {

    }

}
