package agario;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    public static Main app = null;
    public static Stage stage = null;

    @Override
    public void start(Stage primaryStage) {

        app = this;
        stage = primaryStage;

        stage.setTitle("Agario");

        Game game = new Game();
        game.setManaged(false);
        Group root = new Group(game);
        Scene s = new Scene(root);

        stage.setScene(s);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
