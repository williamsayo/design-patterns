package filesystem;

import java.util.ArrayList;
import java.util.List;

public class Directory implements FileSystemElement{
    private final String name;
    private final double size = 1;

    private List<FileSystemElement> children;

    public Directory(String name) {
        this.children = new ArrayList<>();
        this.name = name;
    }

    public List<FileSystemElement> getChildren(){
        return this.children;
    }

    public void addChild(FileSystemElement child) {
        this.children.add(child);
    }

    public void removeChild(FileSystemElement child) {
        this.children.remove(child);
    }

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
