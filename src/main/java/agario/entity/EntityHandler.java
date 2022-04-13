package agario.entity;

import agario.Game;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;
import java.util.Set;

public final class EntityHandler {

    private final Game game;
    public Set<Cell> cells = new HashSet<>();
    Set<FoodCell> foods = new HashSet<>();
    private final Set<FoodCell> visibleFood = new HashSet<>();
    private final int foodQuantity = 50000;
    private final Random r = new Random();

    public EntityHandler(Game game) {
        this.game = game;
        initFood();
    }

    public void render(GraphicsContext gc) {
        for (FoodCell food : visibleFood) {
            food.render(gc);
        }
        for (Cell cell : cells) {
            cell.render(gc);
        }
    }

    private void initFood() {
        Color color;
        while (foods.size() < foodQuantity) {
            color = new Color(r.nextFloat(), r.nextFloat(), r.nextFloat(), 1f);
            int foodRadius = 10;
            foods.add(new FoodCell(r.nextInt(Game.WORLD_SIZE - foodRadius), r.nextInt(Game.WORLD_SIZE - foodRadius), foodRadius, color, game));
        }
    }

    public void update() {
        visibleFood.clear();
        if (foods.size() < foodQuantity) initFood();
        for (FoodCell food : foods) {
            food.update();
            if (food.visible) visibleFood.add(food);
        }
        Iterator<FoodCell> it = visibleFood.iterator();
        for (Cell cell : cells) {
            cell.update();
            while (it.hasNext()) {
                FoodCell current = it.next();
                if (cell.intersects(current)) {
                    it.remove();
                    foods.remove(current);
                    cell.increaseMass();
                }
            }
        }
    }
}
