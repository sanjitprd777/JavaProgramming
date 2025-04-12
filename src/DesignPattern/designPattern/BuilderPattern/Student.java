package BuilderPattern;

import BuilderPattern.StudentBuilder.StudentBuilder;

public class Student {
    int id;
    String name;
    String section;
    String fatherName;
    String motherName;

    public Student() {}

    public Student(StudentBuilder studentBuilder) {
        this.id = studentBuilder.getId();
        this.name = studentBuilder.getName();
        this.section = studentBuilder.getSection();
        this.fatherName = studentBuilder.getFatherName();
        this.motherName = studentBuilder.getMotherName();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSection() {
        return section;
    }

    public void setSection(String section) {
        this.section = section;
    }

    public String getFatherName() {
        return fatherName;
    }

    public void setFatherName(String fatherName) {
        this.fatherName = fatherName;
    }

    public String getMotherName() {
        return motherName;
    }

    public void setMotherName(String motherName) {
        this.motherName = motherName;
    }
}
