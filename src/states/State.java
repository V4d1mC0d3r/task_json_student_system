package states;

import main_app.Student;
import main_app.StudentDatabase;

public abstract class State {
    protected StudentDatabase studentDatabase;

    public State(StudentDatabase studentDatabase) {
        this.studentDatabase = studentDatabase;
    }

    public abstract void addStudent(Student student);

    public abstract void removeStudent(int id);

    public abstract void findStudent(int id);

    public abstract void saveToFile(Student filename);

    public abstract void loadFromFile(Student filename);
}
