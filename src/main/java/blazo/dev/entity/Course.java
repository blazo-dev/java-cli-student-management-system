package blazo.dev.entity;

import java.util.concurrent.atomic.AtomicInteger;

public class Course {
    private static final AtomicInteger counter = new AtomicInteger(1);
    private String name;
    private final int id;

    public Course(String name) {
        this.name = name;
        this.id = counter.getAndIncrement();
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

    @Override
    public String toString() {
        return String.format("{\"id\"=\"%d\", \"name\"=\"%s\"}", id, name);
    }
}
