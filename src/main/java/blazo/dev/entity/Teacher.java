package blazo.dev.entity;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class Teacher extends Person {
    private String subject;
    private ArrayList<Course> courses;

    public Teacher(String name, byte age, String email, String subject, ArrayList<Course> courses) {
        super(name, age, email);
        this.subject = subject;
        this.courses = new ArrayList<>(courses);
    }


    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public ArrayList<Course> getCourses() {
        return courses;
    }

    public void setCourses(ArrayList<Course> courses) {
        this.courses = courses;
    }

    public void addCourse(Course course) {
        if (courses.size() < 3) {
            courses.add(course);
        } else {
            System.out.println("A teacher can teach a maximum of 3 courses.");
        }
    }

    public Course getCourse(int index) {
        return courses.size() > index ? courses.get(index) : null;
    }

    @Override
    public String toString() {
        return String.format("{\"id\"=\"%d\", \"name\"=\"%s\", \"subject\"=\"%s\"}", getId(), getName(), getSubject());
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.printf("📚 Courses: %s%n", coursesToString());
    }

    private String coursesToString() {
        return courses.stream().map(Course::getName).collect(Collectors.joining(", "));
    }

}
