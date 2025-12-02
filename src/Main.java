import controlador.SGIntroControl;
import vista.intro.SnakeGameIntro;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(() -> {
            SnakeGameIntro introFrame = new SnakeGameIntro();
            new SGIntroControl(introFrame);
        });
    }
}