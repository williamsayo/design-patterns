package factory_method.tiles;

public class BuildingTile implements Tile {

    @Override
    public char getCharacter() {
           return 'B';
        }

    @Override
    public String getType() {
        return "building";
    }
    
}
