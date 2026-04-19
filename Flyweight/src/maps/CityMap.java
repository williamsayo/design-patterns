package maps;

import tiles.BuildingTile;
import tiles.ForestTile;
import tiles.RoadTile;
import tiles.Tile;

/**
 * CityMap is a concrete map factory that creates random urban terrain.
 * Uses the Factory Method pattern to produce cities with roads, buildings, and parks.
 */
public class CityMap extends Map {
    @Override
    public Tile createTile() {
        int choice = this.random.nextInt(3);

        if (choice == 0) return new RoadTile();
        if (choice == 1) return new BuildingTile();
        return new ForestTile();
    }
}