package ejercicio1;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		
		
			
		Buscaminas.letrerosComienzo();
		System.out.println (Arrays.toString(Buscaminas.colocMinas()));
		System.out.println (Arrays.toString(Buscaminas.pistaSecret()));
		Buscaminas.juego();
		
		
		

	}

}
