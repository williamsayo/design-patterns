import computer.Computer;
import computer.ComputerBuilder;
import computer.ComputerDirector;
import computer.GamingComputerBuilder;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        ComputerBuilder gamingComputerBuilder = new GamingComputerBuilder();
        ComputerDirector director = new ComputerDirector(gamingComputerBuilder);
        director.buildGamingComputer();
        Computer gamingComputer =gamingComputerBuilder.buildComputer();
        System.out.println(gamingComputer.toString());
    }
}
