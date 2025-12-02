package controlador;

import model.SGBoardModel;
import vista.panelJuego.SnakeGameBoard;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.util.ArrayList;

public class SGBoardControl {
    private final SnakeGameBoard view;
    private final SGBoardModel model;

    public SGBoardControl(SnakeGameBoard view, SGBoardModel model) {
        this.view = view;
        this.model = model;
        //initGame();
    }
    /*private void initGame() {
        int score = 0;
        model.direction = "RIGHT";
        gameOver = false;

        int centerX = PLAY_COLS / 2;
        int centerY = PLAY_ROWS / 2;
        snake = new ArrayList<>();
        snake.add(new Point(centerX, centerY));
        snake.add(new Point(centerX - 1, centerY));
        snake.add(new Point(centerX - 2, centerY));

        generateFood();
    }*/

/*// Movimiento automático con Timer

    timer = new Timer(150, e -> {
        if (!gameOver) {
            moveSnake();
            gamePanel.repaint();
        }
    });
    timer.start();


    // Control de teclas
    addKeyListener(new KeyAdapter() {
        @Override
        public void keyPressed(KeyEvent e) {
            switch (e.getKeyCode()) {
                case KeyEvent.VK_UP:
                    if (!direction.equals("DOWN")) direction = "UP";
                    break;
                case KeyEvent.VK_DOWN:
                    if (!direction.equals("UP")) direction = "DOWN";
                    break;
                case KeyEvent.VK_LEFT:
                    if (!direction.equals("RIGHT")) direction = "LEFT";
                    break;
                case KeyEvent.VK_RIGHT:
                    if (!direction.equals("LEFT")) direction = "RIGHT";
                    break;
            }
        }
    });*/
/*


    private void moveSnake() {
        Point head = snake.get(0);
        Point newHead = new Point(head);

        switch (direction) {
            case "UP": newHead.y--; break;
            case "DOWN": newHead.y++; break;
            case "LEFT": newHead.x--; break;
            case "RIGHT": newHead.x++; break;
        }

        // Colisión con paredes
        if (newHead.x < 0 || newHead.x >= PLAY_COLS || newHead.y < 0 || newHead.y >= PLAY_ROWS) {
            endGame();
            return;
        }

        // Colisión con el cuerpo
        if (snake.contains(newHead)) {
            endGame();
            return;
        }

        // Comer comida
        if (newHead.equals(food)) {
            snake.add(0, newHead);
            score += 10;
            if (score > highScore) highScore = score;
            generateFood();
        } else {
            snake.add(0, newHead);
            snake.remove(snake.size() - 1);
        }
    }

    private void generateFood() {
        Random rand = new Random();
        Point newFood;
        do {
            newFood = new Point(rand.nextInt(PLAY_COLS), rand.nextInt(PLAY_ROWS));
        } while (snake.contains(newFood));
        food = newFood;
    }

    private void endGame() {
        gameOver = true;
        timer.stop();
    }*/
}
