package agario.entity;

import agario.Game;
import javafx.scene.paint.Color;

public class PlayerCell extends Cell {

    Game game;
    public double xVelocity, yVelocity;

    public PlayerCell(double centerX, double centerY, double radius, Color color, Game game) {
        super(centerX, centerY, radius, color);
        this.game = game;
    }

    @Override
    void update() {
        setCenterX(getCenterX() + xVelocity);
        game.camera.setTranslateX(game.camera.getTranslateX() + xVelocity);
        setCenterY(getCenterY() + yVelocity);
        game.camera.setTranslateY(game.camera.getTranslateY() + yVelocity);
    }

}
