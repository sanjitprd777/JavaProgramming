package CompositePattern.FileSystem;

import java.util.ArrayList;
import java.util.List;

public class Directory implements FileDirectory {

    String name;
    List<FileDirectory> fileDirectories;

    public Directory(String name) {
        this.name = name;
        fileDirectories = new ArrayList<>();
    }

    public void addDirectory(FileDirectory fileDirectory) {
        fileDirectories.add(fileDirectory);
    }

    @Override
    public void ls() {
        System.out.println("Directory name: " + name);
        for (FileDirectory fileDirectory : fileDirectories) {
            fileDirectory.ls();
        }
    }
}
