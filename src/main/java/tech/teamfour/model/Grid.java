package tech.teamfour.model;
import java.util.ArrayList;
import java.util.List;

public class Grid {
    private List<List<Point>> vertexes;
    private Point start;
    private Point end;

    public Grid() {
        this.vertexes = new ArrayList<List<Point>>();
        this.start = new Point();
        this.end = new Point();
    }

    public Grid(int size, boolean inner) {
        size -= 1;
        if (inner) size -= 1;
        this.vertexes = new ArrayList<List<Point>>(size);
        for (int x = 0; x <= size; x++)
        {
            List<Point> row = new ArrayList<Point>(size);
            for (int y = size; y >= 0; y--) {
                if (!inner) {
                    if (x == 0 && y == size) {
                        this.end = new Point(x, y, 1);
                        row.add(this.end);
                    }
                    else if (x == size && y == 0) {
                        this.start = new Point(x, y, 0);
                        row.add(this.start);
                    }
                    else row.add(new Point(x, y));
                } else {
                    row.add(new Point());
                }
            }
            this.vertexes.add(row);
        }
    }

    public ArrayList<List<Point>> generateGrid(int size) {
        return null;
    }

    /**
     * @return the vertexes
     */
    public List<List<Point>> getVertexes() {
        return vertexes;
    }
    /**
     * @param vertexes the vertexes to set
     */
    public void setVertexes(List<List<Point>> vertexes) {
        this.vertexes = vertexes;
    }
    /**
     * @return the start
     */
    public Point getStart() {
        return start;
    }
    /**
     * @param start the start to set
     */
    public void setStart(Point start) {
        this.start = start;
    }
    /**
     * @return the end
     */
    public Point getEnd() {
        return end;
    }
    /**
     * @param end the end to set
     */
    public void setEnd(Point end) {
        this.end = end;
    }

    /**
     * @param grid to merge paths with another grid.
     */
    public void mergePaths(Grid grid) {
        int size = vertexes.size() - 1;
        for (int x = 0; x <= size; x++) {
            for (int y = size; y >= 0; y--) {
                if (getPoint(x, y).isDead() && !grid.getPoint(x, y).isDead()) {
                    getPoint(x, y).setDead(false);
                }
            }
        }
    }

    public Point getPoint(int x, int y) {
        return this.vertexes.get(x).get(vertexes.size() - 1 - y);
    }

}
