package dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import bean.School;

public class SchoolDAO extends Dao{

    public School get(String cd) throws Exception {
        School school = null;

        // データベース接続
        Connection con=getConnection();

        // SQLで該当の学校コードを探す
        String sql = "SELECT * FROM school WHERE cd = ?";
        PreparedStatement st = con.prepareStatement(sql);
        st.setString(1, cd);

        ResultSet rs = st.executeQuery();

        // 学校データがあればオブジェクトにセット
        if (rs.next()) {
            school = new School();
            school.setCd(rs.getString("cd"));
            school.setName(rs.getString("name"));
        }

        rs.close();
        st.close();
        con.close();

        return school;
//        a
    }
}
