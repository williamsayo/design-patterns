package filesystem;

public interface FileSystemElement {
    String getName();
    double getSize();
    void accept(FileSystemVisitor visitor);
}
