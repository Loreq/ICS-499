package tech.teamfour.model;

import java.util.Stack;

public class Line {
    private Stack<Point> line;

    public Line() {
        this.setLine(new Stack<Point>());
    }

    /**
     * @return the line
     */
    public Stack<Point> getLine() {
        return line;
    }

    /**
     * @param line the line to set
     */
    public void setLine(Stack<Point> line) {
        this.line = line;
    }

}

