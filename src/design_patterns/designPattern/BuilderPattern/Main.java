package BuilderPattern;

import BuilderPattern.StudentBuilder.StudentBuilder;

public class Main {

    public static void main(String[] args) {
        StudentBuilder studentBuilder = new StudentBuilder();
        Student student = studentBuilder.setId(1).setName("Sahil").build();
        System.out.println("Student details");
        System.out.println(student.getId());
        System.out.println(student.getName());

        System.out.println("==========================================================");
        Student student1 = studentBuilder.setId(2).setName("Sanjit").build();
        System.out.println("Student details");
        System.out.println(student1.getId());
        System.out.println(student1.getName());
    }
}
