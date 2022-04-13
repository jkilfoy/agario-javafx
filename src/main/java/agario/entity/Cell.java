package agario.entity;

import agario.Game;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public abstract class Cell extends javafx.scene.shape.Circle {

    protected final Color color;
    protected final Game game;

    public Cell(double centerX, double centerY, double radius, Color color, Game game) {
        super(centerX, centerY, radius);
        this.game = game;
        this.color = color;
    }

    private double getArea() {
        return Math.PI * Math.pow(getRadius(), 2);
    }

    public boolean intersects(Cell other) {
        return Math.sqrt(
                  Math.pow(this.getCenterX() - other.getCenterX(), 2)
                + Math.pow(this.getCenterY() - other.getCenterY(), 2)
              ) <= this.getRadius() + other.getRadius();
    }

    public void render(GraphicsContext gc) {
        gc.setFill(color);
        gc.fillOval(game.convertToScreenX(getCenterX() - getRadius()), game.convertToScreenY(getCenterY() - getRadius()),
                getRadius() * 2, getRadius() * 2);
    }

    abstract void update();

    public void increaseMass() {
        double or = getRadius();
        setRadius(getRadius() + 1);
        game.rescale(Math.sqrt(or / getRadius()));
    }
}
