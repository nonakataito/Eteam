package db;

import java.sql.Connection;

public class ClassNumDAO {
    private Connection connection;

    // コンストラクタ：DB接続を受け取る
    public ClassNumDAO(Connection connection) {
        this.connection = connection;
    }

    // ここに今後メソッドを追加していく（例：insertClassNum, getClassNum, deleteClassNum など）
}
