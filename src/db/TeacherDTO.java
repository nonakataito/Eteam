public class TeacherDTO {
    private int id;
    private String name;
    private String subject;

    // getterとsetter
}
public interface TeacherDAO {
    void insertTeacher(TeacherDTO teacher);
    TeacherDTO getTeacherById(int id);
    List<TeacherDTO> getAllTeachers();
    void updateTeacher(TeacherDTO teacher);
    void deleteTeacher(int id);
}
