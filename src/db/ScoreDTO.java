public class ScoreDTO {
    private int id;
    private int studentId;
    private int subjectId;
    private int score;

    // getterとsetter
}
public interface ScoreDAO {
    void insertScore(ScoreDTO score);
    List<ScoreDTO> getScoresByStudent(int studentId);
    void updateScore(ScoreDTO score);
    void deleteScore(int scoreId);
}
