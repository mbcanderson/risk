package com.anderson.risk;

import static java.util.Objects.requireNonNull;

/**
 * Created by matthewanderson on 12/28/16.
 */
public class Player {

    private final String playerName;

    public Player(String playerName) {
        this.playerName = requireNonNull(playerName);
    }
}
