package vista.panelJuego;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class ScorePanel extends JPanel {
    public ScorePanel() {
        setBackground(new Color(0,255,0));
        setLayout(new FlowLayout(FlowLayout.LEFT));
        JLabel scoreLabel = new JLabel("Score: 0 ");
        scoreLabel.setForeground(new Color(64,64,64));

        JLabel highScoreLabel = new JLabel("Highscore: 100", SwingConstants.CENTER);
        highScoreLabel.setForeground(new Color(64,64,64));
        //highScoreLabel.setFont(new Font("Arial", Font.BOLD, 20));
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

    }
}


