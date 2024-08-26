package states;

import com.google.gson.Gson;
import exceptions.StudentNotFoundException;
import main_app.Student;
import main_app.StudentDatabase;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.util.Arrays;
import java.util.List;

public class EditingState implements State {
    private final StudentDatabase studentDatabase;

    public EditingState(StudentDatabase studentDatabase) {
        this.studentDatabase = studentDatabase;
    }

    @Override
    public void addStudent(Student student) {
        studentDatabase.getStudents().add(student);
    }

    @Override
    public void removeStudent(int id) throws StudentNotFoundException {
        Student student = findStudentById(id);
        studentDatabase.getStudents().remove(student);
    }

    @Override
    public Student findStudentById(int id) throws StudentNotFoundException {
        return studentDatabase.getStudents().stream()
                .filter(student -> student.getId() == id)
                .findFirst()
                .orElseThrow(() -> new StudentNotFoundException("Student with ID " + id + " not found."));
    }

    @Override
    public void saveToFile(String filename) {
        Gson gson = new Gson();
        try (FileWriter writer = new FileWriter(filename)) {
            gson.toJson(studentDatabase.getStudents(), writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void loadFromFile(String filename) {
        Gson gson = new Gson();
        try (Reader reader = new FileReader(filename)) {
            List<Student> students = Arrays.asList(gson.fromJson(reader, Student[].class));
            studentDatabase.setStudents(students);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
