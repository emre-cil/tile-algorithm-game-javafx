/*----------------------------------------------
 * @author Emre Cil
 * GitHub: https://github.com/Kheseyroon
 * MIT license: Copyright 2020 Emre Cil
 * ----------------------------------------------- */
import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import java.io.FileNotFoundException;

public class Main extends Application {
    GameField gameField;
    Pane root;
    boolean finishCheek;
    private Parent createContent() throws FileNotFoundException {
         root = new Pane();
         gameField = new GameField(root);
        Text currTurn = new Text("Current Turn ");
        currTurn.setLayoutX(gameField.width - 120);
        currTurn.setLayoutY(20);
        Text currTurnValue = new Text("0");
        currTurnValue.setFont(new Font("Cambria", 25));
        currTurnValue.setLayoutX(gameField.width - 95);
        currTurnValue.setLayoutY(50);
        Button nextTurn = new Button("Next Turn");
        nextTurn.setPrefSize(100, 20);
        nextTurn.setLayoutX(gameField.width - 125);
        nextTurn.setLayoutY(100);

        root.getChildren().addAll(currTurn, currTurnValue, nextTurn);
        root.setPrefSize(gameField.width, gameField.height);


        nextTurn.setOnAction(e -> {
            if (gameField.grid[gameField.finishY][gameField.finishX].border.getFill() == Color.YELLOW)
                finishCheek = true;
            if (!finishCheek) {
                gameField.move.turn(gameField.grid, gameField.playerList);
                currTurnValue.setText(String.valueOf(gameField.move.turnCount));
            }
        });
        return root;
    }

    @Override
    public void start(Stage stage) throws Exception{

        Scene scene = new Scene(createContent());
        stage.setScene(scene);
        stage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }

}

