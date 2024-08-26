package main_app;

import states.State;
import java.util.ArrayList;
import java.util.List;

public class StudentDatabase {
    private List<Student> students;
    private State currentState;

    public StudentDatabase() {
        this.students = new ArrayList<>();
    }

    public void setCurrentState(State currentState) {
        this.currentState = currentState;
    }

    public void addStudent(Student student) {
        currentState.addStudent(student);
    }

    public void removeStudent(int id) {
        currentState.removeStudent(id);
    }

    public Student findStudentById(int id) {
        return currentState.findStudentById(id);
    }

    public void saveToFile(String filename) {
        currentState.saveToFile(filename);
    }

    public void loadFromFile(String filename) {
        currentState.loadFromFile(filename);
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }
}
