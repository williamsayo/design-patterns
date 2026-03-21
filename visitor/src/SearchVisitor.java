import filesystem.Directory;
import filesystem.File;
import filesystem.FileSystemElement;
import filesystem.FileSystemVisitor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SearchVisitor implements FileSystemVisitor {
    List<String> result = new ArrayList<>();
    @Override
    public void visit(File file) {
        if (file.getName().endsWith(".txt")) {
            result.add(file.getName());
        }
    }

    @Override
    public void visit(Directory directory) {
        for (FileSystemElement children: directory.getChildren()){
            children.accept(this);
        }
    }

    public void printResult(){
        System.out.println("Found text files: " + result.size());
        System.out.println(Arrays.toString(result.toArray()));
    }
}
