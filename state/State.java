package state;

import state.game.GameCharacter;

public abstract class State {
    public final GameCharacter character;
    private String level;

    public State(GameCharacter gameCharacter, String levelName) {
        this.character = gameCharacter;
        this.level = levelName;
    }

    public String getCurrentLevel(){
        return this.level;
    }

    public GameCharacter getCharacter() {
        return character;
    }

    public abstract void action();
}
