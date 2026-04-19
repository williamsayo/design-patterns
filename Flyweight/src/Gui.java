import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import maps.Map;
import maps.MapRenderer;
import maps.WildernessMap;
import maps.CityMap;
import tiles.TileGraphicFactory;

/**
 * Gui is a JavaFX Application that displays RPG maps graphically using
 * the Flyweight pattern for efficient tile rendering.
 */
public class Gui extends Application {
    private MapRenderer mapRenderer;
    private Canvas mapCanvas;
    private Label statsLabel;

    @Override
    public void start(Stage window) {
        window.setTitle("RPG Map Generator - Flyweight Pattern");

        // Create main layout
        BorderPane root = new BorderPane();

        // Create control panel at the top
        HBox controlPanel = createControlPanel(window);
        root.setTop(controlPanel);

        // Create canvas for map rendering
        mapCanvas = new Canvas(800, 600);
        root.setCenter(mapCanvas);

        // Create info panel at the bottom
        VBox infoPanel = createInfoPanel();
        root.setBottom(infoPanel);

        // Create and display the initial map
        createAndRenderMap("wilderness");

        // Create scene and display window
        Scene scene = new Scene(root, 900, 750);
        window.setScene(scene);
        window.show();

        // Print flyweight statistics
        TileGraphicFactory.getInstance().printStatistics();
    }

    /**
     * Creates the control panel with buttons and options
     */
    private HBox createControlPanel(Stage primaryStage) {
        HBox panel = new HBox(10);
        panel.setPadding(new Insets(10));
        panel.setStyle("-fx-border-color: #cccccc; -fx-border-width: 0 0 1 0;");

        Label mapTypeLabel = new Label("Map Type:");
        ComboBox<String> mapTypeCombo = new ComboBox<>();
        mapTypeCombo.getItems().addAll("Wilderness", "City");
        mapTypeCombo.setValue("Wilderness");

        Button generateButton = new Button("Generate Map");
        generateButton.setOnAction(e -> {
            String selectedType = mapTypeCombo.getValue().toLowerCase();
            createAndRenderMap(selectedType);
        });

        Button exitButton = new Button("Exit");
        exitButton.setOnAction(e -> primaryStage.close());

        panel.getChildren().addAll(mapTypeLabel, mapTypeCombo, generateButton, exitButton);
        return panel;
    }

    /**
     * Creates the information panel showing statistics
     */
    private VBox createInfoPanel() {
        VBox panel = new VBox(5);
        panel.setPadding(new Insets(10));
        panel.setStyle("-fx-border-color: #cccccc; -fx-border-width: 1 0 0 0;");

        Label titleLabel = new Label("Flyweight Pattern Information");
        titleLabel.setStyle("-fx-font-weight: bold; -fx-font-size: 12;");

        statsLabel = new Label(getStatisticsText());
        statsLabel.setStyle("-fx-font-size: 10; -fx-font-family: monospace;");
        statsLabel.setWrapText(true);

        panel.getChildren().addAll(titleLabel, statsLabel);
        return panel;
    }

    /**
     * Creates a new map and renders it on the canvas
     */
    private void createAndRenderMap(String mapType) {
        // Create map based on selected type
        Map map;
        if ("city".equalsIgnoreCase(mapType)) {
            map = new CityMap();
        } else {
            map = new WildernessMap();
        }

        // Display map in console for debugging
        map.display();

        // Create renderer
        double tileSize = 40;
        mapRenderer = new MapRenderer(map, mapCanvas, tileSize);

        // Resize canvas to fit the map
        mapCanvas.setWidth(mapRenderer.getRequiredCanvasWidth());
        mapCanvas.setHeight(mapRenderer.getRequiredCanvasHeight());

        // Render the map
        mapRenderer.render();

        // Update statistics
        statsLabel.setText(getStatisticsText());
    }

    /**
     * Generates the statistics text for display
     */
    private String getStatisticsText() {
        if (mapRenderer == null) {
            return "No map loaded";
        }

        Map map = mapRenderer.getMap();
        int totalTiles = map.getMapWidth() * map.getMapHeight();
        int uniqueGraphics = TileGraphicFactory.getInstance().getGraphicsCount();
        
        return String.format(
                "Map: %s\n" +
                "Dimensions: %d x %d = %d tiles\n" +
                "Tile Size: %.0f pixels\n" +
                "Unique Tile Graphics: %d\n" +
                "Memory Optimization: All %d tiles share %d graphics",
                map.getClass().getSimpleName(),
                map.getMapWidth(),
                map.getMapHeight(),
                totalTiles,
                mapRenderer.getTileSize(),
                uniqueGraphics,
                totalTiles,
                uniqueGraphics
        );
    }

    public static void main(String[] args) {
        launch(args);
    }
}