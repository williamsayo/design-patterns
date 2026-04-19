package maps;


import tiles.ForestTile;
import tiles.SwampTile;
import tiles.Tile;
import tiles.WaterTile;

public class WildernessMap extends Map {

    @Override
    public Tile createTile() {
        int choice = this.random.nextInt(3);

        if (choice == 0) return new WaterTile();
        if (choice == 1) return new ForestTile();
        return new SwampTile();
    }
    
}
