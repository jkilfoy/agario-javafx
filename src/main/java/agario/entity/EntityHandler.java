package agario.entity;

import javafx.scene.canvas.GraphicsContext;

import java.util.HashSet;
import java.util.Set;

public final class EntityHandler {

    public Set<Cell> cells = new HashSet<>();

    public EntityHandler() {

    }

    public void render(GraphicsContext gc) {
        for (Cell cell : cells) {
            cell.render(gc);
        }
    }

    public void update() {
        for (Cell cell : cells) {
            cell.update();
        }
    }
}
