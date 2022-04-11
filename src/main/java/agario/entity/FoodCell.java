package agario.entity;

import agario.Game;
import javafx.scene.paint.Color;

public class FoodCell extends Cell {

    public FoodCell(double centerX, double centerY, double radius, Color color, Game game) {
        super(centerX, centerY, radius, color, game);
    }

    @Override
    void update() {}

}
