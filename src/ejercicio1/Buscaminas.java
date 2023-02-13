package ejercicio1;

public class Buscaminas {

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
}
	
