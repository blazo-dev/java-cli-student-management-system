package blazo.dev.entity;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class Student extends Person {
    private int grade;
    private ArrayList<Course> courses;

    public Student(String name, byte age, String email, int grade, ArrayList<Course> courses) {
        super(name, age, email);
        this.grade = grade;
        this.courses = new ArrayList<>(courses);
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public ArrayList<Course> getCourses() {
        return courses;
    }

    public void setCourses(ArrayList<Course> courses) {
        this.courses = courses;
    }

    public void addCourse(Course course) {
        if (courses.size() < 5) {
            courses.add(course);
        } else {
            System.out.println("A student can enroll in a maximum of 5 courses.");
        }
    }

    public Course getCourse(int index) {
        return courses.size() > index ? courses.get(index) : null;
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.printf("🎓 Grade: %d | 📚 Courses: %s%n", grade, coursesToString());
    }

    private String coursesToString() {
        return courses.stream().map(Course::getName).collect(Collectors.joining(", "));
    }


    @Override
    public String toString() {
        return String.format("{\"id\"=\"%d\", \"name\"=\"%s\", \"grade\"=\"%d\"}", getId(), getName(), grade);
    }

}
