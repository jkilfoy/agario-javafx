package agario;


import agario.entity.EntityHandler;
import agario.entity.PlayerCell;
import agario.input.PlayerInput;
import javafx.animation.AnimationTimer;
import javafx.geometry.Point2D;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.transform.Affine;

public class Game extends Canvas {

    public static final int WORLD_SIZE = 50000;
    public static final int WINDOW_WIDTH = 1200;
    public static final int WINDOW_HEIGHT = 700;
    public static double scale = 0.5f;
    public static double maxDist = Math.sqrt(Math.pow(WINDOW_WIDTH / 2f, 2) + Math.pow(WINDOW_HEIGHT / 2f, 2)) / scale;

    GraphicsContext context = getGraphicsContext2D();

    World world = new World(this);
    EntityHandler entities = new EntityHandler(this);
    PlayerInput input = new PlayerInput(this);
    public PlayerCell test = new PlayerCell(100, 100, 50, Color.INDIGO, this);

    public Game() {
        super(WINDOW_WIDTH, WINDOW_HEIGHT);
        Affine a = context.getTransform();
        a.appendScale(scale,scale,new Point2D(test.screenX, test.screenY));
        context.setTransform(a);

        // TODO add event handlers
        addEventHandler(MouseEvent.ANY, input);
        setFocusTraversable(true);
        requestFocus();

        entities.cells.add(test);
        // run the game
        run();
    }

    public void rescale(double scale) {
        Game.scale *= scale;
        maxDist = Math.sqrt(Math.pow(WINDOW_WIDTH / 2f, 2) + Math.pow(WINDOW_HEIGHT / 2f, 2)) / Game.scale;
        Affine a = context.getTransform();
        a.appendScale(scale, scale, test.screenX, test.screenY);
        context.setTransform(a);
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
        context.clearRect(-WORLD_SIZE / 2f, -WORLD_SIZE / 2f, WORLD_SIZE, WORLD_SIZE); //TODO find more accurate method parameters
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