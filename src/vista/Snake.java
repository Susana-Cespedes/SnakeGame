package vista;

import javax.swing.*;
import java.awt.*;
import java.util.List;

import static vista.panelJuego.SnakeGameBoard.TILE_SIZE;

public class Snake extends JPanel{
    //TILE_SIZE = 15; // Tamaño de cada celda
    private List<Point> snake; // Lista de segmentos de la serpiente
    public Snake(List<Point> snake) {
        this.snake=snake;
    }
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Dibujar la cabeza en negro
        g.setColor(Color.BLACK);
        Point head = snake.get(0);
        g.fillRect(head.x * TILE_SIZE, head.y * TILE_SIZE, TILE_SIZE, TILE_SIZE);

        // Dibujar el resto del cuerpo en verde
        g.setColor(Color.GREEN);
        for (int i = 1; i < snake.size(); i++) {
            Point p = snake.get(i);
            g.fillRect(p.x * TILE_SIZE, p.y * TILE_SIZE, TILE_SIZE, TILE_SIZE);
        }

    }
}
