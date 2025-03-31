package blazo.dev.app;

import blazo.dev.entity.Course;
import blazo.dev.entity.Person;
import blazo.dev.entity.Student;
import blazo.dev.entity.Teacher;
import blazo.dev.ui.Messages;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class AppManager {
    private static final Scanner scanner = new Scanner(System.in);
    private static final ArrayList<Student> students = new ArrayList<>();
    private static final ArrayList<Teacher> teachers = new ArrayList<>();
    private static final ArrayList<Course> courses = new ArrayList<>();

    private AppManager() throws Exception {
        throw new Exception("This class cannot be instantiated.");
    }

    public static void runApp() {
        Messages.displayTitle("Welcome to the Student Management App!");


        while (true) try {
            Menu.displayMenu();

            int userChoice = getUserChoice();
            handleChoice(userChoice);
        } catch (InputMismatchException e) {
            System.out.println("❌ Invalid input. Please enter a valid number.");
            scanner.nextLine();
        } catch (Exception e) {
            System.out.println("❌ An unexpected error occurred: " + e.getMessage());
        }

    }

    private static void exitApp() {
        Messages.displayTitle("Thank you for using the Student Management App! Have a productive day!");
        System.exit(0);
    }

    public static int getUserChoice() {
        int choice;
        System.out.print("🔢 Please provide your choice: ");
        choice = scanner.nextInt();
        scanner.nextLine(); // Buffer
        return choice;
    }

    public static void handleChoice(int userChoice) {
        switch (userChoice) {
            case 1:
                addPerson("student");
                break;
            case 2:
                addPerson("teacher");
                break;
            case 3:
                addCourse();
                break;
            case 4:
                assignCoursesToStudent();
                break;
            case 5:
                assignCoursesToTeacher();
                break;
            case 6:
                searchStudentById();
                break;
            case 7:
                displayAllPeople();
                break;
            case 8:
                displayCourses();
                break;
            case 9:
                updateStudent();
                break;
            case 10:
                deleteStudent();
                break;
            case 11:
                exitApp();
                break;
            default:
                System.out.println("Invalid option. Please try again.");
        }
    }

    private static void addPerson(String type) {
        System.out.println("✨ Please provide the required details to add a new " + type + ". 📋");

        System.out.print("Please enter the " + type + "'s name: ");
        String name = scanner.nextLine();

        System.out.print("Please enter the " + type + "'s age: ");
        byte age = scanner.nextByte();
        scanner.nextLine();  // Clean buffer

        System.out.print("Please enter the " + type + "'s email: ");
        String email = scanner.nextLine();

        ArrayList<Course> personCourses = addCourses(type);

        if (type.equals("student")) {
            System.out.print("Please enter the student's grade: ");
            int grade = scanner.nextInt();
            scanner.nextLine();  // Clean buffer

            Student newStudent = new Student(name, age, email, grade, personCourses);
            students.add(newStudent);
            System.out.println("\n🎉 Student " + name + " has been successfully added!");
        } else if (type.equals("teacher")) {
            System.out.print("Please enter the teacher's subject: ");
            String subject = scanner.nextLine();

            Teacher newTeacher = new Teacher(name, age, email, subject, personCourses);
            teachers.add(newTeacher);
            System.out.println("\n🎉 Teacher " + name + " has been successfully added!");
        }
    }

    private static ArrayList<Course> addCourses(String type) {
        ArrayList<Course> personCourses = new ArrayList<>();
        int maxCourses = (type.equals("student")) ? 5 : 3;

        System.out.print("How many courses is this " + type + " involved with? ");
        int numberOfCourses = scanner.nextInt();
        scanner.nextLine();  // Clean buffer

        if (numberOfCourses > maxCourses) {
            System.out.println("❌ A " + type + " can only take up to " + maxCourses + " courses.");
            return personCourses;  // Return an empty list
        }

        for (int i = 0; i < numberOfCourses; i++) {
            System.out.print("Enter the name of course " + (i + 1) + ": ");
            String courseName = scanner.nextLine();
            personCourses.add(new Course(courseName));
        }

        return personCourses;
    }

    private static void searchStudentById() {
        if (students.isEmpty()) {
            System.out.println("❌ No students available to display.");
            return;
        }

        System.out.println("🔍 Searching for a student...");
        displayPeople(students);

        System.out.print("🔍 Please enter the student ID: ");
        int studentId = scanner.nextInt();
        displayPersonById(studentId, students);
    }

    private static void displayAllPeople() {
        if (students.isEmpty()) {
            System.out.println("\n❌ No students available to display.");
        } else {
            System.out.println("\n📚 Displaying all students:");
            displayPeople(students);
        }

        if (teachers.isEmpty()) {
            System.out.println("\n❌ No teachers available to display.");
        } else {
            System.out.println("\n👨‍🏫 Displaying all teachers:");
            displayPeople(teachers);
        }
    }

    public static void displayPeople(ArrayList<? extends Person> people) {
        for (Person person : people) {
            person.displayInfo();
        }
    }

    public static void displayCourses() {
        for (Course course : courses) {
            course.displayInfo();
        }
    }

    public static void displayPersonById(int id, ArrayList<? extends Person> people) {
        for (Person person : people) {
            if (person.getId() == id) {
                System.out.println("\n📚 Person found:");
                person.displayInfo();
                return;
            }
        }

        System.out.println("\n❌ Nothing found with ID: " + id);
    }

    public static void addCourse() {
        System.out.println("✨ Please provide the required details to add a new course. 📋");

        System.out.print("Please enter the course's name: ");
        String name = scanner.nextLine();

        Course newCourse = new Course(name);
        courses.add(newCourse);

        System.out.println("🎉 Course " + name + " has been successfully added!");
    }

    private static void deleteStudent() {
        if (students.isEmpty()) {
            System.out.println("\n❌ No students available to delete.");
            return;
        }

        System.out.println("\n🔍 Searching for a student...");
        displayPeople(students);

        System.out.print("\n🔍 Please enter the student ID: ");
        int studentId = scanner.nextInt();

        Person student = getPersonById(studentId, students);

        if (student != null) {
            students.remove(student);
            System.out.println("\n✅ Student successfully removed!");
        } else {
            System.out.println("\n❌ No student found with ID: " + studentId);
        }

    }

    private static void updateStudent() {
        if (students.isEmpty()) {
            System.out.println("\n❌ No students available to update.");
            return;
        }

        System.out.println("\n🔍 Searching for a student...");
        displayPeople(students);

        System.out.print("\n🔍 Please enter the student ID: ");
        int studentId = scanner.nextInt();
        scanner.nextLine();

        Student student = (Student) getPersonById(studentId, students);

        if (student != null) {
            System.out.println("\n✏️ Updating student: " + student.getName());

            System.out.print("\nEnter new name (or press Enter to keep '" + student.getName() + "'): ");
            String name = scanner.nextLine();
            if (!name.isEmpty()) {
                student.setName(name);
            }

            System.out.print("Enter new age (or press Enter to keep '" + student.getAge() + "'): ");
            String ageInput = scanner.nextLine();
            if (!ageInput.isEmpty()) {
                byte newAge = Byte.parseByte(ageInput);
                student.setAge(newAge);
            }

            System.out.print("Enter new email (or press Enter to keep '" + student.getEmail() + "'): ");
            String email = scanner.nextLine();
            if (!email.isEmpty()) {
                student.setEmail(email);
            }

            System.out.print("Enter new grade (or press Enter to keep '" + student.getGrade() + "'): ");
            String gradeInput = scanner.nextLine();
            if (!gradeInput.isEmpty()) {
                int newGrade = Integer.parseInt(gradeInput);
                student.setGrade(newGrade);
            }

            System.out.println("\n✅ Student successfully updated!");
        } else {
            System.out.println("\n❌ No student found with ID: " + studentId);
        }

    }

    private static void assignCoursesToStudent() {
        if (students.isEmpty()) {
            System.out.println("\n❌ No students available to assign courses.");
            return;
        }
        if (courses.isEmpty()) {
            System.out.println("\n❌ No courses available to assign.");
            return;
        }

        System.out.println("\n🔍 Assigning Courses to Students...");
        displayPeople(students);

        System.out.print("\nEnter the Student ID: ");
        int studentId = scanner.nextInt();
        scanner.nextLine(); // Clean buffer

        Student student = (Student) getPersonById(studentId, students);
        if (student == null) {
            System.out.println("\n❌ No student found with ID: " + studentId);
            return;
        }

        System.out.println("\n📚 Available Courses:");
        displayCourses();

        while (student.getCourses().size() < 5) {
            System.out.print("\nEnter Course ID to assign (or -1 to stop): ");
            int courseId = scanner.nextInt();
            scanner.nextLine(); // Clean buffer

            if (courseId == -1) break;

            Course course = getCourseById(courseId);
            if (course == null) {
                System.out.println("❌ Invalid course ID.");
                continue;
            }

            if (!student.getCourses().contains(course)) {
                student.getCourses().add(course);
                System.out.println("✅ Course assigned successfully!");
            } else {
                System.out.println("⚠️ This student is already enrolled in that course.");
            }

            if (student.getCourses().size() == 5) {
                System.out.println("\n⚠️ The student has reached the course limit (5).");
                break;
            }
        }
    }

    private static void assignCoursesToTeacher() {
        if (teachers.isEmpty()) {
            System.out.println("\n❌ No teachers available to assign courses.");
            return;
        }
        if (courses.isEmpty()) {
            System.out.println("\n❌ No courses available to assign.");
            return;
        }

        System.out.println("\n🔍 Assigning Courses to Teachers...");
        displayPeople(teachers);

        System.out.print("\nEnter the Teacher ID: ");
        int teacherId = scanner.nextInt();
        scanner.nextLine(); // Clean buffer

        Teacher teacher = (Teacher) getPersonById(teacherId, teachers);
        if (teacher == null) {
            System.out.println("\n❌ No teacher found with ID: " + teacherId);
            return;
        }

        System.out.println("\n📚 Available Courses:");
        displayCourses();

        while (teacher.getCourses().size() < 3) {
            System.out.print("\nEnter Course ID to assign (or -1 to stop): ");
            int courseId = scanner.nextInt();
            scanner.nextLine(); // Clean buffer

            if (courseId == -1) break;

            Course course = getCourseById(courseId);
            if (course == null) {
                System.out.println("❌ Invalid course ID.");
                continue;
            }

            if (!teacher.getCourses().contains(course)) {
                teacher.getCourses().add(course);
                System.out.println("✅ Course assigned successfully!");
            } else {
                System.out.println("⚠️ This teacher is already assigned to that course.");
            }

            if (teacher.getCourses().size() == 3) {
                System.out.println("\n⚠️ The teacher has reached the course limit (3).");
                break;
            }
        }
    }

    private static Course getCourseById(int courseId) {
        for (Course course : courses) {
            if (course.getId() == courseId) {
                return course;
            }
        }
        return null;
    }


    public static Person getPersonById(int id, ArrayList<? extends Person> people) {
        for (Person person : people) {
            if (person.getId() == id) {
                return person;
            }
        }

        return null;
    }
}
