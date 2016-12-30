package com.anderson.risk.Battle;

import com.anderson.risk.Player;

import static com.anderson.risk.Util.ArgsUtil.requireThat;
import static java.util.Objects.requireNonNull;

/**
 * Created by matthewanderson on 12/28/16.
 */
public class RollResultsEvent {

    private final int numArmiesAttackingLost;
    private final int numArmiesDefendingLost;
    private final int numAttackingDiceRolled;

    public RollResultsEvent(int numArmiesAttackingLost, int numArmiesDefendingLost, int numAttackingDiceRolled) {
        verifyQuantities(numArmiesAttackingLost, numArmiesDefendingLost, numAttackingDiceRolled);
        this.numArmiesAttackingLost = numArmiesAttackingLost;
        this.numArmiesDefendingLost = numArmiesDefendingLost;
        this.numAttackingDiceRolled = numAttackingDiceRolled;
    }

    private void verifyQuantities(int numArmiesAttackingLost,
                                  int numArmiesDefendingLost,
                                  int numAttackingDiceRolled) {
        requireThat(numArmiesAttackingLost >= 0 && numArmiesAttackingLost <= 3);
        requireThat(numArmiesDefendingLost >= 0 && numArmiesDefendingLost <= 2);
        requireThat(numAttackingDiceRolled >= 1 && numAttackingDiceRolled <= 3);
    }

    public int numArmiesDefendingLost() {
        return numArmiesDefendingLost;
    }

    public int numArmiesAttackingLost() {
        return numArmiesAttackingLost;
    }

    public int numAttackingDiceRolled() {
        return numAttackingDiceRolled;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof RollResultsEvent)) {
            return false;
        }
        RollResultsEvent other = (RollResultsEvent) obj;
        return other.numArmiesAttackingLost == numArmiesAttackingLost &&
               other.numArmiesDefendingLost == numArmiesDefendingLost &&
               other.numAttackingDiceRolled == numAttackingDiceRolled;
    }

    @Override
    public int hashCode() {
        return numArmiesDefendingLost*31 + numArmiesAttackingLost *31*31 + numAttackingDiceRolled;
    }
}
