package states;

import exceptions.StudentNotFoundException;
import main_app.Student;


public interface State {
    void addStudent(Student student);

    void removeStudent(int id) throws StudentNotFoundException;

    Student findStudentById(int id) throws StudentNotFoundException;

    void saveToFile(String filename);

    void loadFromFile(String filename);
}
