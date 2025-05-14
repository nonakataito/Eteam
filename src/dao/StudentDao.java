package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import bean.ClassNum;
import bean.School;
import bean.Student;

public class StudentDao extends Dao {

    public List<Student> filter(School school, int enterYear, String classNum, boolean isAttend) throws Exception {
        List<Student> list = new ArrayList<>();
        String sql = "SELECT * FROM student WHERE school_cd=? AND enter_year=? AND class_num=? AND is_attend=?";
        try (Connection conn = getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, school.getCd());
            stmt.setInt(2, enterYear);
            stmt.setString(3, classNum);
            stmt.setBoolean(4, isAttend);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Student student = new Student();
                student.setNo(rs.getString("no"));
                student.setName(rs.getString("name"));
                student.setEnterYear(rs.getInt("enter_year"));
                student.setAttend(rs.getBoolean("is_attend"));

                // 学校とクラス情報をセット
                School s = new School();
                s.setCd(rs.getString("school_cd"));
                student.setSchool(s); // 修正

                ClassNum cn = new ClassNum();
                cn.setClassNum(rs.getString("class_num"));
                student.setClassNum(cn);

                list.add(student);
            }
        }
        return list;
    }

    public boolean save(Student student) throws Exception {
        String sql = "INSERT INTO student (no, name, enter_year, class_num, is_attend, school_cd) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection conn = getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, student.getNo());
            stmt.setString(2, student.getName());
            stmt.setInt(3, student.getEnterYear());
            stmt.setString(4, student.getClassNum().getClassNum());
            stmt.setBoolean(5, student.isAttend());
            stmt.setString(6, student.getSchool().getCd());

            int result = stmt.executeUpdate();
            return result > 0;
        }
    }
}
