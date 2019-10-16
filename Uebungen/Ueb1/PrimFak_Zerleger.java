package primfak_zerlegung;

import java.io.IOException;
import java.util.Scanner;

public class PrimFak_Zerleger {
	
	private static boolean check_Primzahl(int zahl) {
		for(int i=2; i < zahl; i++)
			if(zahl % i == 0)
				return false;
		return true;
	}
	
	private static int next_Primzahl(int zahl){
	    
	    //checken ob Primzahl:
	    while(!check_Primzahl(++zahl))
	        ;

	    return zahl;
	}
	
	public static void PrimFaktor_Zerlegung(int zahl) {
		System.out.print("PrimFaktorZerlegung: ");
		
		int i = 1;
		
		while(!check_Primzahl(zahl)) {
			i = 1;
			do {
				i = next_Primzahl(i);
			}while(zahl % i != 0);
			zahl /= i;
			System.out.print(i + "*");
		}
		System.out.print(zahl);
		
	}

	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(System.in);
		//long input = in.nextLong();
	    PrimFaktor_Zerlegung(in.nextInt());
	}

}
