package juego;

import java.awt.Color;
import java.awt.Image;

import entorno.Entorno;
import entorno.Herramientas;

public class Nuez {
	private double x;
    private double y;
    private int ancho;
    private int alto;
    private Image imagen;       //como cargar imagenes 
    private boolean seleccionada;

    public Nuez(double x, double y, int ancho, int alto,boolean seleccionada, String archivo) {
        this. x = x;
        this.y = y;
        this.ancho= ancho;
        this.alto= alto;
        this.seleccionada=seleccionada;

        imagen= Herramientas.cargarImagen(archivo);     //cargo archivo de imagenes 
}

    public void dibujar(Entorno entorno) {
    	// Escalar la imagen según el ancho y alto que definiste para la planta
        double escalaX = (double) ancho / imagen.getWidth(null);
        double escalaY = (double) alto / imagen.getHeight(null);
        double escala;
        if(escalaX < escalaY)
        	escala = escalaX;
        else
        	escala = escalaY;
        entorno.dibujarImagen(imagen, x, y, 0, escala);
    }
    public double getX() { return x; }
    public double getY() { return y; }
    public double getAlto() { return alto;}
    public double getAncho() { return ancho; }
    public boolean getSeleccionada(){return seleccionada;}

}
