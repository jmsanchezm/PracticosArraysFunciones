package ejercicio1;

import java.util.Arrays;
import java.util.Scanner;

public class Buscaminas {
	
	//Creamos el Scanner para leer datos y guardarlo directamente en la función.
	static Scanner read= new Scanner(System.in);

	//Posición que el jugador desea destapar
	static int posicion;
	
	//Pista que aguardará los valores de la solución con '?'
	static char pistaSecreta []= new char [20];
	
	//Cantidad de minas disponibles
	public static int numMina=6; 

	//Símbolo de mina
	public static char mina='*';
	
	//Creamos el array de tamaño 20
	public static char  pista []= new char [20];
	
	/**
	 * Este método será usado para generar las minas aleatoriamente.
	 * @return Devolverá la pista con números cercanos a las minas incluidos
	 */
	public static char [] colocMinas () {
		/*Declaramos e inicializamos posAleatoria, donde se guardará
		 *  la posAleatoria para cada mina.*/
		int posAleatoria=0;
		
		//Creamos un for para recorrer el número de minas
		for (int i =0;i<numMina;i++) {
			//Hará lo siguiente
			do {
				//Generará posiciones aleatorias
				posAleatoria=(int)(Math.random()*20);
				//Mientras en la posición que ha generado no haya ya una mina
			}while (pista [posAleatoria]==mina);
			
			//Añadimos la mina
			pista[posAleatoria]=mina;
		}
		
		//Llamamos a la función colocNum, para colocar los números en la pista
		Buscaminas.colocNum(pista);
		
		//Devolvemos la pista 
		return pista;
	}
	
	/**
	 * Este método será utilizado para la colocación de los números 
	 * según cercanía o cantidad de minas tenga alrededor
	 * @param pista
	 */
	static void colocNum (char [] pista){
	
		//Recorremos el array
		for (int i = 0; i <pista.length; i++) {
		
			//Si la posición del array es 0, el contenido de la posición es distinto a la mina y en la posición siguiente tiene una mina:
			if (i == 0 && pista[i]!=mina && pista[i + 1]==mina) {
					//La posición será igual a 1
					pista[i ] = '1';
				}
			
			//O si la posición del array es 19, el contenido de la posición es distinto a la mina y en la posición anterior tiene una mina:
			else if (i == 19 && pista[i]!=mina && pista[i - 1]==mina) {
				//La posición será igual a 1
					pista[i] = '1';
			}
			
			//O si la posición no esta en 0 o 19, la posición anterior es una mina y la siguiente otra:
			else if ((i != 0 && i != 19) && (pista[i - 1]==mina && pista[i + 1] ==mina && pista[i]!=mina )) {
				//La posición será igual a 2
				pista[i] = '2';
			}
			
			//O si la posición no está en 0 o 19, la posición anterior es una mina, o la siguiente, y la posición es distinta a una mina:
			else if ((i != 0 && i != 19) && (pista[i - 1] ==mina || pista[i + 1]==mina) && pista[i]!=mina ) {
				//La posición será igual a 1.
				pista[i] = '1';
			}
			//O si la posición es distinto de una mina:
			else if (pista[i]!=mina ) {
				//La posición será 0-
				pista[i] = '0';
			}
		}	
	}
	
	/**
	 * En este método se llevará a acabo toda la dinámica del juego
	 */
	static void juego () {
		//Irá contando el número de jugadas
		int contadorJugada=20;
		
		//Ordeno que haga:
		do {
			//Solicitamos posición
			System.out.println("Elija una posición a destapar:");
			//Leemos posición
			posicion= read.nextInt();
			//Igualamos las posiciones de los dos arrays para que la posición de pistaSecreta tome el valor
			pistaSecreta[posicion]=pista[posicion];
			//Restamos 1 a contadorJugada
			contadorJugada--;
			//Mostrará la tabla con la modificación
			System.out.println(Arrays.toString(Buscaminas.pistaSecreta));
			
			//Si el contadorJugada llega a 6 y la posición es distinta de la mina.
			if (contadorJugada==6 && pistaSecreta[posicion]!=mina) {
				//El jugador habrá ganado la partida.
				System.out.println("Has ganado");
				//En este caso, se saldrá de la función.
				break;
				}
		//Mientras que el valor de la posición sea distinto a una mina
		}while (pistaSecreta[posicion]!= mina);
			
		//En caso de que el contenido de la posición sea una mina
		if (pistaSecreta[posicion]==mina) {
			//El jugador, habrá perdido
			System.out.println("Has perdido");
		}
	}
	
	/**
	 * Método para rellenar la pista incógnita con '?'.
	 * @return Devolverá la pista rellena con signos de interrogación.
	 */
	static char [] pistaSecret () {
		//Recorremos el array
		for (int i =0; i< pistaSecreta.length;i++) {
			//Iremos añadiendo el símbolo
			pistaSecreta[i]= '?';
		}
		//Retorno de la pista rellena
		return pistaSecreta;
	}
}
	
