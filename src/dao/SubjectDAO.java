package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import bean.School;
import bean.Subject;

public class SubjectDAO {

    // 全件取得（指定した学校コードの科目リスト）
    public List<Subject> findAll(School school) {
        List<Subject> subjects = new ArrayList<>();

        try {
            Context initCtx = new InitialContext();
            DataSource ds = (DataSource) initCtx.lookup("java:comp/env/jdbc/kaihatsu");

            try (Connection conn = ds.getConnection();
                 PreparedStatement stmt = conn.prepareStatement("SELECT * FROM SUBJECT WHERE SCHOOL_CD = ?")) {

                stmt.setString(1, school.getCd());
                ResultSet rs = stmt.executeQuery();

                while (rs.next()) {
                    Subject subject = new Subject();
                    subject.setCd(rs.getString("CD"));
                    subject.setName(rs.getString("NAME"));
                    subject.setSchool(school);

                    subjects.add(subject);
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return subjects;
    }

    // 科目コード＋学校コードで1件取得
    public Subject findByCodeAndSchoolCd(String code, String schoolCd) {
        Subject subject = null;

        try {
            Context initCtx = new InitialContext();
            DataSource ds = (DataSource) initCtx.lookup("java:comp/env/jdbc/kaihatsu");

            try (Connection conn = ds.getConnection();
                 PreparedStatement stmt = conn.prepareStatement(
                     "SELECT * FROM SUBJECT WHERE SCHOOL_CD = ? AND CD = ?")) {

                stmt.setString(1, schoolCd);
                stmt.setString(2, code);

                ResultSet rs = stmt.executeQuery();

                if (rs.next()) {
                    subject = new Subject();
                    subject.setCd(rs.getString("CD"));
                    subject.setName(rs.getString("NAME"));

                    // 学校情報をセット
                    School school = new School();
                    school.setCd(schoolCd);
                    subject.setSchool(school);
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return subject;
    }

    // 科目更新処理
    public boolean update(Subject subject) {
        try {
            Context initCtx = new InitialContext();
            DataSource ds = (DataSource) initCtx.lookup("java:comp/env/jdbc/kaihatsu");

            try (Connection conn = ds.getConnection();
                 PreparedStatement stmt = conn.prepareStatement(
                     "UPDATE SUBJECT SET NAME = ? WHERE SCHOOL_CD = ? AND CD = ?")) {

                stmt.setString(1, subject.getName());
                stmt.setString(2, subject.getSchool().getCd());
                stmt.setString(3, subject.getCd());

                int rows = stmt.executeUpdate();
                return rows > 0;
            }

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

 // 科目削除処理
    public boolean delete(String code, String schoolCd) {
        try {
            Context initCtx = new InitialContext();
            DataSource ds = (DataSource) initCtx.lookup("java:comp/env/jdbc/kaihatsu");

            try (Connection conn = ds.getConnection();
                 PreparedStatement stmt = conn.prepareStatement(
                     "DELETE FROM SUBJECT WHERE SCHOOL_CD = ? AND CD = ?")) {

                stmt.setString(1, schoolCd);
                stmt.setString(2, code);

                int rows = stmt.executeUpdate();
                return rows > 0;
            }

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

}
