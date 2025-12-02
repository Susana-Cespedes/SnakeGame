package controlador;

import model.SGBoardModel;
import vista.panelJuego.SnakeGameBoard;
import vista.intro.SnakeGameIntro;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;


public class SGIntroControl {
    private final SnakeGameIntro view;

    public SGIntroControl(SnakeGameIntro view) {
        this.view = view;
        initListener();
    }

    private void initListener() {
        // Detectar tecla ENTER
        view.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    view.dispose(); // Cierra la pantalla inicial
                    SnakeGameBoard boardFrame = new SnakeGameBoard();
                    SGBoardModel boardModel = new SGBoardModel();
                    new SGBoardControl (boardFrame, boardModel);// Abre la ventana del juego
                }
            }
        });
        // Asegurarse de que la vista tenga el foco para recibir eventos de teclado
        view.setFocusable(true);
        view.requestFocusInWindow();
    }
}
