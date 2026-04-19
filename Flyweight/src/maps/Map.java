package maps;

import tiles.GridTile;
import tiles.Tile;
import tiles.TileGraphic;
import tiles.TileGraphicFactory;

import java.util.Random;

/**
 * Abstract Map class that generates a 2D grid of terrain tiles.
 * It uses the Factory Method pattern for tile creation and the
 * Flyweight pattern via TileGraphicFactory for graphics optimization.
 */
public abstract class Map {
    protected static final int MAP_WIDTH = 20;
    protected static final int MAP_HEIGHT = 15;
    
    protected GridTile[][] tiles;
    protected Random random = new Random();

    public Map() {
        this.tiles = generateMap();
    }

    /**
     * Generates the map as a 2D grid of tiles.
     * This method creates GridTile instances using tile types from createTile(),
     * and associates each with a shared TileGraphic from TileGraphicFactory.
     */
    private GridTile[][] generateMap() {
        GridTile[][] grid = new GridTile[MAP_HEIGHT][MAP_WIDTH];
        TileGraphicFactory factory = TileGraphicFactory.getInstance();
        
        for (int row = 0; row < MAP_HEIGHT; row++) {
            for (int col = 0; col < MAP_WIDTH; col++) {
                // Create a tile using factory method (gets tile type)
                Tile tileType = createTile();
                
                // Get the shared TileGraphic for this tile type
                TileGraphic graphic = factory.getTileGraphic(tileType.getType());
                
                // Create a GridTile with both intrinsic and extrinsic state
                grid[row][col] = new GridTile(graphic, row, col);
            }
        }
        return grid;
    }

    public GridTile[][] getTiles() {
        return tiles;
    }

    public int getMapWidth() {
        return MAP_WIDTH;
    }

    public int getMapHeight() {
        return MAP_HEIGHT;
    }

    /**
     * Displays the map as text in the console for debugging purposes.
     */
    public void display() {
        System.out.println("\n=== " + this.getClass().getSimpleName() + " ===");
        for (int row = 0; row < MAP_HEIGHT; row++) {
            for (int col = 0; col < MAP_WIDTH; col++) {
                System.out.print(tiles[row][col].getCharacter());
            }
            System.out.println();
        }
    }

    /**
     * Factory method to be implemented by subclasses.
     * Returns the type of tile for a single position.
     */
    public abstract Tile createTile();

}