
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
        // Detectar tecla ENTER en la pantalla de inicio
        view.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    // Cierra la pantalla inicial
                    view.dispose();

                    // Crear la ventana principal del juego
                    SnakeGameBoard gameBoard = new SnakeGameBoard();
                    SGBoardModel boardModel = new  SGBoardModel();

                    // Crear el controlador principal con todas las referencias
                    new SGBoardControl(boardModel, gameBoard);
                }
            }
        });

        // Asegurar que la vista inicial tenga el foco para recibir eventos
        view.setFocusable(true);
        //view.requestFocusInWindow();
    }
}




