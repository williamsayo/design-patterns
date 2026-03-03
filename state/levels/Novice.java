package state.levels;


import state.State;
import state.game.Actions;
import state.game.GameAction;
import state.game.GameCharacter;

public class Novice extends State implements GameAction {
    private static final int XP_TO_ADVANCE = 30;
    public Novice(GameCharacter character) {
        super(character, "Novice");
    }

    @Override
    public void train(){
        System.out.printf("%s trains in the halls of olympus",this.character.getName());
        this.character.setExperiencePoint(this.character.getExperiencePoint() + 10);
    }

    @Override
    public void meditate(){
        System.out.println("Character cannot meditate level too low");
    }

    @Override
    public void fight(){
        System.out.println("Character cannot fight level too low");
    }

    @Override
    public void checkLevelUp(){
        if(this.character.getExperiencePoint() >= XP_TO_ADVANCE){
            this.character.setLevel(new Intermediate(this.character));
        }
    }

    @Override
    public void action(){
        String[] options = {"Train","Meditate","Fight"};
        switch (this.character.playTurn(options)) {
            case Actions.TRAIN:
                train();
                checkLevelUp();
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
    }
}
