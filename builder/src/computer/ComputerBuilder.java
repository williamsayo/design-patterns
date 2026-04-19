package computer;

public interface ComputerBuilder {
    ComputerBuilder buildProcessor(String processor);
    ComputerBuilder buildRAM(double ram);
    ComputerBuilder buildGraphicsCard(String graphicsCard);
    ComputerBuilder buildOperatingSystem(String operatingSystem);
    ComputerBuilder buildHardDrive(String hardDrive);
    ComputerBuilder addAccessory(String accessory);
    Computer buildComputer();
}
