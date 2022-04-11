package agario;


import agario.entity.EntityHandler;
import agario.entity.PlayerCell;
import javafx.animation.AnimationTimer;
import javafx.scene.PerspectiveCamera;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Game extends Canvas {

    public static final int WORLD_SIZE = 50000;
    public static final int WINDOW_WIDTH = 1200;
    public static final int WINDOW_HEIGHT = 700;
    public static final int BORDER_SIZE = 16;

    GraphicsContext context = getGraphicsContext2D();
    PerspectiveCamera camera;

    World world = new World();
    EntityHandler entities = new EntityHandler();
    PlayerCell test = new PlayerCell(100, 100, 50, Color.INDIGO);

    public Game(PerspectiveCamera camera) {
        super(WINDOW_WIDTH, WINDOW_HEIGHT);
        this.camera = camera;

        // TODO add event handlers
        setFocusTraversable(true);

        entities.cells.add(test);

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
        entities.update();
    }

    private void render() {
        world.render(context);
        entities.render(context);
    }

}