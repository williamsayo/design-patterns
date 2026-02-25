package factory_method;

import factory_method.tiles.BuildingTile;
import factory_method.tiles.ForestTile;
import factory_method.tiles.RoadTile;
import factory_method.tiles.Tile;

class CityMap extends Map {
    @Override
    public Tile createTile() {
        int choice = this.random.nextInt(3);

        if (choice == 0) return new RoadTile();
        if (choice == 1) return new BuildingTile();
        return new ForestTile();
    }
}