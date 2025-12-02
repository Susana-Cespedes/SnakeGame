package model;

import java.awt.*;
import java.util.Timer;
import java.util.List;

public class SGBoardModel {


    private List<Point> snake; // Lista de segmentos de la serpiente
    private Point food;        // Posición de la comida
    private Timer timer;       // Control del movimiento
    private String direction = "RIGHT"; // Dirección inicial
    private int score = 0;
    private int highScore = 0;
    private boolean gameOver = false;
}

