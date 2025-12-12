package model;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class SGBoardModel {

    private int rows=22;
    private int cols=36;
    // Calcular filas y columnas según TILE_SIZE
    /*int cols = boardWidth / TILE_SIZE; 540/15=36
    int rows = boardHeight / TILE_SIZE; 330/15=22*/

    private List<Point> snake;
    private Point food;
    private Direction direction;
    private boolean gameOver;
    private int score;

    public enum Direction {
        UP, DOWN, LEFT, RIGHT
    }

    public SGBoardModel() {
        resetGame();
    }


    public void resetGame() {
        snake = new ArrayList<>();

        // Posición inicial: centro del tablero
        int startX = cols / 2;
        int startY = rows / 2;

        // Tamaño inicial: 3 segmentos (cabeza + 2)
        snake.add(new Point(startX, startY));       // Cabeza
        snake.add(new Point(startX - 1, startY));   // Segundo segmento
        snake.add(new Point(startX - 2, startY));   // Tercer segmento

        direction = Direction.RIGHT; // Dirección inicial
        gameOver = false;
        score = 0;
        generateFood();
    }


    public void generateFood() {
        Random rand = new Random();
        Point newFood;
        do {
            newFood = new Point(rand.nextInt(cols), rand.nextInt(rows));
        } while (snake.contains(newFood));
        food = newFood;
    }

    public void moveSnake() {
        if (gameOver) return;

        Point head = snake.get(0);
        Point newHead = new Point(head);

        switch (direction) {
            case UP -> newHead.y--;
            case DOWN -> newHead.y++;
            case LEFT -> newHead.x--;
            case RIGHT -> newHead.x++;
        }

        // Verificar colisiones
        if (newHead.x < 0 || newHead.x >= cols || newHead.y < 0 || newHead.y >= rows || snake.contains(newHead)) {
            gameOver = true;
            return;
        }

        snake.add(0, newHead);

        // Comer comida
        if (newHead.equals(food)) {
            score += 10;
            generateFood();
        } else {
            snake.remove(snake.size() - 1); // no crece
        }
    }

    public void setDirection(Direction dir) {
        // Evitar dirección opuesta
        if ((direction == Direction.UP && dir == Direction.DOWN) ||
                (direction == Direction.DOWN && dir == Direction.UP) ||
                (direction == Direction.LEFT && dir == Direction.RIGHT) ||
                (direction == Direction.RIGHT && dir == Direction.LEFT)) {
            return;
        }
        direction = dir;
    }

    public List<Point> getSnake() {
        return snake;
    }

    public Point getFood() {
        return food;
    }

    public boolean isGameOver() {
        return gameOver;
    }

    public int getScore() {
        return score;
    }
}
