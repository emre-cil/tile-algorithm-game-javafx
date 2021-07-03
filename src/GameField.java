
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Scanner;

class GameField {
    File file = new File("var.cfg");
    Scanner scn = new Scanner(file);
    Move move = new Move();

    int Y_TILES = Integer.parseInt(scn.nextLine().substring(9));
    int X_TILES = Integer.parseInt(scn.nextLine().substring(9));
    int playerSize = Integer.parseInt(scn.nextLine().substring(13));
    int obstacleSize = Integer.parseInt(scn.nextLine().substring(15));

    int width = 1450;
    int height = 700;
    int finishY;
    int finishX;
    int randY;
    int randX;


    Tile[][] grid = new Tile[Y_TILES][X_TILES];
    LinkedList<Player> playerList = new LinkedList<>();


    GameField(Pane root) throws FileNotFoundException {
        createField(root);
        addFinishPoint();
        addPlayer();
        addObstacle();
    }


    void createField(Pane root) {
        for (int i = 0; i < Y_TILES; i++) {
            for (int j = 0; j < X_TILES; j++) {
                Tile tile = new Tile(j, i, width, height, X_TILES, Y_TILES);
                grid[i][j] = tile;
                root.getChildren().add(tile);
            }
        }
    }

    //this method add Finish Point to area randomly
    void addFinishPoint() {
        finishY = (int) (Math.random() * grid.length);
        finishX = (int) (Math.random() * grid[0].length);
        grid[finishY][finishX].border.setFill(Color.GREEN);
    }

    //this method add player to area randomly
    void addPlayer() {
        int counter;
        for (counter = 0; counter < playerSize; ) {
            randY = (int) (Math.random() * grid.length);     //creates random x point
            randX = (int) (Math.random() * grid[0].length);  //creates random y point
            //controls if there is obstacle or finish point
            if (grid[randY][randX].border.getFill() == null || grid[randY][randX].border.getFill() == Color.BLUE) {
                Player pl = new Player();   //create new player object
                grid[randY][randX].players.add(pl);
                playerList.add(pl);
                playerList.get(counter).setId(counter + 1);
                grid[randY][randX].border.setFill(Color.BLUE);     //assign value to tile at x and y locatioin
                counter++;
            }
        }
    }

    //this method add obstacle to area randomly
    void addObstacle() {
        int counter = 0;
        while (counter < obstacleSize) {
            randY = (int) (Math.random() * grid.length);     //creates random x point
            randX = (int) (Math.random() * grid[0].length);  //creates random y point
            if (grid[randY][randX].border.getFill() == null) {
                grid[randY][randX].border.setFill(Color.BLACK);
                counter++;
            }
        }
    }


}
