package factory_method.tiles;

public class SwampTile implements Tile {

    @Override
    public char getCharacter() {
        return 'S';
    }

    @Override
    public String getType() {
        return "swamp";
    }
    
}
