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

    public RollResultsEvent(int numArmiesAttackingLost, int numArmiesDefendingLost) {
        verifyQuantities(numArmiesAttackingLost, numArmiesDefendingLost);
        this.numArmiesAttackingLost = numArmiesAttackingLost;
        this.numArmiesDefendingLost = numArmiesDefendingLost;
    }

    private void verifyQuantities(int numArmiesAttackingLost,
                                  int numArmiesDefendingLost) {
        requireThat(numArmiesAttackingLost >= 0 && numArmiesAttackingLost <= 3);
        requireThat(numArmiesDefendingLost >= 0 && numArmiesDefendingLost <= 2);
    }

    public int numArmiesDefendingLost() {
        return numArmiesDefendingLost;
    }

    public int numArmiesAttackingLost() {
        return numArmiesAttackingLost;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof RollResultsEvent)) {
            return false;
        }
        RollResultsEvent other = (RollResultsEvent) obj;
        return other.numArmiesAttackingLost == numArmiesAttackingLost &&
               other.numArmiesDefendingLost == numArmiesDefendingLost;
    }

    @Override
    public int hashCode() {
        return numArmiesDefendingLost*31 + numArmiesAttackingLost;
    }
}
