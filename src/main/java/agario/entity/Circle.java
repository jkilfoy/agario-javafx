package agario.entity;

import javafx.geometry.Point2D;

public class Circle extends javafx.scene.shape.Circle {

    public Circle(double centerX, double centerY, double radius) {
        super(centerX, centerY, radius);
    }

    public boolean intersects(Circle other) {
        return Math.sqrt(
                  Math.pow(this.getCenterX() - other.getCenterX(), 2)
                + Math.pow(this.getCenterY() - other.getCenterY(), 2)
              ) <= this.getRadius() + other.getRadius();
    }
}
