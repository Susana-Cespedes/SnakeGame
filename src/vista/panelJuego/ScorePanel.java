package vista.panelJuego;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class ScorePanel extends JPanel {

    private JLabel scoreLabel;
    private JLabel highScoreLabel;
    private int highScore;

    public ScorePanel() {

        setLayout(new GridLayout(1, 2));
        setBackground(new Color(34,139,34));

        scoreLabel = new JLabel("Score: 0");
        highScoreLabel = new JLabel("High Score: 0");

        try {
            // Cargar la fuente desde archivo
            Font retroFont = Font.createFont(Font.TRUETYPE_FONT, new File("resources\\fonts\\PressStart2P-Regular.ttf"))
                    .deriveFont(20f); // Tamaño de la fuente
            highScoreLabel.setFont(retroFont);
            scoreLabel.setFont(retroFont);
        } catch (FontFormatException | IOException e) {
            e.printStackTrace();
            // Si falla, usar fuente por defecto
            highScoreLabel.setFont(new Font("Monospaced", Font.PLAIN, 24));
            scoreLabel.setFont(new Font("Monospaced", Font.PLAIN, 24));
        }

        add(scoreLabel);
        add(highScoreLabel);

        loadHighScore();
        updateHighScore(highScore);

    }

    public void updateScore(int score) {
        scoreLabel.setText("Score: " + score);
        if (score > highScore) {
            highScore = score;
            updateHighScore(highScore);
            saveHighScore();
        }
    }

    public void updateHighScore(int highScore) {
        highScoreLabel.setText("High Score: " + highScore);
    }

    private void loadHighScore() {
        File file = new File("resources/highscore.txt");
        if (file.exists()) {
            try (Scanner sc = new Scanner(file)) {
                if (sc.hasNextInt()) {
                    highScore = sc.nextInt();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void saveHighScore() {
        try (PrintWriter pw = new PrintWriter("resources/highscore.txt")) {
            pw.println(highScore);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}



