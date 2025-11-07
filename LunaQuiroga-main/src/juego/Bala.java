package juego;

import java.awt.Color;

import entorno.Entorno;

public class Bala {
	int x;
	int y;
	int ancho;
	int alto;
	boolean direccion;
	
	
	public Bala(int x, int y, int ancho, int alto, boolean direccion) {
		super();
		this.x = x;
		this.y = y;
		this.ancho = ancho;
		this.alto = alto;
		this.direccion = direccion;
	}
	
	public void mover() {
		if ( this.direccion)
			x++;
		else {
			x--;
		}
	}
	
	public void dibujar(Entorno entorno) {
        entorno.dibujarRectangulo(x, y, ancho  , alto  , 0, Color.blue);}

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
