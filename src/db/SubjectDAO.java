package db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class SubjectDAO {

    // SUBJECTテーブル1行分を表すBeanクラス
    public static class Subject {
        public String schoolCd;
        public String cd;
        public String name;

        public Subject(String schoolCd, String cd, String name) {
            this.schoolCd = schoolCd;
            this.cd = cd;
            this.name = name;
        }
    }

    // 全件取得
    public List<Subject> findAll() {
        List<Subject> subjects = new ArrayList<>();

        try {
            Context initCtx = new InitialContext();
            DataSource ds = (DataSource) initCtx.lookup("java:comp/env/jdbc/kaihatsu");

            try (Connection conn = ds.getConnection();
                 PreparedStatement stmt = conn.prepareStatement("SELECT * FROM SUBJECT");
                 ResultSet rs = stmt.executeQuery()) {

                while (rs.next()) {
                    String schoolCd = rs.getString("SCHOOL_CD");
                    String cd = rs.getString("CD");
                    String name = rs.getString("NAME");

                    subjects.add(new Subject(schoolCd, cd, name));
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return subjects;
    }
}
