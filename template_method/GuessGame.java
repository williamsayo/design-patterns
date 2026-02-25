package template_method;

import java.util.Random;
import java.util.Scanner;

public class GuessGame extends Game {
    int guess;
    Random random;
    int num;
    Scanner scanner;
    int currentPlayer;

    @Override
    public void initializeGame(int numberOfPlayers) {
        System.out.println("Initializing Guess the Number Game for " + numberOfPlayers + " players.");
        this.random = new Random();
        this.num = random.nextInt(10);
        this.scanner =  new Scanner(System.in);
    }

    @Override
    public boolean endOfGame() {
        boolean endGame = guess == num;
        if (endGame){
        this.scanner.close();
        }
        return endGame;
    }

    @Override
    public void playSingleTurn(int player) {
        currentPlayer = player;
        System.out.println("Player " + currentPlayer +" is taking their turn.");
        System.out.printf("Guess a number between 1 and 10: ");
        this.guess = scanner.nextInt();
    }

    @Override
    public void displayWinner() {
        System.out.printf("Congratulations player %s you are the winner of the Guess Number Game.",currentPlayer);
    }
    
}
