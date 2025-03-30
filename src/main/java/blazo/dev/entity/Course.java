package blazo.dev.entity;

public class Course {
    private static int counter = 1;
    private String name;
    private final int id;

    public Course(String name) {
        this.name = name;
        this.id = counter;

        counter++;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void displayInfo() {
        System.out.printf("📌 ID: %-5d | 📛 Name: %s%n", id, name);
    }
}
