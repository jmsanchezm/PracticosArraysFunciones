package ejercicio2;

import java.util.Scanner;

public class SieteYMedia {
	
	//Creamos el Scanner 
	static Scanner read= new Scanner (System.in);

	//Se guardarán los puntos
	static double puntos []= {1,2,3,4,5,6,7,0.5};
	
	//Se guardarán los palos
	static String [] palos = {"oros", "espadas", "copas", "bastos"};
	
	//Se guardarán el nombre de las mediass
	static String [] medias= {"sota", "caballo","rey"};
	
	//Se guardará la respuesta del jugador de si quiere más cartas o no.
	static String decision;
	
	//Se guardarán los puntos de la carta aleatoria
	static double punto;
	
	//Se guardará la suma de los puntos del Jugador 1
	static double sumaJ1=0;
	
	//Se guardará la suma de los puntos del Jugador 2
	static double sumaJ2=0;
	
	//Constante para el limite
	static final double LIMITE = 7.5;
	
	static boolean ganador=false;
	
	static boolean sigueJugada = true;
	/**
	 * Método que generará la carta aleatoria
	 */
	
	static void cartaAleatoria () {
		//Declaramos las variables necesarias
		int puntPos; //Se guardará la posición del array que nos dará el número de la carta
		int paloPos; // Se guardará la posición del array que nos dará el palo de la carta
		String palo; //Se guardará el nombre del palo
		String media; //Se guardará el nombre de la media
		int mediaPos; //Se guardará la posición del array que nos dará el nombre de la media
		
			//Generaremos posiciones 
			puntPos= (int)(Math.random()*puntos.length);
			paloPos=(int)(Math.random()*palos.length);
			
			//Igualamos el contenido de la posición de cada array a cada una de las variables
			palo = palos [paloPos];
			punto= puntos [puntPos];
			
			//En el caso de que los puntos sean 0.5,
			if (punto==0.5) {
				//Generará una posición 
				mediaPos=(int)Math.random()*medias.length;
				//Igualamos el contenido de la posicion a la variable media
				media=medias[mediaPos];
				//Y mostraremos el nombre de la media con su debido palo
				System.out.println("La carta es " + media + " de " + palo);
			}else { //Por el contrario
				//Mostrará la puntuación de la carta con su debido palo
				System.out.println("La carta es " + punto + " de " + palo);
			}
			
		}

	
	/**
	 * Método para el turno del jugador 1
	 */
	static void jugadaJug1 () {
		
		while (decision.equals("si")) {
			
			SieteYMedia.cartaAleatoria();
			sumaJ1+=punto;
			System.out.println("Tienes " + sumaJ1 + " puntos");
			if (sumaJ1 > LIMITE) {
				System.out.println("Has perdido, te has pasado...");
				System.out.println("Ha ganado Jugador 1");
				break;
			}
			
			System.out.println("Jugador 1, ¿desea otra carta? (si/no)");
			SieteYMedia.decision = read.next();
			SieteYMedia.decision.toLowerCase();
			System.out.println();
		}
	}
	
	static void jugadaJug2 () {
		punto=0;
		while (decision.equals("si")) {		
			
			SieteYMedia.cartaAleatoria();
			sumaJ2+=punto;
			System.out.println("Tienes " + sumaJ2 + " puntos");
			if (sumaJ1 > LIMITE) {
				System.out.println("Has perdido, te has pasado...");
				System.out.println("Ha ganado Jugador 1");
				break;
			}
			System.out.println("Jugador 2, ¿desea otra carta? (si/no)");
			SieteYMedia.decision = read.next();
			SieteYMedia.decision.toLowerCase();
			System.out.println();
		}
	}
	
	public static void esGanador() {
		if (decision.equals("no")) {
			if (sumaJ1 > sumaJ2) {
				System.out.println("HA GANADO JUGADOR 1");
			}else if (sumaJ2 > sumaJ1) {
				System.out.println("HA GANADO JUGADOR 2");
			}else if (sumaJ1 == sumaJ2) {
				System.out.println("¡¡EMPATE!!");
			}
		}
	}
	
	
}
