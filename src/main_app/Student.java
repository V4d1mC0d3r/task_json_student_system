package main_app;

import exceptions.InvalidStudentDataException;

public class Student {
    private int id;
    private String name;
    private int age;
    private String major;

    public Student(int id, String name, int age, String major) {
        if (age < 0) {
            throw new InvalidStudentDataException("Age cannot be negative");
        }
        this.id = id;
        this.name = name;
        this.age = age;
        this.major = major;
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (age < 0) {
            throw new InvalidStudentDataException("Age cannot be negative");
        }
        this.age = age;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", major='" + major + '\'' +
                '}';
    }
}
