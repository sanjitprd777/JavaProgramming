package CompositePattern.FileSystem;

public class File implements FileDirectory {

    String name;

    public File(String name) {
        this.name = name;
    }

    @Override
    public void ls() {
        System.out.println("File name: " + name);
    }
}
