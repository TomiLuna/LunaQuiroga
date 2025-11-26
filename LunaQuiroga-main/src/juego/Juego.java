package juego;

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
	private Zombie[] zombie;
	private Planta1 planta1;
	private Nuez nuez;
	private DemoColision colision;
	private Carta cartas [];
	// Variables y métodos propios de cada grupo
	// ...
	
	Juego()
	{
		// Inicializa el objeto entorno
		this.entorno = new Entorno(this, "Proyecto para TP", 800, 600);
		this.casilla = new Casilla(400,400,80,80);
		this.tablero = new Tablero(5,10, 80,80);
		this.bala = new Bala(50, 200, 40 ,40,true);
		this.planta1 = new Planta1(120, 320, 50, 50, false,"imagenes/planta1.png");
		this.nuez = new Nuez(200, 320, 50, 50, false, "imagenes/nuez.png");
		this.colision = new DemoColision();
		this.regalos = new Regalo [5];
		
		int filas = 5;
		int anchocasilla = 80;
		for (int i = 0; i < filas; i++) {
			int x = anchocasilla / 2; // ancho de casilla / 2  
			int y = i * anchocasilla + anchocasilla / 2 +200; // alto de casilla * i más el centro
			this.regalos[i] = new Regalo(x, y, 40, 40);
		}
		//this.bala = new Bala(x, y, 40, 40);
		this.zombie = new Zombie [20];
		for(int i = 0; i< zombie.length; i++) {
			int x = 850 + i * 100; // zombie arranca desde fuera de la pantalla
			int y = 200 + (i % 3) *100; //uno por fila
			this.zombie[i]= new Zombie (x, y, 40, 40, false, "imagenes/zombie.gif");
		}
		this.cartas = new Carta[] {
				new Carta(600, 50, 60, 80, "zombie",null,false, "imagenes/zombie.gif"),
				new Carta(100, 50, 100 ,100, "planta", null,false, "imagenes/planta1.png"),
				new Carta(250, 50, 100 ,100, "nuez", null,false,"imagenes/nuez.png"),
		};
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
		if (entorno.tiempo() % 3000 < 20) {  
            spawnearZombie();
		}
		
		for (int i = 0; i < zombie.length; i++) {
		    if (zombie[i] != null) {       // primero verificás que exista
		        zombie[i].dibujar(entorno); // lo dibujás
		        zombie[i].mover();          // lo movés
		        
		        if (bala != null && colision.ColisionZombieBala(zombie[i], bala)) {
		            zombie[i] = null; // zombie eliminado
		    }
				
			
				//if (DemoColision(ColisionZombieRergalo)=true){
					//terminar juego e imprimir "Perdiste"


			}	
		}			
		


	for(Carta c: cartas) {
		c.dibujar(entorno);
	}
	
	this.bala.dibujar(entorno);
	this.bala.mover();
	this.planta1.dibujar(entorno);
	this.nuez.dibujar(entorno);}
	
	public void spawnearZombie() {
	    int fila = (int)(Math.random() * 5); // 5 filas
	    int x = 850; // fuera de pantalla
	    int y = 200 + fila * 80 + 40; // MISMA FORMULA QUE REGALOS
	                                   // 200 = offset implícito
	                                   // 80 = alto casilla
	                                   // 40 = centro
	    for (int i = 0; i < zombie.length; i++) {
	        if (zombie[i] == null) {
	            zombie[i] = new Zombie(x, y, 40, 40, false, "imagenes/zombie.gif");
	            
	        }
	    }

	
	
		}
	
	
	

	@SuppressWarnings("unused")
	public static void main(String[] args)
	{
		Juego juego = new Juego();
	}
}