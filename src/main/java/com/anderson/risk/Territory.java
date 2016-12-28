package com.anderson.risk;

import static com.anderson.risk.Util.ArgsUtil.requireThat;
import static java.util.Objects.requireNonNull;

/**
 * Created by matthewanderson on 12/28/16.
 */
public class Territory {

    private Player occupant;
    private int numOccupyingArmies;

    public void setOccupant(Player occupant, int numOccupyingArmies) {
        this.occupant = requireNonNull(occupant);
        requireThat(numOccupyingArmies > 0, "Number of Occupying Armies must always be > 0 on setting of occupant");
        this.numOccupyingArmies = numOccupyingArmies;
    }

    public void addArmies(int numAddedArmies) {
        requireThat(numAddedArmies > 0, "Number of Added Armies must be > 0");
        numOccupyingArmies += numAddedArmies;
    }

    public void removeArmies(int numRemovedArmies) {
        requireThat(numRemovedArmies > 0, "Number of Removed Armies must be > 0");
        numOccupyingArmies -= numRemovedArmies;
    }

    public boolean hasOccupanyingArmies() {
        return numOccupyingArmies > 0;
    }

    public int numOccupyingArmies() {
        return numOccupyingArmies;
    }

    public Player occupant() {
        return occupant;
    }
}
