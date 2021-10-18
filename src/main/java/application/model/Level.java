package application.model;

public class Level {
    private Grid puzzle;
    private static Score highScore;
    
    /**
     * @return the puzzle
     */
    public Grid getPuzzle() {
	return puzzle;
    }
    /**
     * @param puzzle the puzzle to set
     */
    public void setPuzzle(Grid puzzle) {
	this.puzzle = puzzle;
    }
    /**
     * @return the highScore
     */
    public static Score getHighScore() {
	return highScore;
    }
    /**
     * @param highScore the highScore to set
     */
    public static void setHighScore(Score highScore) {
	Level.highScore = highScore;
    }
}
