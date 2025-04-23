package db;
public class ScoreDTO {
    private int id;
    private int studentId;
    private int subjectId;
    private int score;

    // getterとsetter
}
public interface ScoreDAO {
    void insertScore(ScoreDAO score);
    List<ScoreDAO> getScoresByStudent(int studentId);
    void updateScore(ScoreDAO score);
    void deleteScore(int scoreId);
}
