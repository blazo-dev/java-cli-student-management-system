package blazo.dev.entity;

public class Person {
    private static int counter = 1;

    private final int id;
    private String name;
    private byte age;
    String email;

    public Person(String name, byte age, String email) {
        this.id = counter;
        this.name = name;
        this.age = age;
        this.email = email;

        counter++;
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
        System.out.printf("📌 ID: %-5d | 📛 Name: %s%n", id, name);
    }

}
