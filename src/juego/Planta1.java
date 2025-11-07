package juego;

import java.awt.Color;

import entorno.Entorno;
import entorno.InterfaceJuego;

public class Planta1 {
        
    private double x;
    private double y;
    private int ancho;
    private int alto;

    public Planta1(double x, double y, int ancho, int alto) {
        this. x = x;
        this.y = y;
        this.ancho= ancho;
        this.alto= alto;
}

	public void dibujar(Entorno entorno) {
        entorno.dibujarRectangulo(x, y, ancho  , alto , Color. orange);
        }

    public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getAncho() {
		return ancho;
	}

	public void setAncho(int ancho) {
		this.ancho = ancho;
	}

	public int getAlto() {
		return alto;
	}

	public void setAlto(int alto) {
		this.alto = alto;
	}

}
