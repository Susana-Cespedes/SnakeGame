package vista.panelJuego;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class GameOver extends JPanel {
    public GameOver() {


    }
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Pantalla Game Over
        g.setColor(Color.RED);
        g.setFont(new Font("Ink Free", Font.BOLD, 36));
        g.drawString("GAME OVER", getWidth() / 2 - 120, getHeight() / 2 - 20);

        // Dibujar texto encima del fondo
        g.setColor(Color.BLACK);

        try {
            // Cargar la fuente desde archivo
            Font retroFont = Font.createFont(Font.TRUETYPE_FONT, new File("resources\\fonts\\PressStart2P-Regular.ttf"))
                    .deriveFont(9f); // Tamaño de la fuente
            g.setFont(retroFont);

        } catch (FontFormatException | IOException e) {
            e.printStackTrace();
            // Si falla, usar fuente por defecto
            g.setFont(new Font("Monospaced", Font.PLAIN, 12));
        }

        //g.setFont(new Font("Arial", Font.BOLD, 16));
        g.drawString("Presione ENTER para reiniciar", 70, 225);

        }
}
