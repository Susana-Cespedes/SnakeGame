package vista.panelJuego;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class BoardPanel extends JPanel {
    private final int TILE_SIZE;
    private Point manzana;
    private List<Point> serpiente;// Lista de segmentos de la serpiente

    public BoardPanel(int TILE_SIZE) {
        this.TILE_SIZE = TILE_SIZE;

        setBackground(new Color(34, 139, 34));
        setBorder(BorderFactory.createLineBorder(new Color(64, 64, 64)));

        setFocusable(true);
    }

    public void setManzana(Point manzana) {
        this.manzana = manzana;
    }

    public void setSerpiente(List<Point> serpiente) {

        this.serpiente = (serpiente != null) ? new ArrayList<>(serpiente) : new ArrayList<>();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        if (manzana == null || serpiente == null || serpiente.isEmpty()) {
            return; // No pintar aún
        }

        // Dibujar comida

        g.setColor(Color.RED);
        g.fillOval(manzana.x * TILE_SIZE, manzana.y * TILE_SIZE, TILE_SIZE, TILE_SIZE);

        // Dibujar la cabeza en negro
        g.setColor(Color.BLACK);
        Point head = serpiente.get(0);
        g.fillRect(head.x * TILE_SIZE, head.y * TILE_SIZE, TILE_SIZE, TILE_SIZE);

        // Dibujar el resto del cuerpo en verde
        g.setColor(Color.GREEN);
        for (int i = 1; i < serpiente.size(); i++) {
            Point p = serpiente.get(i);
            g.fillRect(p.x * TILE_SIZE, p.y * TILE_SIZE, TILE_SIZE, TILE_SIZE);

        }

    }
}



