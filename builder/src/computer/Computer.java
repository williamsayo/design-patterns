package computer;

import java.util.ArrayList;
import java.util.List;

public class Computer {
    private String processor;
    private double ram;
    private String hardDrive;
    private String graphicsCard;
    private String operatingSystem;
    private List<String> accessories;

    public Computer(String processor, double ram, String hardDrive, String graphicsCard, String operatingSystem,List<String> accessories) {
        this.processor = processor;
        this.ram = ram;
        this.hardDrive = hardDrive;
        this.graphicsCard = graphicsCard;
        this.operatingSystem = operatingSystem;
        this.accessories = accessories;
    }

//    public void addAccessories(String accessory) {this.accessories.add(accessory);}
//    public void setProcessor(String processor) {this.processor = processor;}
//    public void setRam(double ram) {this.ram = ram;}
//    public void setHardDrive(String hardDrive) {this.hardDrive = hardDrive;}
//    public void setGraphicsCard(String graphicsCard) {this.graphicsCard = graphicsCard;}
//    public void setOperatingSystem(String operatingSystem) {this.operatingSystem = operatingSystem;}

    public String toString() {
        String border = "═".repeat(52);
        StringBuilder sb = new StringBuilder();
        sb.append("\n╔").append(border).append("╗\n");
        sb.append(formatLine("COMPUTER CONFIGURATION"));
        sb.append("╠").append(border).append("╣\n");
        sb.append(formatField("Processor",       processor));
        sb.append(formatField("RAM",             ram + " GB"));
        sb.append(formatField("Hard Drive",      hardDrive));
        sb.append(formatField("Graphics Card",   graphicsCard != null ? graphicsCard : "N/A (Integrated)"));
        sb.append(formatField("Operating System",operatingSystem));
        if (!accessories.isEmpty()) {
            sb.append("╠").append(border).append("╣\n");
            sb.append(formatLine("ACCESSORIES"));
            for (String acc : accessories) {
                sb.append(formatField("  +", acc));
            }
        }
        sb.append("╚").append(border).append("╝\n");
        return sb.toString();
    }

    private String formatLine(String title) {
        int padding = (52 - title.length()) / 2;
        return "║" + " ".repeat(padding) + title + " ".repeat(52 - padding - title.length()) + "║\n";
    }

    private String formatField(String label, String value) {
        String entry = String.format("  %-18s: %s", label, value);
        // Truncate or pad to fit the border width of 52
        if (entry.length() > 52) entry = entry.substring(0, 52);
        return "║" + String.format("%-52s", entry) + "║\n";
    }
}
