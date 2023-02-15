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
		double punto; //Se guardará la puntuación de la carta seleccionada
		String palo; //Se guardará el nombre del palo
		String media; //Se guardará el nombre de la media
		int mediaPos; //Se guardará la posición del array que nos dará el nombre de la media
		
		//Mientras que la decisión del jugador sea si
		while (decision.equals("si") && sigueJugada) {
			//Generaremos posiciones 
			puntPos= (int)Math.random()*puntos.length;
			paloPos=(int)Math.random()*palos.length;
			
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
	}
	
	/**
	 * Método para el turno del jugador 1
	 */
	static void jugadaJug1 () {
		
		//Ordeno que haga
		do {
		//Pido si quiere carta
		System.out.println("Jugador 1, ¿desea una carta? (si/no)");
		//Lee respuesta
		decision = read.next();
		//Llamo a la función la cuál me dará la carta aleatoria
		cartaAleatoria ();
		//Sumamos la puntuación
		sumaJ1+=punto;
		//Mientras que la respuesta sea distinta de no
		}while (decision.equals("si"));
		//Le muestro la suma total de la puntuacion de las cartas que han ido saliendo
		System.out.println( "La suma de los puntos es"+sumaJ1);
		sigueJugada=false;
	}
	
	static void jugadaJug2 () {
		//Ordeno que haga
		do {
			//Pido si quiere carta
			System.out.println("Jugador 2, ¿desea una carta? (si/no)");
			//Lee respuesta
			decision = read.next();
			//Llamo a la función la cuál me dará la carta aleatoria
			cartaAleatoria ();
			//Sumamos la puntuación
			sumaJ2+=punto;
			//Mientras que la respuesta sea distinta de no
			}while (decision.equals("si"));
			//Le muestro la suma total de la puntuacion de las cartas que han ido saliendo.
			System.out.println( "La suma de los puntos es"+ sumaJ2);
			sigueJugada=false;

	}
	
	/**
	 * Método para comprobar ganador o empate
	 */
	static void comprobacion () {
		/*Creamos las variables auxiliares se inicializaran
		*con la diferencia del limite y la suma de sus puntos
		*/
		double auxJ1 = 7.5 -sumaJ1; //Se inicializaran con la diferencia del limite y la suma
        double auxJ2 = 7.5 - sumaJ2;
		
		//Si las dos puntuaciones son igual al limite
		if (sumaJ1==LIMITE && sumaJ2==LIMITE) {
			//Mostrará empate
			System.out.println("EMPATE");
			//Le damos valor true
			ganador=true;
			
			//Si la suma del jugador 1 es menor que el limite y la suma del jugador 2 se pasa del límite. 
			//O si la diferencia es menor que la del Jugador 1 
		} else if (sumaJ1>LIMITE && sumaJ2<=LIMITE ||auxJ2<auxJ1) {
			//Mostrará que ha ganado el jugador 2
			System.out.println("HA GANADO EL JUGADOR 2");
			//Le damos valor true
			ganador=true;
			
			//Si la suma del jugador 2 es mayor que el limite y la suma del jugador se pasa del limite.
			//O si la diferencia es manor que la del Jugador 2
		}else if (sumaJ2>LIMITE && sumaJ1<=LIMITE || auxJ1<auxJ2) {
			//Mostrará que ha ganado el jugador 1
			System.out.println("HA GANADO EL JUGADOR 1");
			//Le damos valor true
			ganador=true;
		}
	}

	
	
}
