import filesystem.Directory;
import filesystem.File;
import filesystem.FileSystemElement;
import filesystem.FileSystemVisitor;

public class SizeCalculatorVisitor implements FileSystemVisitor {
    double totalSize = 0;
    @Override
    public void visit(File file) {
        totalSize += file.getSize();
    }

    @Override
    public void visit(Directory directory) {
        for (FileSystemElement children: directory.getChildren()) {
            children.accept(this);
        }
    }

    public void printResult() {
        System.out.println("Total size of files: " + totalSize);
    }
}
