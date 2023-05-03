package de.nilskoeb.bedwars.manager;

import de.nilskoeb.bedwars.enums.EGameState;

public class GameStateManager {

    private EGameState currentState;

    public GameStateManager() {
        this.currentState = EGameState.LOBBY;
    }

    public void setGameState(EGameState currentState) {
        this.currentState = currentState;
    }

    public EGameState getCurrentState() {
        return currentState;
    }
}
