package juego;

import java.awt.Color;
import entorno.Entorno;

public class Casilla {
    private double x;
    private double y;
    private int ancho;
    private int alto;
    private boolean ocupada;

    public Casilla(double x, double y, int ancho, int alto) {
        this.x = x;
        this.y = y;
        this.ancho = ancho;
        this.alto = alto;
        this.ocupada = false;
    }

    

	public void dibujar(Entorno entorno) {
        entorno.dibujarRectangulo(x, y, ancho  , alto  , 0, Color.GREEN);
        entorno.dibujarRectangulo(x, y, ancho - 4, alto - 4, 0, Color.white);} // borde //

    public boolean estaOcupada() {
        return ocupada;
    }

    public void setOcupada(boolean ocupada) {
        this.ocupada = ocupada;
    }

    public double getX() { return x; }
    public double getY() { return y; }
}
