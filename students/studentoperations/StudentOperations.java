package students.studentoperations;

import students.Student;

public interface StudentOperations {

    void insertStudent(Student s);

    void removeStudent(Student s);

    Student getStudent(String studentId);

    void showAllStudents();

}