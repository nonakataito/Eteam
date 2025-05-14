package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import bean.School;
import bean.Teacher;

public class TeacherDao extends Dao {

    public Teacher login(String id, String password) throws Exception {
        Teacher teacher = null;
        String sql = "SELECT * FROM teacher WHERE id = ? AND password = ?";
        try (Connection conn = getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, id);
            stmt.setString(2, password);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                teacher = new Teacher();
                teacher.setId(rs.getString("id"));
                teacher.setPassword(rs.getString("password"));
                teacher.setName(rs.getString("name"));

                School school = new School();
                school.setCd(rs.getString("school_cd"));
                teacher.setSchool(school);
            }
        }
        return teacher;
    }

    public Teacher get(String id) throws Exception {
        Teacher teacher = null;
        String sql = "SELECT * FROM teacher WHERE id = ?";
        try (Connection conn = getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                teacher = new Teacher();
                teacher.setId(rs.getString("id"));
                teacher.setPassword(rs.getString("password"));
                teacher.setName(rs.getString("name"));

                School school = new School();
                school.setCd(rs.getString("school_cd"));
                teacher.setSchool(school);
            }
        }
        return teacher;
    }
}
