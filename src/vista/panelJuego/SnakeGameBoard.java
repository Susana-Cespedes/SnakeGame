package vista.panelJuego;

import javax.swing.*;
import java.awt.*;

// Clase para la ventana del juego
public class SnakeGameBoard extends JFrame {
    public static final int TILE_SIZE = 15; // Tamaño de cada celda
    private static final int WIDTH = 600;
    private static final int HEIGHT = 400;

    public SnakeGameBoard() {

        setTitle("Snake");
        setSize(WIDTH, HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Centrar ventana
        setResizable(false);
        setLayout(new BorderLayout(0,0));

        ScorePanel scorePanel = new ScorePanel();
        BoardPanel boardPanel = new BoardPanel();

        add(scorePanel, BorderLayout.NORTH);
        add(boardPanel, BorderLayout.CENTER);
        add(setBorde(), BorderLayout.SOUTH);
        add(setBorde(), BorderLayout.WEST);
        add(setBorde(), BorderLayout.EAST);

        setVisible(true);
    }

    public JPanel setBorde(){
        JPanel borde = new JPanel();
        borde.setBorder(BorderFactory.createEmptyBorder(6,6,6,6));
        borde.setBackground(new Color(0,255,0));
        return(borde);
    }

}
