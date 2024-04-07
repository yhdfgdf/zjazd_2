import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        Student student1 = new Student("John Smith");
        student1.grades.add(4.5);
        student1.grades.add(3.0);

        Student student2 = new Student("Alice Johnson");
        student2.grades.add(5.0);
        student2.grades.add(4.0);


        StudentGroup group = new StudentGroup("Group A");
        group.addStudent(student1);
        group.addStudent(student2);


        System.out.println("Average grade for " + student1.name + ": " + student1.calculateAverage());
        System.out.println("Average grade for " + student2.name + ": " + student2.calculateAverage());
    }
}

class Student {
    public String name;
    public List<Double> grades;

    public Student(String name) {
        this.name = name;
        this.grades = new ArrayList<>();
    }

    public double calculateAverage() {
        if (grades.isEmpty()) {
            throw new IllegalArgumentException("Student doesn't have any grades.");
        }

        double sum = 0;
        for (Double grade : grades) {
            sum += grade;
        }

        double average = sum / grades.size();

        double roundedAverage = Math.round(average * 2) / 2.0;
        return roundedAverage;
    }
}

class StudentGroup {
    private String groupName;
    private List<Student> students;

    public StudentGroup(String groupName) {
        this.groupName = groupName;
        this.students = new ArrayList<>();
    }

    public void addStudent(Student student) {
        if (students.size() >= 15) {
            throw new IllegalStateException("Maximum number of students in the group.");
        }

        if (students.contains(student)) {
            throw new IllegalStateException("Student is already in the group.");
        }

        students.add(student);
    }
}