package application.model;

public class Point {
    private int x;
    private int y;
    private boolean visited;
    private boolean required;
    private boolean dead;
    private boolean start;
    private boolean end;

    /**
     * No argument constructor
     */
    public Point() {
	this.setVisited(false);
	this.setRequired(false);
	this.setDead(true);
	this.setStart(false);
	this.setEnd(false);
    }
    
    /**
     * Initialize the point.
     */
    public Point(Point point) {
	this.setX(point.getX());
	this.setY(point.getY());
	this.setVisited(false);
	this.setRequired(false);
	this.setDead(true);
	this.setStart(false);
	this.setEnd(false);
    }
    
    /**
     * Initialize the point.
     */
    public Point(int x, int y) {
	this.setX(x);
	this.setY(y);
	this.setVisited(false);
	this.setRequired(false);
	this.setDead(true);
	this.setStart(false);
	this.setEnd(false);
    }

    /**
     * Initialize the point and flag for unique properties.
     *<br>Keys:
     *<br>0 = Start Adjacent
     *<br>1 = End Adjacent
     *<br>2 = Required Point
     */
    public Point(int x, int y, int flag) {
	this.setX(x);
	this.setY(y);
	this.setVisited(false);
	this.setRequired(false);
	this.setDead(true);
	this.setStart(false);
	this.setEnd(false);

	switch (flag) {
	case 0:
	    this.setStart(true);
	    break;
	case 1:
	    this.setEnd(true);
	    break;
	case 2:
	    this.setRequired(true);
	    break;
	default:
	    break;
	}
    }

    /**
     * @return the x
     */
    public int getX() {
	return x;
    }
    /**
     * @param x the x to set
     */
    public void setX(int x) {
	this.x = x;
    }
    /**
     * @return the y
     */
    public int getY() {
	return y;
    }
    /**
     * @param y the y to set
     */
    public void setY(int y) {
	this.y = y;
    }
    /**
     * @return the visited
     */
    public boolean isTravel() {
	return visited;
    }
    /**
     * @param visited the visited to set
     */
    public void setVisited(boolean visited) {
	this.visited = visited;
    }

    /**
     * @return the required
     */
    public boolean isRequired() {
	return required;
    }

    /**
     * @param required the required to set
     */
    public void setRequired(boolean required) {
	this.required = required;
    }
    /**
     * @return the dead
     */
    public boolean isDead() {
	return dead;
    }

    /**
     * @param dead the dead to set
     */
    public void setDead(boolean dead) {
	this.dead = dead;
    }
    /**
     * @return the start
     */
    public boolean isStart() {
	return start;
    }
    /**
     * @param start the start to set
     */
    public void setStart(boolean start) {
	this.start = start;
    }
    /**
     * @return the end
     */
    public boolean isEnd() {
	return end;
    }
    /**
     * @param end the end to set
     */
    public void setEnd(boolean end) {
	this.end = end;
    }
    @Override
    public String toString() {
	//return x + "," + y; // debug
	if (start) return "S";
	if (end) return "E";
	if (dead) return "X";
	if (visited) return "#";
	if (required) return "!";
	return "O";
    }
}
