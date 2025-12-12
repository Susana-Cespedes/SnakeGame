package vista.panelJuego;
import javax.swing.*;
import java.awt.*;

public class SnakeGameBoard extends JFrame {
    private final int TILE_SIZE = 15; // Tamaño de cada celda
    private final int WIDTH = 600;
    private final int HEIGHT = 400;
    private final int boardWidth = 540;// Definir tamaño del tablero en píxeles
    private final int boardHeight = 330;

    private BoardPanel boardPanel;
    private ScorePanel scorePanel;
    private GameOver gameOverPanel;

    public SnakeGameBoard() {
        setTitle("Snake");
        setSize(WIDTH, HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Centrar ventana
        setResizable(false);
        setLayout(new BorderLayout(0,0));

        // Inicializar paneles
        scorePanel = new ScorePanel();
        boardPanel = new BoardPanel(TILE_SIZE);
        // Ajustar tamaño del panel
        boardPanel.setPreferredSize(new Dimension(boardWidth, boardHeight));

        gameOverPanel = new GameOver();

        add(scorePanel, BorderLayout.NORTH);
        add(boardPanel, BorderLayout.CENTER);
        add(setBorde(), BorderLayout.SOUTH);
        add(setBorde(), BorderLayout.WEST);
        add(setBorde(), BorderLayout.EAST);

        pack();
        setVisible(true);

    }

    public JPanel setBorde(){
        JPanel borde = new JPanel();
        borde.setBorder(BorderFactory.createEmptyBorder(6,6,6,6));
        borde.setBackground(new Color(34,139,34));
        return(borde);
    }


    // ✅ Getters para que SGIntroControl pueda acceder
    public BoardPanel getBoardPanel() {
        return boardPanel;
    }

    public ScorePanel getScorePanel() {
        return scorePanel;
    }

    public GameOver getGameOverPanel() {
        return gameOverPanel;
    }

    public int getTILE_SIZE() {
        return TILE_SIZE;
    }


}

