package agario.entity;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public abstract class Cell extends javafx.scene.shape.Circle {

    private final Color color;

    public Cell(double centerX, double centerY, double radius, Color color) {
        super(centerX, centerY, radius);
        this.color = color;
    }

    public boolean intersects(Cell other) {
        return Math.sqrt(
                  Math.pow(this.getCenterX() - other.getCenterX(), 2)
                + Math.pow(this.getCenterY() - other.getCenterY(), 2)
              ) <= this.getRadius() + other.getRadius();
    }

    public void render(GraphicsContext gc) {
        gc.setFill(color);
        gc.fillOval(getCenterX() - getRadius(), getCenterY() - getRadius(),
                getRadius() * 2, getRadius() * 2);
    }

    abstract void update();
}
