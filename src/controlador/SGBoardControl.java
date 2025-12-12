

package controlador;

import model.SGBoardModel;
import vista.panelJuego.SnakeGameBoard;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class SGBoardControl implements KeyListener {

    private final SnakeGameBoard snakeGameBoard;
    private final SGBoardModel model;
    private Timer timer;
    private final int DELAY = 150; // velocidad del juego en ms

    public SGBoardControl(SGBoardModel model, SnakeGameBoard snakeGameBoard) {
        this.model = model;
        this.snakeGameBoard = snakeGameBoard;

        // Configurar Timer para actualizar el juego

        timer = new Timer(DELAY, e -> updateGame());
        timer.start();

        snakeGameBoard.getBoardPanel().addKeyListener(this);

        // Asegurar foco
        SwingUtilities.invokeLater(() -> {
            snakeGameBoard.getBoardPanel().requestFocusInWindow();
        });

        // Primera sincronización del estado (importante para evitar NullPointerException al inicio)
        snakeGameBoard.getBoardPanel().setManzana(model.getFood());
        snakeGameBoard.getBoardPanel().setSerpiente(model.getSnake());
        snakeGameBoard.getBoardPanel().repaint();

        snakeGameBoard.setVisible(true);
    }

    private void updateGame() {
        if (!model.isGameOver()) {
            model.moveSnake();

            // ✅ Pasar estado del modelo al BoardPanel
            snakeGameBoard.getBoardPanel().setManzana(model.getFood());
            snakeGameBoard.getBoardPanel().setSerpiente(model.getSnake());

            snakeGameBoard.getScorePanel().updateScore(model.getScore());
            snakeGameBoard.getBoardPanel().repaint();
        } else {
            timer.stop();
            showGameOver();
            snakeGameBoard.addKeyListener(this);
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();

        if (!model.isGameOver()) {
            switch (key) {
                case KeyEvent.VK_UP -> model.setDirection(SGBoardModel.Direction.UP);
                case KeyEvent.VK_DOWN -> model.setDirection(SGBoardModel.Direction.DOWN);
                case KeyEvent.VK_LEFT -> model.setDirection(SGBoardModel.Direction.LEFT);
                case KeyEvent.VK_RIGHT -> model.setDirection(SGBoardModel.Direction.RIGHT);
            }
        } else if (key == KeyEvent.VK_ENTER) {
            resetGame();
        }
    }

    private void resetGame() {
        model.resetGame();
        snakeGameBoard.removeKeyListener(this); // antes de volver al board
        snakeGameBoard.remove(snakeGameBoard.getGameOverPanel());
        snakeGameBoard.add(snakeGameBoard.getBoardPanel(), BorderLayout.CENTER);

        // ✅ Pasa el estado inicial del modelo al BoardPanel
        snakeGameBoard.getBoardPanel().setManzana(model.getFood());
        snakeGameBoard.getBoardPanel().setSerpiente(model.getSnake());

        snakeGameBoard.revalidate();
        snakeGameBoard.repaint();
        snakeGameBoard.getBoardPanel().addKeyListener(this);
        // Foco al tablero
        SwingUtilities.invokeLater(() -> {
            snakeGameBoard.getBoardPanel().requestFocusInWindow();
        });
        snakeGameBoard.getScorePanel().updateScore(model.getScore());
        timer.start();
    }

    private void showGameOver() {
        snakeGameBoard.remove(snakeGameBoard.getBoardPanel());
        snakeGameBoard.add(snakeGameBoard.getGameOverPanel(), BorderLayout.CENTER);
        snakeGameBoard.revalidate();
        snakeGameBoard.repaint();
        snakeGameBoard.setFocusable(true);
        snakeGameBoard.requestFocus();
    }

    @Override
    public void keyReleased(KeyEvent e) {}

    @Override
    public void keyTyped(KeyEvent e) {}
}



