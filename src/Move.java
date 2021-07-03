
import javafx.scene.paint.Color;

import java.util.LinkedList;

class Move {
    LinkedList<Tile[][]> turns = new LinkedList<>();
    int turnCount;

    void turn(Tile[][] grid, LinkedList<Player> playerList) {

            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[0].length; j++) {
                    if (!grid[i][j].players.isEmpty()) {
                        for (Player plyr : grid[i][j].players) {
                            go(grid,i, j, plyr);
                        }
                    }
                }
            }
            Tile[][] fakeTile;
            fakeTile = grid.clone();
            turns.add(fakeTile);
            turnCountRefresh(playerList);
            turnCount++;
        }


    void go(Tile[][] grid,int i, int j, Player pl) {
        if (pl.getTurn() == 1) {
            int random = (int) (Math.random() * 4 + 1);
            if (random == 1) {
                goNorth(grid,i, j, pl);
            } else if (random == 2) {
                goSouth(grid,i, j, pl);
            } else if (random == 3) {
                goWest(grid,i, j, pl);
            } else {
                goEast(grid,i, j, pl);
            }
        }
    }

    void turnCountRefresh(LinkedList<Player> playerList) { //refresh each player turn amount
        for (Player i : playerList) {
            i.setTurn(1);
        }
    }

    void goNorth(Tile[][] grid,int i, int j, Player pl) {
        pl.setTurn(0);
        if (i > 0) {
            if (grid[i - 1][j].border.getFill() != Color.BLACK) {
                if (grid[i - 1][j].border.getFill() == Color.GREEN) {
                    System.out.println("Player " + pl.getId() + " won!!");
                    grid[i - 1][j].border.setFill(Color.YELLOW);
                } else
                    grid[i - 1][j].border.setFill(Color.BLUE);
                grid[i - 1][j].players.add(pl);
                grid[i][j].players.remove(pl);
            }
            deleteTile(grid,i, j);
        }
    }

    void goSouth(Tile[][] grid,int i, int j, Player pl) {
        pl.setTurn(0);
        if (i < grid.length - 1) {              // controls the border
            if (grid[i + 1][j].border.getFill() != Color.BLACK) {  // controls the move place
                if (grid[i + 1][j].border.getFill() == Color.GREEN) {
                    System.out.println("Player " + pl.getId() + " won!!");
                    grid[i + 1][j].border.setFill(Color.YELLOW);
                } else
                    grid[i + 1][j].border.setFill(Color.BLUE);
                grid[i + 1][j].players.add(pl);
                grid[i][j].players.remove(pl);
            }
            deleteTile(grid,i, j);
        }
    }

    void goWest(Tile[][] grid,int i, int j, Player pl) {
        pl.setTurn(0);

        if (j > 0) {                            // controls the border
            if (grid[i][j - 1].border.getFill() != Color.BLACK) {  // controls the move place
                if (grid[i][j - 1].border.getFill() == Color.GREEN) {
                    System.out.println("Player " + pl.getId() + " won!!");
                    grid[i][j - 1].border.setFill(Color.YELLOW);
                } else
                    grid[i][j - 1].border.setFill(Color.BLUE);
                grid[i][j - 1].players.add(pl);
                grid[i][j].players.remove(pl);
            }
            deleteTile(grid,i, j);
        }
    }

    void goEast(Tile[][] grid,int i, int j, Player pl) {
        pl.setTurn(0);
        if (j < grid[0].length - 1) { // controls the border
            if (grid[i][j + 1].border.getFill() != Color.BLACK) {  // controls the move place
                if (grid[i][j + 1].border.getFill() == Color.GREEN) {
                    System.out.println("Player " + pl.getId() + " won!!");
                    grid[i][j + 1].border.setFill(Color.YELLOW);
                } else
                    grid[i][j + 1].border.setFill(Color.BLUE);
                grid[i][j + 1].players.add(pl);
                grid[i][j].players.remove(pl);
            }
            deleteTile(grid,i, j);
        }
    }

    void deleteTile(Tile[][] grid,int i, int j) {
        if (grid[i][j].players.isEmpty() && grid[i][j].border.getFill() != Color.BLACK)
            grid[i][j].border.setFill(null);
    }
}
