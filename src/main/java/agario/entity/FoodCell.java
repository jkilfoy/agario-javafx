package agario.entity;

import agario.Game;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class FoodCell extends Cell {

    boolean visible;
    private double distance;

    public FoodCell(double centerX, double centerY, double radius, Color color, Game game) {
        super(centerX, centerY, radius, color, game);
    }

    @Override
    void update() {
        // d = sqrt((x - x)^2 + (y - y)^2)
        distance = Math.abs(Math.sqrt((Math.pow(getCenterX() - game.test.getCenterX(), 2))
                + (Math.pow(getCenterY() - game.test.getCenterY(), 2))));
        visible = distance <= Game.WINDOW_WIDTH / 2f + getRadius() * 2;
    }

    @Override
    public void render(GraphicsContext gc) {
        super.render(gc);
        gc.setFill(Color.BLACK);
        gc.fillText(Long.toString(Math.round(distance)), game.convertToScreenX(getCenterX() - getRadius()),
                game.convertToScreenY(getCenterY() - getRadius()));
    }
}
