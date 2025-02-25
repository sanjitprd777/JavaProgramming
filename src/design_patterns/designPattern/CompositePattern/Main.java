package CompositePattern;

import CompositePattern.FileSystem.Directory;
import CompositePattern.FileSystem.File;
import CompositePattern.FileSystem.FileDirectory;

public class Main {

    public static void main(String[] args) {

        Directory directory = new Directory("Movies");
        Directory directory1 = new Directory("Sci-Fi");
        Directory directory2 = new Directory("Action");
        File file = new File("Avengers");
        directory1.addDirectory(file);
        file = new File("Bahubali");
        directory2.addDirectory(file);
        file = new File("Sahoo");
        directory2.addDirectory(file);
        directory.addDirectory(directory1);
        directory.addDirectory(directory2);

        directory.ls();
    }
}
