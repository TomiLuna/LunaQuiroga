package juego;

import java.awt.Color;
import java.awt.Image;

import entorno.Entorno;
import entorno.Herramientas;

public class Zombie {
	private int x;
	private int y;
	private int ancho;
	private int alto;
	private int direccion;
	private boolean seleccionada;
	private Image imagen;
	
	

	public Zombie (int x, int y, int ancho, int alto, boolean seleccionada, String archivo) {
		super();
		this.x = x;
		this.y = y;
		this.ancho = ancho;
		this.alto = alto;
		this.seleccionada=seleccionada;
		this.direccion = direccion;

		imagen= Herramientas.cargarImagen(archivo);
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
	
	
	public void mover() {
		this.direccion = x--;
	}
	
	public boolean getSeleccionada(){
		return seleccionada;
	}

	public void dibujar(Entorno entorno) {
        entorno.dibujarRectangulo(x, y, ancho  , alto  , 0, Color.yellow);}

}



