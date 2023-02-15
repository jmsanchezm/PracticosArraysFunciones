package ejercicio2;

public class Main {

	public static void main(String[] args) {
		
		System.out.println("JUEGO DE LAS SIETE Y MEDIA");
		System.out.println("¡¡Qué comience el juego!!");
		do {
			SieteYMedia.jugadaJug1();
			SieteYMedia.jugadaJug2();
			SieteYMedia.comprobacion();
		}while (!SieteYMedia.ganador);

	}

}
