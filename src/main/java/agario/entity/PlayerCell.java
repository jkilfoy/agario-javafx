package agario.entity;

import javafx.scene.paint.Color;

public class PlayerCell extends Cell {

    double xVelocity, yVelocity;

    public PlayerCell(double centerX, double centerY, double radius, Color color) {
        super(centerX, centerY, radius, color);
    }

    @Override
    void update() {

    }

}
