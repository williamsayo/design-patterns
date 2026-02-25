package factory_method;

import factory_method.tiles.ForestTile;
import factory_method.tiles.SwampTile;
import factory_method.tiles.Tile;
import factory_method.tiles.WaterTile;

public class WildernessMap extends Map {

    @Override
    public Tile createTile() {
        int choice = this.random.nextInt(3);

        if (choice == 0) return new WaterTile();
        if (choice == 1) return new ForestTile();
        return new SwampTile();
    }
    
}
