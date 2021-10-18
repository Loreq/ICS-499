package application.model;

public class Player {
    private String userName;
    private String password;
    private float bestTime;
    
    /**
     * @return the userName
     */
    public String getUserName() {
	return userName;
    }
    /**
     * @param userName the userName to set
     */
    public void setUserName(String userName) {
	this.userName = userName;
    }
    /**
     * @return the password
     */
    public String getPassword() {
	return password;
    }
    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
	this.password = password;
    }
    /**
     * @return the bestTime
     */
    public float getBestTime() {
	return bestTime;
    }
    /**
     * @param bestTime the bestTime to set
     */
    public void setBestTime(float bestTime) {
	this.bestTime = bestTime;
    }
}
