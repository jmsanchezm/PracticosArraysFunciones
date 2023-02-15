package ejercicio1;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		System.out.println("¡¡BUSCAMINAS!!");
		System.out.println("QUÉ COMIENCE LA PARTIDA.");
		Buscaminas.colocMinas();
		System.out.println (Arrays.toString(Buscaminas.pistaSecret()));
		Buscaminas.juego();
	}

}
