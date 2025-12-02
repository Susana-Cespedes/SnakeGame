package vista;

import javax.swing.*;
import java.awt.*;

import static vista.panelJuego.SnakeGameBoard.TILE_SIZE;

public class Food extends JPanel {
    //TILE_SIZE = 15; // Tamaño de cada celda
    private Point food;
    public Food(Point food) {
        this.food=food;
    }
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Comida

        g.setColor(Color.RED);
        g.fillOval(food.x * TILE_SIZE, food.y * TILE_SIZE, TILE_SIZE, TILE_SIZE);

    }
}
