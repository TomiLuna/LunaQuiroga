package juego;

import java.awt.Color;
import java.awt.Image;

import entorno.Entorno;
import entorno.Herramientas;

public class Carta {
	private int x;
	private int y;
	private int ancho;
	private int alto;
	private String nombre;
	private String tipo;
	private boolean seleccionada;
	private Image imagen; 

	public Carta(int x, int y, int ancho, int alto, String nombre, String tipo, boolean seleccionada,String archivo) {
		super();
		this.x = x;
		this.y = y;
		this.ancho = ancho;
		this.alto = alto;
		this.nombre = nombre;
		this.tipo = tipo;
		this.seleccionada = seleccionada;
		this.imagen = Herramientas.cargarImagen(archivo);
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
		double escalaX = (double) ancho / imagen.getWidth(null);
        double escalaY = (double) alto / imagen.getHeight(null);
        double escala;
        if(escalaX < escalaY)
        	escala = escalaX;
        else
        	escala = escalaY;
        entorno.dibujarImagen(imagen, x, y, 0, escala);
        		;}	
	
}

