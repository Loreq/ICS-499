package application.model;

import java.util.Date;

public class Score {
    private Player scoreHolder;
    private float completeTime;
    private Date dateOfScore;

    public Score(Player scoreHolder, float completeTime, Date dateOfScore) {
        this.scoreHolder = scoreHolder;
        this.completeTime = completeTime;
        this.dateOfScore = dateOfScore;
    }

    public Player getScoreHolder() {
        return scoreHolder;
    }

    public void setScoreHolder(Player scoreHolder) {
        this.scoreHolder = scoreHolder;
    }

    public float getCompleteTime() {
        return completeTime;
    }

    public void setCompleteTime(float completeTime) {
        this.completeTime = completeTime;
    }

    public Date getDateOfScore() {
        return dateOfScore;
    }

    public void setDateOfScore(Date dateOfScore) {
        this.dateOfScore = dateOfScore;
    }
}
