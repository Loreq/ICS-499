package tech.teamfour.model;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class LinePuzzle {
    private Grid mainGrid;
    private Grid innerGrid;

    public LinePuzzle() {
        this.mainGrid = new Grid();
        this.innerGrid = new Grid();
    }

    public LinePuzzle(int size) {
        if (size < 5) size = 5;
        this.mainGrid = new Grid(size, false);
        this.innerGrid = new Grid(size, true);
    }

    public void travel(int x, int y) {
        System.out.println(this.mainGrid);
    }

    /**
     * @return the mainGrid
     */
    public Grid getMainGrid() {
        return mainGrid;
    }
    /**
     * @param mainGrid the mainGrid to set
     */
    public void setMainGrid(Grid mainGrid) {
        this.mainGrid = mainGrid;
    }
    /**
     * @return the innerGrid
     */
    public Grid getInnerGrid() {
        return innerGrid;
    }
    /**
     * @param innerGrid the innerGrid to set
     */
    public void setInnerGrid(Grid innerGrid) {
        this.innerGrid = innerGrid;
    }

    public void generate() {
        primsMaze();
    }

    /**
     * generate a random "loose" maze using Prim's Algorithm.
     */
    public void primsMaze() {
        ArrayList<Grid> gridLayer = new ArrayList<Grid>();
        int size = mainGrid.getVertexes().size();
        gridLayer.add(new Grid(mainGrid.getVertexes().size(), false));
        gridLayer.add(new Grid(mainGrid.getVertexes().size(), false));
        for (Grid grid : gridLayer) {
            LinkedList<int[]> nav = new LinkedList<>();
            Random rand = new Random();

            int x = rand.nextInt(size);
            int y = rand.nextInt(size);

            nav.add(new int[] {x, y, x, y});
            while (!nav.isEmpty()) {
                final int[] f = nav.remove(rand.nextInt(nav.size()));
                x = f[2];
                y = f[3];
                if (grid.getPoint(x, y).isDead())
                {
                    grid.getPoint(f[0], f[1]).setDead(false);
                    grid.getPoint(x, y).setDead(false);
                    if (x >= 2 && grid.getPoint(x - 2, y).isDead()) nav.add(new int[] {x - 1, y, x - 2, y});
                    if (y >= 2 && grid.getPoint(x, y - 2).isDead()) nav.add(new int[] {x, y - 1, x, y - 2});
                    if (x < size - 2 && grid.getPoint(x + 2, y).isDead()) nav.add(new int[] {x + 1, y, x + 2, y});
                    if (y < size - 2 && grid.getPoint(x, y + 2).isDead()) nav.add(new int[] {x, y + 1, x, y + 2});
                }
            }
            mainGrid.mergePaths(grid);
        }

        // If the start and end points of the final maze do not have paths, retry.
        if (mainGrid.getPoint(size - 2, 0).isDead() && mainGrid.getPoint(size - 1, 1).isDead()
                || mainGrid.getPoint(0, size - 1).isDead() && mainGrid.getPoint(1, size - 1).isDead()) {
            for (List<Point> row : mainGrid.getVertexes()) {
                for (Point point : row) {
                    point.setDead(true);
                }
            }
            primsMaze();
        } else {
            mainGrid.getEnd().setDead(false);
        }
    }

    @Override
    public String toString() {
        String display = "";
        for (int j = 0; j < mainGrid.getVertexes().size(); j++) {
            for (int i = 0; i < mainGrid.getVertexes().size(); i++) {
                if (i != 0) display += "-----";
                display += mainGrid.getVertexes().get(i).get(j);
            }
            //if (j < mainGrid.getVertexes().size() - 1) display += "\n|\s\s";
            for (int k = 0; k < innerGrid.getVertexes().size(); k++) {
               // if (j < innerGrid.getVertexes().size()) display += innerGrid.getVertexes().get(k).get(j) + "\s\s|\s\s";
            }
            display += "\n";
        }
        return display;
    }
}
