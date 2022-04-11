package agario.input;

import agario.Game;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

public class PlayerInput implements EventHandler<MouseEvent> {

    double mouseX, mouseY;
    Game game;

    public PlayerInput(Game game) {
        this.game = game;
    }

    @Override
    public void handle(MouseEvent mouseEvent) {
        mouseX = mouseEvent.getX();
        mouseY = mouseEvent.getY();

        // find distance from player
        double deltaX = mouseX - game.test.screenX;
        double deltaY = mouseY - game.test.screenY;

        game.test.xVelocity = deltaX * 0.05;
        game.test.yVelocity = deltaY * 0.05;
    }
}
