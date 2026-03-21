import filesystem.Directory;
import filesystem.File;

public class Main {
    public static void main(String[] args) {

        Directory directory = new Directory("Metropolia");
        directory.addChild(new File("dsa.pdf",10));
        directory.addChild(new File("sep1.java",30));
        directory.addChild(new File("sep2.txt",2));

        Directory subDirectory = new Directory("Design Patterns");
        subDirectory.addChild(new File("design_patterns.txt",20));
        subDirectory.addChild(new File("finnish.txt",5));
        directory.addChild(subDirectory);


        SearchVisitor search = new SearchVisitor();
        SearchVisitor search2 = new SearchVisitor();
        directory.accept(search);
        search.printResult();

        SizeCalculatorVisitor sizeCalculator = new SizeCalculatorVisitor();
        directory.accept(sizeCalculator);
        sizeCalculator.printResult();
    }
}
