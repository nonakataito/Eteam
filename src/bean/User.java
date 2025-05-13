package bean;
public class User {
    private boolean isAuthenticated;

    public User() {
        this.isAuthenticated = false; // 初期状態：未認証
    }

    // ゲッター（getではなくisを使うのがbooleanの慣習）
    public boolean isAuthenticated() {
        return isAuthenticated;
    }

    // セッター
    public void setAuthenticated(boolean isAuthenticated) {
        this.isAuthenticated = isAuthenticated;
    }
}
