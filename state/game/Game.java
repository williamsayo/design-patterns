package state.game;

public class Game {
    private final GameCharacter gameCharacter;

    public Game(){
        this.gameCharacter = new GameCharacter("Kratos the brave");
    }

    public void startGame(){
        while (this.gameOver()) {
            this.gameCharacter.getLevel().action();
        }
    }

    public boolean gameOver(){
        if (this.gameCharacter.getLevel() == null) {
            System.out.println("Game character level out of bounds!");
            return false;
        }

        return this.gameCharacter.isAlive() && !(this.gameCharacter.isMaster());
    }

}
