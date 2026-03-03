package state.levels;

import state.State;
import state.game.Actions;
import state.game.GameAction;
import state.game.GameCharacter;

import java.util.Random;

public class Expert extends State implements GameAction {
    private static final int XP_TO_ADVANCE = 100;
    public Expert(GameCharacter character) {
        super(character,"Expert");
    }

    @Override
    public void train(){
        System.out.printf("%s trains with the wizard king",this.character.getName());
        this.character.setExperiencePoint(this.character.getExperiencePoint() + 15);
    }

    @Override
    public void meditate(){
        int healthPoint = this.character.getHealthPoint();
        if (healthPoint != this.character.MAX_HEALTH) {
            System.out.printf("%s meditates in the mountain of whispering peace", this.character.getName());
            this.character.setHealthPoint(Math.min(healthPoint + 5, this.character.MAX_HEALTH));
        } else {
            System.out.printf("%s has max health, cannot meditate", this.character.getName());
        }
    }

    @Override
    public void fight(){
        Random random = new Random();
        System.out.println(this.character.getName()+" fights Cerberus the 3 headed beast");
        this.character.setExperiencePoint(this.character.getExperiencePoint() + random.nextInt(10));
        this.character.setHealthPoint(this.character.getHealthPoint() - random.nextInt(80));
    }

    @Override
    public void checkLevelUp(){
        if(this.character.getExperiencePoint() >= XP_TO_ADVANCE){
            this.character.setLevel(new Master(this.character));
        }
    }

    public void action(){
        String[] options = {"Train","Meditate","Fight"};
        switch (this.character.playTurn(options)) {
            case Actions.TRAIN:
                train();
                break;
            case Actions.MEDITATE:
                meditate();
                break;
            case Actions.FIGHT:
                fight();
                break;
            default:
                System.out.println("Invalid action, Try again");
                break;
        }
        checkLevelUp();
    }
}
