package agario.entity;

import agario.Game;
import javafx.scene.paint.Color;

public class PlayerCell extends Cell {

    Game game;
    public double screenX, screenY;
    public double xVelocity, yVelocity;

    public PlayerCell(double centerX, double centerY, double radius, Color color, Game game) {
        super(centerX, centerY, radius, color, game);
        this.game = game;
        screenX = (Game.WINDOW_WIDTH / 2f);
        screenY = (Game.WINDOW_HEIGHT / 2f);
    }

    @Override
    void update() {
        setCenterX(Game.clamp(getCenterX() + xVelocity, getRadius(),Game.WORLD_SIZE - getRadius()));
        setCenterY(Game.clamp(getCenterY() + yVelocity, getRadius(),Game.WORLD_SIZE - getRadius()));
    }

}
