package computer;

import java.util.ArrayList;
import java.util.List;

public class GamingComputerBuilder implements ComputerBuilder {
    private double ram;
    private String hardDrive;
    private String operatingSystem;
    private String graphicsCard;
    private String processor;
    private List<String> accessories;

    public GamingComputerBuilder() {
        this.accessories = new ArrayList<>();
    }

    @Override
    public ComputerBuilder buildProcessor(String processor) {
        this.processor = processor;
        return this;
    }

    @Override
    public ComputerBuilder buildRAM(double ram) {
        this.ram = ram;
        return this;
    }

    @Override
    public ComputerBuilder buildGraphicsCard(String graphicsCard) {
        this.graphicsCard = graphicsCard;
        return this;
    }

    @Override
    public ComputerBuilder buildOperatingSystem(String operatingSystem) {
        this.operatingSystem = operatingSystem;
        return this;
    }

    @Override
    public ComputerBuilder buildHardDrive(String hardDrive) {
        this.hardDrive = hardDrive;
        return this;
    }

    @Override
    public ComputerBuilder addAccessory(String accessory) {
        this.accessories.add(accessory);
        return this;
    }

    @Override
    public Computer buildComputer() {
        return new Computer(this.processor, this.ram, this.hardDrive, this.graphicsCard, this.operatingSystem, this.accessories);
    }
}
