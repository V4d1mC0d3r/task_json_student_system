package main_app;

import java.util.List;

public class StudentDatabase {
    private List<Student> students;

    public void addStudent(Student student) {
        students.add(student);
    }
    public void removeStudent(int id) {
        students.remove(id);
    }

    public void findStudentById(int id) {
        for (Student student : students) {
            if (student.getId() == id) {
                System.out.println(student);
            }
        }
    }

    public void saveToFile(String filename) {
        //Сохраняет данные студента в json файл
    }

    public void loadFromFile(String filename) {
        //загружает из файла json в объект типа java.
    }

    //Паттерн состояния вроде делается через интерфейс, или абстрактный класс state например и пошло поехало.
    //Исключения просто создать свои и все и через блок try catch сделать.
}
