import maps.Map;
import maps.WildernessMap;

/**
 * Game is the entry point for the RPG Map Generator application.
 * It launches a JavaFX GUI that displays maps using the Flyweight pattern
 * for efficient tile rendering.
 */
public class Game {
    public static void main(String[] args) {
        // Launch the JavaFX GUI application
        Gui.main(args);
    }

    /**
     * Utility method to create a map (kept for backward compatibility)
     */
    public static WildernessMap createMap() {
        return new WildernessMap();
    }
}
