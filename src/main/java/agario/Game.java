package agario;


import agario.entity.EntityHandler;
import agario.entity.PlayerCell;
import agario.input.PlayerInput;
import javafx.animation.AnimationTimer;
import javafx.geometry.Rectangle2D;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;

public class Game extends Canvas {

    public static final int WORLD_SIZE = 50000;
    public static final int WINDOW_WIDTH = 1200;
    public static final int WINDOW_HEIGHT = 700;
    public static Rectangle2D bounds = new Rectangle2D(0, 0, WINDOW_WIDTH, WINDOW_HEIGHT);

    GraphicsContext context = getGraphicsContext2D();

    World world = new World(this);
    EntityHandler entities = new EntityHandler(this);
    PlayerInput input = new PlayerInput(this);
    public PlayerCell test = new PlayerCell(100, 100, 50, Color.INDIGO, this);

    public Game() {
        super(WINDOW_WIDTH, WINDOW_HEIGHT);

        // TODO add event handlers
        addEventHandler(MouseEvent.MOUSE_MOVED, input);
        setFocusTraversable(true);
        requestFocus();

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
                clear();
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

    private void clear() {
        context.clearRect(0, 0, WINDOW_WIDTH, WINDOW_HEIGHT);
    }

    public double convertToScreenX(double worldX) {
        return worldX - test.getCenterX()
                + test.screenX;
    }

    public double convertToScreenY(double worldY) {
        return worldY - test.getCenterY()
                + test.screenY;
    }

    public static double clamp(double val, double min, double max) {
        return Math.max(min, Math.min(max, val));
    }
}