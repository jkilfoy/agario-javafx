package agario;


import javafx.animation.AnimationTimer;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;

public class Game extends Canvas {

    public static final int WORLD_SIZE = 760;
    public static final int BORDER_SIZE = 16;

    GraphicsContext context;
    World world;

    public Game() {
        super(WORLD_SIZE, WORLD_SIZE);
        context = getGraphicsContext2D();

        // TODO add event handlers
        setFocusTraversable(true);

        // run the game
        run();
    }

    private void run() {
        new AnimationTimer() {
            @Override
            public void handle(long l) {
                //input - handled by event loop
                update();
                render();
            }
        }.start();
    }

    private void update() {

    }

    private void render() {

    }

}