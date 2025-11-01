package juego;

import java.awt.Color;

import entorno.Entorno;

public class Tablero {
    private int filas;
    private int columnas;
    private int anchoCasilla;
    private int altoCasilla;

    public Tablero(int filas, int columnas, int anchoCasilla, int altoCasilla) {
        this.filas = filas;
        this.columnas = columnas;
        this.anchoCasilla = anchoCasilla;
        this.altoCasilla = altoCasilla;
    }

    public void dibujar(Entorno entorno) {
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                int x = j * anchoCasilla + anchoCasilla / 2; // centro de la casilla
                int y = i * altoCasilla + altoCasilla / 2;

                // alternar colores para ver la grilla
                Color color = ((i + j) % 2 == 0) ? Color.LIGHT_GRAY : Color.DARK_GRAY;

                entorno.dibujarRectangulo(x, y, anchoCasilla, altoCasilla, 0, color);
            }
        }
    }
}
