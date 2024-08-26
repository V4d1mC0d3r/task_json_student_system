package states;

import main_app.Student;
import main_app.StudentDatabase;
import exceptions.StudentNotFoundException;

public class ViewingState implements State {
    private final StudentDatabase studentDatabase;

    public ViewingState(StudentDatabase studentDatabase) {
        this.studentDatabase = studentDatabase;
    }

    @Override
    public void addStudent(Student student) {
        throw new UnsupportedOperationException("Cannot add student in Viewing state.");
    }

    @Override
    public void removeStudent(int id) {
        throw new UnsupportedOperationException("Cannot remove student in Viewing state.");
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
        throw new UnsupportedOperationException("Cannot save to file in Viewing state.");
    }

    @Override
    public void loadFromFile(String filename) {
        // Здесь должен быть код загрузки файла, если требуется
        throw new UnsupportedOperationException("Cannot load from file in Viewing state.");
    }
}
