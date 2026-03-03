package state.levels;

import state.State;
import state.game.Actions;
import state.game.GameAction;
import state.game.GameCharacter;

public class Intermediate extends State implements GameAction {
    private static final int XP_TO_ADVANCE = 55;

    public Intermediate(GameCharacter character) {
        super(character,"Intermediate");
    }

    @Override
    public void train(){
        System.out.printf("%s trains in the abyss of the dungeon",this.character.getName());
        this.character.setExperiencePoint(this.character.getExperiencePoint() + 2);
    }

    @Override
    public void meditate(){
        if (this.character.getHealthPoint() == this.character.MAX_HEALTH){
            System.out.printf("%s has max health, cannot meditate",this.character.getName());
            return;
        }
        System.out.printf("%s meditates in the mountain of whispering peace",this.character.getName());
        this.character.setHealthPoint(Math.min(this.character.getHealthPoint() + 10, this.character.MAX_HEALTH));
    }

    @Override
    public void checkLevelUp(){
        if(this.character.getExperiencePoint() >= XP_TO_ADVANCE){
            this.character.setLevel(new Expert(this.character));
        }
    }

    @Override
    public void fight(){
        System.out.println("Character cannot fight level too low");
    }

    @Override
    public void action(){
        String[] options = {"Train","Meditate","Fight"};
        switch (this.character.playTurn(options)) {
            case Actions.TRAIN:
                this.train();
                checkLevelUp();
                break;
            case Actions.MEDITATE:
                this.meditate();
                checkLevelUp();
                break;
            case Actions.FIGHT:
                this.fight();
                break;
            default:
                System.out.println("Invalid action, Try again");
                break;
        }
    }
}
