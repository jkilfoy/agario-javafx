package agario;

import javafx.application.Application;
import javafx.scene.Camera;
import javafx.scene.Group;
import javafx.scene.PerspectiveCamera;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {

    public static Main app = null;
    public static Stage stage = null;
    public static PerspectiveCamera camera = null;

    @Override
    public void start(Stage primaryStage) throws IOException {
        app = this;
        stage = primaryStage;
        stage.setTitle("Agario");
        Game game = new Game();
        Group root = new Group(game);
        Scene s = new Scene(root);
        camera = new PerspectiveCamera(true);
        s.setCamera(camera);
        stage.setScene(s);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
