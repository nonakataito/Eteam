package db;
public class TeacherDTO {
    private int id;
    private String name;
    private String subject;

    // getterとsetter
}
public interface TeacherDAO {
    void insertTeacher(TeacherDAO teacher);
    TeacherDAO getTeacherById(int id);
    List<TeacherDAO> getAllTeachers();
    void updateTeacher(TeacherDAO teacher);
    void deleteTeacher(int id);
}
