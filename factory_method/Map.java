package factory_method;

import java.util.Random;

import factory_method.tiles.Tile;

public abstract class Map {
    Random random = new Random();

    public void display(){
        Tile tile = createTile();
        System.out.printf("%s for %s",tile.getCharacter(),tile.getType());
    }

    public abstract Tile createTile();

}