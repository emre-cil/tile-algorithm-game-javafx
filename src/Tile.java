

import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import java.util.LinkedList;

class Tile extends StackPane {
    int x;
    int y;
    LinkedList<Player> players = new LinkedList();
    final Rectangle border;

    public Tile(int x, int y,int width,int height,int X_TILES, int Y_TILES) {
        this.x = x;
        this.y = y;
        border  = new Rectangle((width - 150) / X_TILES, height / Y_TILES);
        border.setFill(null);
        border.setStroke(Color.BLACK);
        setAlignment(Pos.CENTER);
        getChildren().addAll(border);
        setTranslateX(x * (width - 150) / X_TILES);
        setTranslateY(y * height / Y_TILES);
    }
}
