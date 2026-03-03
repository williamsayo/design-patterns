package state.game;

import state.State;
import state.levels.Expert;
import state.levels.Intermediate;
import state.levels.Master;
import state.levels.Novice;

import java.util.Random;
import java.util.Scanner;

public class GameCharacter {
    private Scanner scanner = new Scanner(System.in);

    public final int MAX_HEALTH = 100;
    private final String name;
    private int healthPoint;
    private int  experiencePoint;
    private State level;

    public GameCharacter(String name) {
        this.name = name;
        this.healthPoint = 100;
        this.experiencePoint = 0;
        this.level = new Novice(this);
    }

    public Actions playTurn(String[] options) {
        System.out.println("\n══════════════════════════════════════════════════");
        System.out.println("Character name: " + this.name);
        System.out.println("Level: " + this.level.getCurrentLevel());
        System.out.println("Health Point: " + this.healthPoint);
        System.out.println("Experience Point: " + this.experiencePoint);
        System.out.println("\n══════════════════════════════════════════════════");

        System.out.println("\nSelect an option:");
        for (int i = 1; i <= options.length; i++) {
            System.out.println(i + ". " + options[i-1]);
        }
        // read user input
        int choice = this.scanner.nextInt();
        return Actions.fromValue(choice);
    }

    public State getLevel() {
        return this.level;
    }

    public void setLevel(State level) {
        this.level = level;
    }

    public void setExperiencePoint(int experiencePoint) {
        this.experiencePoint = experiencePoint;
    }

    public void setHealthPoint(int healthPoint) {
        this.healthPoint = healthPoint;
    }

    public int getExperiencePoint() {
        return this.experiencePoint;
    }

    public int getHealthPoint() {
        return this.healthPoint;
    }

    public String getName() {
        return this.name;
    }

    public boolean isAlive(){
        if (this.healthPoint <= 0){
            System.out.println(this.name + " is dead");
            scanner.close();
            return false;
        }
        return true;
    }

    public boolean isMaster(){
        boolean isMaster = this.level instanceof Master;
        if (!isMaster){
            return false;
        }
        System.out.println("🏆 Congratulations! You are master");
        System.out.printf("%s has slayed the demon king and conquered the game",this.name);
        return true;
    }
}
