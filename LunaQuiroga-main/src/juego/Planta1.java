package juego;

import java.awt.Color;
import java.awt.Image;

import entorno.Entorno;
import entorno.Herramientas;

public class Planta1 {
	 private double x;
	    private double y;
	    private int ancho;
	    private int alto;
		private boolean seleccionada;
		private Image imagen;

	    public Planta1(double x, double y, int ancho, int alto, boolean seleccionada,String archivo) {
	        this. x = x;
	        this.y = y;
	        this.ancho= ancho;
	        this.alto= alto;
			this.seleccionada=seleccionada;
			imagen= Herramientas.cargarImagen(archivo);
	}

		public void dibujar(Entorno entorno) {
	        entorno.dibujarRectangulo(x, y, ancho  , alto  , 0, Color. blue);
	        }
	    public double getX() { return x; }
	    public double getY() { return y; }
	    public double getAncho() {return ancho; }
	    public double getAlto() {return alto; }
		public boolean getSeleccionada() {return seleccionada;}

}
