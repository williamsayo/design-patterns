package filesystem;

public class File implements FileSystemElement{
    private final String name;
    private final double size;

    public File(String name, int size){
        this.name = name;
        this.size = size;
    }

    @Override
    public String getName() {
        return this.name;
    }

    public double getSize() {
        return this.size;
    }

    @Override
    public void accept(FileSystemVisitor visitor) {
        visitor.visit(this);
    }
}
