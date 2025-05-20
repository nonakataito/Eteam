package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import bean.ClassNum;
import bean.School;

public class ClassNumDAO {

    private final String JDBC_URL = "jdbc:mysql://localhost:3306/your_database";
    private final String DB_USER = "your_username";
    private final String DB_PASSWORD = "your_password";

    public void insert(ClassNum classNum) throws SQLException {
        String sql = "INSERT INTO class_num (school_cd, class_num) VALUES (?, ?)";

        try (Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, classNum.getSchool().getCd());
            stmt.setString(2, classNum.getClass_num());
            stmt.executeUpdate();
        }
    }

    public ClassNum findById(String schoolCd, String classNumVal) throws SQLException {
        String sql = "SELECT * FROM class_num WHERE school_cd = ? AND class_num = ?";
        ClassNum result = null;

        try (Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, schoolCd);
            stmt.setString(2, classNumVal);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                result = new ClassNum();
                School school = new School();
                school.setCd(rs.getString("school_cd"));
                result.setSchool(school);
                result.setClass_num(rs.getString("class_num"));
            }
        }
        return result;
    }

    public List<ClassNum> findAll() throws SQLException {
        String sql = "SELECT * FROM class_num";
        List<ClassNum> list = new ArrayList<>();

        try (Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASSWORD);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                ClassNum cn = new ClassNum();
                School school = new School();
                cn.setSchool(school);
                cn.setClass_num(rs.getString("class_num"));
                list.add(cn);
            }
        }
        return list;
    }

    public void update(ClassNum classNum) throws SQLException {
        String sql = "UPDATE class_num SET class_num = ? WHERE school_cd = ?";

        try (Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, classNum.getClass_num());
            stmt.setString(2, classNum.getSchool().getCd());
            stmt.executeUpdate();
        }
    }

    public void delete(String schoolCd, String classNumVal) throws SQLException {
        String sql = "DELETE FROM class_num WHERE school_cd = ? AND class_num = ?";

        try (Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, schoolCd);
            stmt.setString(2, classNumVal);
            stmt.executeUpdate();
        }
    }
}
