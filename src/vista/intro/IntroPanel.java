package vista.intro;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.Objects;

public class IntroPanel extends JPanel {
    private Image backgroundImage;

    public IntroPanel() {}

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        // Cargar imagen usando getResource
        backgroundImage = new ImageIcon(Objects.requireNonNull(getClass().getResource("/vista/intro/fondo.jpg"))).getImage();

        // Dibujar imagen de fondo
        g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);

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
            g.setFont(new Font("Monospaced", Font.PLAIN, 24));
        }

        //g.setFont(new Font("Arial", Font.BOLD, 16));
        g.drawString("Presione ENTER para comenzar", 70, 225);

    }
}
