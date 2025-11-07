package juego;

import java.awt.Color;

import entorno.Entorno;
import entorno.InterfaceJuego;

public class Nuez {
        
    private double x;
    private double y;
    private int ancho;
    private int alto;

    public Nuez(double x, double y, int ancho, int alto) {
        this. x = x;
        this.y = y;
        this.ancho= ancho;
        this.alto= alto;
}

	public void dibujar(Entorno entorno) {
        entorno.dibujarRectangulo(x, y, ancho  , alto  , 0, Color. pink);
        }
    public double getX() { return x; }
    public double getY() { return y; }
}
