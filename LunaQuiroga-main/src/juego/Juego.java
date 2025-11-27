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
	private Zombie[] zombie;
	private Planta1 planta1;
	private Nuez nuez;
	private DemoColision colision;
	private Carta cartas [];
	private int zombiesEliminados = 0;
	private int zombiesTotales = 50;
	private boolean juegoTerminado = false;
	private int ultimoDisparo = 0;      // momento del último disparo
	private final int intervaloDisparo = 1000; // 1 segundo entre disparos
	// Variables y métodos propios de cada grupo
	// ...
	
	Juego()
	{
		// Inicializa el objeto entorno
		this.entorno = new Entorno(this, "Proyecto para TP", 800, 600);
		this.casilla = new Casilla(400,400,80,80);
		this.tablero = new Tablero(5,10, 80,80);
		this.bala = null;
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
		int filas1= 5;
		int altoCasilla = 80;
		for(int i = 0; i< zombie.length; i++) {
			int x = 850 + i * 100; // zombie arranca desde fuera de la pantalla
			int fila = i % filas1;  // 0..4
			int y =200 + fila * altoCasilla + altoCasilla / 2; //uno por fila
			this.zombie[i]= new Zombie (x, y, 40, 40, false, "imagenes/zombie.gif");
		}
		this.cartas = new Carta[] {
				new Carta(600, 150, 60, 80, "zombie",null,false, "imagenes/zombie.gif", 5000),
				new Carta(100, 150, 100 ,100, "planta", null,false, "imagenes/planta1.png", 5000),
				new Carta(250, 150, 100 ,100, "nuez", null,false,"imagenes/nuez.png", 5000),
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
		
		if (!juegoTerminado) {
		Color barraColor = new Color(200, 200, 200); // gris claro
	    entorno.dibujarRectangulo(400, 50, 800, 100, 0, barraColor); // barra de 100px altura arriba
	    
	    int sec = entorno.tiempo() / 1000;
	    int minutos = sec / 60;
	    int segundos = sec % 60;
	    entorno.cambiarFont("Arial", 20, Color.BLACK, entorno.NEGRITA);
	    entorno.escribirTexto(String.format("Tiempo: %02d:%02d", minutos, segundos), 100, 30);
	    
	    int zombiesVivos = 0;
        for (Zombie z : zombie) {
            if (z != null) zombiesVivos++;
        }
	    int zombiesRestantes = zombiesTotales- zombiesEliminados; // supongamos que 50 es total
	    entorno.escribirTexto("Zombies eliminados: " + zombiesEliminados, 500, 30);
	    entorno.escribirTexto("Zombies restantes: " + zombiesRestantes, 500, 60);
		
	    for(Carta c: cartas) {
			c.dibujar(entorno);
		}
	    
		this.tablero.dibujar(entorno);
		
		//dibujo regalos
		if (regalos != null) {
			for (int i = 0; i < regalos.length; i++) {
				regalos[i].dibujar(entorno);
			}
		}
		
		int tiempoActual = entorno.tiempo();
	    if (planta1 != null && bala == null && tiempoActual - ultimoDisparo >= intervaloDisparo) {
	        bala = new Bala((int)(planta1.getX() + planta1.getAncho()/2), (int)planta1.getY(), 20, 20, true);
	        ultimoDisparo = tiempoActual;
	    }
		

		// Solo spawnear si hay menos de 15 zombies en pantalla y no pasamos 50 totales
		if (zombiesVivos < 15 && zombiesEliminados + zombiesVivos < 50) {
		    // cada 3 segundos
		    if (entorno.tiempo() / 3000 > (entorno.tiempo() - 20) / 3000) {
		        spawnearZombie();
		    }
		}
		
		for (int i = 0; i < zombie.length; i++) {
			Zombie z = zombie[i];
            if (z != null) {
                z.dibujar(entorno);
                boolean puedeMover = true;
			
	            
	            // Colisión Zombie con Planta ---
	            if (planta1 != null && colision.ColisionZombiePlanta(z, planta1)) {
	                planta1 = null;      // planta muere
	                puedeMover = false;  // zombie se frena
	            }

	            // Colisión Zombie con Nuez ---
	            if (nuez != null && colision.ColisionZombieNuez(z, nuez)) {
	                puedeMover = false;  // nuez lo frena
	                nuez.recibirDaño();
	                if (nuez.estaMuerta()) {
	                    nuez = null;
	                    puedeMover = true;
	                }    
	            }

	            // MOVER SI CORRESPONDE ---
	            if (puedeMover) {
	                z.mover();
	            }

	            //  Colisión Bala - Zombie ---
	            if (bala != null && colision.ColisionZombieBala(z, bala)) {

	                z.Golpe();     // baja vida zombie
	                bala = null;   // bala desaparece

	                if (z.getVida() <= 0) {
	                    zombie[i] = null; // zombie muere
	                    zombiesEliminados++;
	                }
	            }
	            
	         // Colisión con regalo → termina juego
                for (Regalo r : regalos) {
                    if (r != null && colision.ColisionZombieRergalo(z, r)) {
                        juegoTerminado = true;
                        System.out.println("¡Perdiste! Un zombie tocó el regalo.");
	        }
	    }	
		
    //actualizar bala
	if (bala != null) {
	    bala.dibujar(entorno);
	    bala.mover();
	    if (bala.getX() > 900) {
	        bala = null;
	    }
	}
	
	// dibuja planta y nuez
	if (this.planta1 != null) {
	    this.planta1.dibujar(entorno);
	}

	if (this.nuez != null) {
	    this.nuez.dibujar(entorno);
	
	    if (zombiesEliminados >= zombiesTotales) {
            juegoTerminado = true;
            System.out.println("¡Ganaste! Todos los zombies eliminados.");
        }

    } else {
        // --- Juego terminado ---
        entorno.cambiarFont("Arial", 30, Color.RED, entorno.NEGRITA);
        entorno.escribirTexto("Juego Terminado", 400, 300);}
            }
		}
    }
	}       
	
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

	
	
		
	
	    if (!juegoTerminado) {
	        for (Zombie z : zombie) {
	            if (z != null) {
	                for (Regalo r : regalos) {
	                    if (r != null && colision.ColisionZombieRergalo(z, r)) {
	                        juegoTerminado = true;
	                        System.out.println("¡Perdiste! Un zombie tocó el regalo.");
	                        break;
	                    }
	                }
	            }
	            if (juegoTerminado) break;
	        }

	        if (zombiesEliminados >= zombiesTotales) {
	            juegoTerminado = true;
	            System.out.println("¡Ganaste! Todos los zombies eliminados.");
	        }
	    } else {
	        entorno.cambiarFont("Arial", 30, Color.RED, entorno.NEGRITA);
	        entorno.escribirTexto("Juego Terminado", 400, 300);
	    }
	}
	@SuppressWarnings("unused")
	public static void main(String[] args)
	{
		Juego juego = new Juego();
	}
}