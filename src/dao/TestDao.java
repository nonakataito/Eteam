package dao;
//あいうえお
import java.sql.Connection;
import java.sql.PreparedStatement;

import bean.Test;

public class TestDao extends Dao {

    public boolean insert(Test test) throws Exception {
        String sql = "INSERT INTO test (student_no, subject_cd, score) VALUES (?, ?, ?)";
        try (Connection conn = getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, test.getStudent().getNo());
            stmt.setString(2, test.getSubject().getCd());
            stmt.setInt(3, test.getTest());

            int result = stmt.executeUpdate();
            return result > 0;
        }
    }
}

