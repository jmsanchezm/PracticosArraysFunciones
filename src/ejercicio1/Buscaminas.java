package ejercicio1;

public class Buscaminas {

	
	public static int numMina=6; 
	public static String mina="*";
	
	public static String  pista []= new String [20];
	public static String [] colocMinas () {
		
		
		
		for (int i =0;i<numMina;i++) {
			pista[posAleatoria()]=mina;
		}
		Buscaminas.colocNum();
		return pista;
	}

	public static int posAleatoria() {
		return (int)(Math.random()*20);
	}
	
	static void colocNum (){
		
		for (int i =0;i<pista.length;i++) {
			if (pista[i]==null) {
				else if (pista[i+1].equals("*") || pista[i-1].equals("*")) {
					pista[i]="1";
				}
				else if (pista[i+1].equals("*") && pista[i-1].equals("*")) {
					pista[i]="2";
				}
				else if (!pista[i-1].equals("*")&&!pista[i+1].equals("*")) {
					pista [i]="0";
				}
			}
		}

	}
}
	
