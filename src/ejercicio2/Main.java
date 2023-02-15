package ejercicio2;

public class Main {

	public static void main(String[] args) {
		
		System.out.println("Jugador 1, ¿desea una carta? (si/no)");
		SieteYMedia.decision=SieteYMedia.read.next();
		SieteYMedia.decision.toLowerCase();
		SieteYMedia.jugadaJug1();
		
		if (SieteYMedia.decision.equals("no")) {
			System.out.println("Jugador 2, ¿desea una carta? (si/no)");
			SieteYMedia.decision=SieteYMedia.read.next();
			SieteYMedia.decision.toLowerCase();
		}
		SieteYMedia.jugadaJug2();
		
		SieteYMedia.esGanador();
	}

}
