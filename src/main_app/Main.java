package main_app;

/*
Задание: Управление данными студентов с использованием JSON и библиотеки Gson
Описание
Создайте систему управления данными студентов, которая позволяет добавлять, удалять и искать студентов.
Система должна использовать JSON для хранения данных и библиотеку Gson для работы с JSON.
Реализуйте систему с использованием паттерна "Состояние".

Требования

Класс main_app.Student:
Представляет студента.
Свойства:
id (int): уникальный идентификатор студента.
name (String): имя студента.
age (int): возраст студента.
major (String): специальность студента.
Конструктор для инициализации всех свойств.
Геттеры и сеттеры для всех свойств.

Класс main_app.StudentDatabase:
Управляет данными студентов.
Свойства:
students (List<main_app.Student>): список студентов.
Методы:
addStudent(main_app.Student student): добавляет студента в базу данных.
removeStudent(int id): удаляет студента по идентификатору.
findStudentById(int id): ищет студента по идентификатору.
saveToFile(String filename): сохраняет данные студентов в JSON файл.
loadFromFile(String filename): загружает данные студентов из JSON файла.
Паттерн "Состояние":

Используйте паттерн "Состояние" для изменения поведения системы в зависимости от её текущего состояния
(например, "Редактирование", "Просмотр", "Удаление").

Исключения:
StudentNotFoundException: выбрасывается, когда студент с заданным идентификатором не найден.
InvalidStudentDataException: выбрасывается, когда данные студента некорректны (например, отрицательный возраст).*/

import states.EditingState;
import states.ViewingState;

public class Main {
    public static void main(String[] args) {
        StudentDatabase database = new StudentDatabase();

        // Устанавливаем режим редактирования и загружаем данные
        database.setCurrentState(new EditingState(database));
        database.loadFromFile("students.json");

        // Переключаемся в режим просмотра
        database.setCurrentState(new ViewingState(database));
        Student student = database.findStudentById(1);
        System.out.println(student);
    }
}

