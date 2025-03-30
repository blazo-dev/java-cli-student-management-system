package blazo.dev.entity;

import java.util.concurrent.atomic.AtomicInteger;

public class Person {
    private static final AtomicInteger counter = new AtomicInteger(1);

    private final int id;
    private String name;
    private byte age;
    private String email;

    public Person(String name, byte age, String email) {
        this.id = counter.getAndIncrement();
        this.name = name;
        this.age = age;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public byte getAge() {
        return age;
    }

    public void setAge(byte age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void displayInfo() {
        System.out.printf("📌 ID: %-5d | 📛 Name: %-5s | 📧 Email: %s%n", id, name, email);
    }

}
