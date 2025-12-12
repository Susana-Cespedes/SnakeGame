package vista.intro;

import javax.swing.*;

public class SnakeGameIntro extends JFrame {

    public SnakeGameIntro() {
        setTitle("Snake Game");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Centrar ventana
        setResizable(false);

        // Panel para dibujar la pantalla inicial con imagen de fondo
        IntroPanel panelIntro = new IntroPanel();
        add(panelIntro);

    }

}


