package db;

import java.sql.*;
import java.util.*;
import javax.naming.*;
import javax.sql.DataSource;

public class StudentDAO {

    public static class Student {
        public String no;
        public String name;
        public int entYear;
        public String classNum;
        public boolean isAttend;
        public String schoolCd;

        public Student(String no, String name, int entYear, String classNum, boolean isAttend, String schoolCd) {
            this.no = no;
            this.name = name;
            this.entYear = entYear;
            this.classNum = classNum;
            this.isAttend = isAttend;
            this.schoolCd = schoolCd;
        }
    }

    public List<Student> findAll() {
        List<Student> students = new ArrayList<>();

        try {
            Context initCtx = new InitialContext();
            DataSource ds = (DataSource) initCtx.lookup("java:comp/env/jdbc/kaihatsu");

            try (Connection conn = ds.getConnection();
                 PreparedStatement stmt = conn.prepareStatement("SELECT * FROM STUDENT");
                 ResultSet rs = stmt.executeQuery()) {

                while (rs.next()) {
                    String no = rs.getString("NO");
                    String name = rs.getString("NAME");
                    int entYear = rs.getInt("ENT_YEAR");
                    String classNum = rs.getString("CLASS_NUM");
                    boolean isAttend = rs.getBoolean("IS_ATTEND");
                    String schoolCd = rs.getString("SCHOOL_CD");
                    
                    students.add(new Student(no, name, entYear, classNum, isAttend, schoolCd));
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return students;
    }
}
