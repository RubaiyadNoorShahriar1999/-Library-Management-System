package teachers.teacheroperations;

import teachers.Teacher;

public interface TeacherOperations {

    void insertTeacher(Teacher t);

    Teacher getTeacher(String teacherId);

    void showAllTeachers();

}