package juego;

import java.awt.Color;

import entorno.Entorno;

public class Carta {
	private int x;
	private int y;
	private int ancho;
	private int alto;
	private String nombre;
	private String tipo;
	private boolean seleccionada;

	public Carta(int x, int y, int ancho, int alto, String nombre, String tipo, boolean seleccionada) {
		super();
		this.x = x;
		this.y = y;
		this.ancho = ancho;
		this.alto = alto;
		this.nombre = nombre;
		this.tipo = tipo;
		this.seleccionada = seleccionada;
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

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	public boolean getSeleccionada() {
		return this.seleccionada;
	}

	public void  setSeleccionada(boolean seleccionada) {
		this.seleccionada = seleccionada;
	}
	public void dibujar(Entorno entorno) {
        entorno.dibujarRectangulo(x, y, ancho  , alto  , 0, Color.RED
        		);}	
	
}

