package db;

import java.util.List;
public interface TeacherDAO extends DAO{
    void insertTeacher(TeacherDAO teacher);
    TeacherDAO getTeacherById(int id);
    List<TeacherDAO> getAllTeachers();
    void updateTeacher(TeacherDAO teacher);
    void deleteTeacher(int id);
}
