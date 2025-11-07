package juego;

import java.awt.Color;

import entorno.Entorno;

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
	        entorno.dibujarRectangulo(x, y, ancho  , alto  , 0, Color. blue);
	        }
	    public double getX() { return x; }
	    public double getY() { return y; }
	    public double getAncho() {return ancho; }
	    public double getAlto() {return alto; }

}
