package dao;
//dao

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import bean.ClassNum;
import bean.School;
import bean.Student;
//あああああ
public class StudentDao extends Dao {

    private String baseSql = "SELECT * FROM student WHERE school_cd=?";

    public Student get(String no) throws Exception {
        String sql = "SELECT * FROM student WHERE no=?";
        try (Connection conn = getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, no);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                Student student = new Student();
                student.setNo(rs.getString("no"));
                student.setName(rs.getString("name"));
                student.setEntYear(rs.getInt("ent_year"));
                student.setAttend(rs.getBoolean("is_attend"));

                School school = new School();
                school.setCd(rs.getString("school_cd"));
                student.setSchool(school);

                ClassNum classNum = new ClassNum();
                classNum.setClass_num(rs.getString("class_num"));
                student.setClassNum(classNum);

                return student;
            }
        }
        return null;
    }

    public List<Student> filter(School school, int enterYear, String classNum, boolean isAttend) throws Exception {
    	String sql = "SELECT * FROM student WHERE school_cd=? AND ent_year=? AND class_num=? AND is_attend=?";
        try (Connection conn = getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, school.getCd());
            stmt.setInt(2, enterYear);
            stmt.setString(3, classNum);
            stmt.setBoolean(4, isAttend);
            ResultSet rs = stmt.executeQuery();
            return postFilter(rs, school);
        }
    }

    public List<Student> filter(School school, int enterYear, boolean isAttend) throws Exception {
        String sql = baseSql + " AND ent_year=? AND is_attend=?";
        try (Connection conn = getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, school.getCd());
            stmt.setInt(2, enterYear);
            stmt.setBoolean(3, isAttend);
            ResultSet rs = stmt.executeQuery();
            return postFilter(rs, school);
        }
    }

    public List<Student> filter(School school, boolean isAttend) throws Exception {
        String sql = baseSql + " AND is_attend=?";
        try (Connection conn = getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, school.getCd());
            stmt.setBoolean(2, isAttend);
            ResultSet rs = stmt.executeQuery();
            return postFilter(rs, school);
        }
    }

    public List<Student> postFilter(ResultSet rs, School school) throws Exception {
        List<Student> list = new ArrayList<>();
        while (rs.next()) {
            Student student = new Student();
            student.setNo(rs.getString("no"));
            student.setName(rs.getString("name"));
            student.setEntYear(rs.getInt("ent_year"));
            student.setAttend(rs.getBoolean("is_attend"));
            student.setSchool(school);

            ClassNum cn = new ClassNum();
            cn.setClass_num(rs.getString("class_num"));
            student.setClassNum(cn);

            list.add(student);
        }
        return list;
    }

    public boolean save(Student student) throws Exception {
        String sql = "INSERT INTO student (no, name, ent_year, class_num, is_attend, school_cd) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection conn = getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, student.getNo());
            stmt.setString(2, student.getName());
            stmt.setInt(3, student.getEntYear());
            stmt.setString(4, student.getClassNum().getClass_num());
            stmt.setBoolean(5, student.isAttend());
            stmt.setString(6, student.getSchool().getCd());

            int result = stmt.executeUpdate();
            return result > 0;
        }
    }

    public List<Student> findAll(School school) throws Exception {
        String sql = baseSql; // school_cd だけで絞る
        try (Connection conn = getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, school.getCd());
            ResultSet rs = stmt.executeQuery();
            return postFilter(rs, school);
        }
    }
}

