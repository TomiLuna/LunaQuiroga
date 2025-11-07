package juego;

import java.awt.Color;

import entorno.Entorno;
import entorno.InterfaceJuego;

public class Juego extends InterfaceJuego
{
	// El objeto Entorno que controla el tiempo y otros
	private Entorno entorno;
	private Casilla casilla;
	private Tablero tablero;
	private Regalo[] regalos;
	private Bala bala;
	private Zombie zombie;
	private Planta1 planta1;
	private Nuez nuez;
	private DemoColision colision;
	// Variables y métodos propios de cada grupo
	// ...
	
	/**
	 * 
	 */
	Juego()
	{
		// Inicializa el objeto entorno
		this.entorno = new Entorno(this, "Proyecto para TP", 800, 600);
		this.casilla = new Casilla(400,400,80,80);
		this.tablero = new Tablero(5,10, 80,80);
		this.bala = new Bala(50, 500, 40 ,40,true);
		this.regalos = new Regalo [5];
		this.planta1 = new Planta1(120, 320, 50, 50);
		this.nuez = new Nuez(200, 320, 50, 50);
		int filas = 5;
		int anchocasilla = 80;
		for (int i = 0; i < filas; i++) {
			int x = anchocasilla / 2; // ancho de casilla / 2  
			int y = i * anchocasilla + anchocasilla / 2 +200; // alto de casilla * i más el centro
			this.regalos[i] = new Regalo(x, y, 40, 40);
		}
		this.colision = new DemoColision();
		//this.bala = new Bala(x, y, 40, 40);
		this.zombie = new Zombie (850, 500, 40 ,40);
		// Inicializar lo que haga falta para el juego
		// ...



		// Inicia el juego!
		this.entorno.iniciar();
	}

	/**
	 * Durante el juego, el método tick() será ejecutado en cada instante y 
	 * por lo tanto es el método más importante de esta clase. Aquí se debe 
	 * actualizar el estado interno del juego para simular el paso del tiempo 
	 * (ver el enunciado del TP para mayor detalle).
	 */
	public void tick()
	{
		// Procesamiento de un instante de tiempo
		// ...
		//this.casilla.dibujar(entorno);
		this.tablero.dibujar(entorno);

		if (regalos != null) {
			for (int i = 0; i < regalos.length; i++) {
				regalos[i].dibujar(entorno);
			}
		}
		if (this.zombie != null)
		{
			this.zombie.dibujar(entorno);
		}
	
		

	this.zombie.mover();
	this.bala.dibujar(entorno);
	this.bala.mover();
	this.planta1.dibujar(entorno);
	this.nuez.dibujar(entorno);
	

		if (colision.ColisionZombieBala(zombie, bala)){
				this.zombie = null;

		}

	}
	

	@SuppressWarnings("unused")
	public static void main(String[] args)
	{
		Juego juego = new Juego();
	}
}