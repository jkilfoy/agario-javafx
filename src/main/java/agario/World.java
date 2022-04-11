package agario;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;

public class World {

    private final Game game;
    Line[] horizontalLines = new Line[Game.WORLD_SIZE / 500 + 1];
    Line[] verticalLines = new Line[Game.WORLD_SIZE / 500 + 1];

    public World(Game game) {
        this.game = game;
        for (int i = 0; i < horizontalLines.length; i++) {
            horizontalLines[i] = new Line(0, i * (Game.WORLD_SIZE / 500f), Game.WORLD_SIZE,
                    i * (Game.WORLD_SIZE / 500f));
            verticalLines[i] = new Line(i * (Game.WORLD_SIZE / 500f), 0, i * (Game.WORLD_SIZE / 500f),
                    Game.WORLD_SIZE);
        }

    }

    public void render(GraphicsContext gc) {
        gc.setFill(Color.GRAY);
        Line line;
        for (int i = 0; i < horizontalLines.length; i++) {
            line = horizontalLines[i];
            gc.strokeLine(game.convertToScreenX(line.getStartX()), game.convertToScreenY(line.getStartY()),
                    game.convertToScreenX(line.getEndX()), game.convertToScreenY(line.getEndY()));
            line = verticalLines[i];
            gc.strokeLine(game.convertToScreenX(line.getStartX()), game.convertToScreenY(line.getStartY()),
                    game.convertToScreenX(line.getEndX()), game.convertToScreenY(line.getEndY()));
        }
    }

}
