package state.levels;

import state.State;
import state.game.GameAction;
import state.game.GameCharacter;

public class Master extends State implements GameAction {
    public Master(GameCharacter character) {
        super(character,"Master");
    }

    @Override
    public void action() {
        System.out.println("Not implemented yet");
    }

    @Override
    public void train(){
        System.out.println("Not implemented yet");
    }
    @Override
    public void meditate(){
        System.out.println("Not implemented yet");
    }
    @Override
    public void fight(){
        System.out.println("Not implemented yet");
    }

    @Override
    public void checkLevelUp() {
        System.out.println("Not implemented yet");
    }
}
