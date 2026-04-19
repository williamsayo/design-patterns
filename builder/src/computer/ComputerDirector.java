package computer;

import java.util.List;

public class ComputerDirector {
    ComputerBuilder computerBuilder;

    public ComputerDirector(ComputerBuilder builder) {
        this.computerBuilder = builder;
    }

    public void setBuilder(ComputerBuilder builder) {
        this.computerBuilder = builder;
    }

    public void buildGamingComputer(){
        this.computerBuilder.buildOperatingSystem("Windows 11 Pro").buildProcessor("Intel Core i9-14900K (24 cores, 6.0 GHz Boost)").buildHardDrive("2 TB NVMe PCIe 5.0 SSD").buildRAM(64).buildGraphicsCard("NVIDIA GeForce RTX 4090 (24 GB GDDR6X)");
    }

    public void buildGamingComputer(List<String> accessories){
        buildGamingComputer();
        System.out.println(accessories);
        for(String accessory : accessories){
            this.computerBuilder.addAccessory(accessory);
        }
    }

    public void buildOfficeComputer(){
        this.computerBuilder.buildOperatingSystem("Windows 10 Home").buildProcessor("Intel Core i5-13400 (10 cores, 4.6 GHz Boost)").buildHardDrive("512 GB SATA SSD").buildRAM(8).buildGraphicsCard("Intel UHD Graphics 730 (Integrated)");
    }

    public void buildOfficeComputer(List<String> accessories){
        buildOfficeComputer();
        for(String accessory : accessories){
            this.computerBuilder.addAccessory(accessory);
        }
    }
}
