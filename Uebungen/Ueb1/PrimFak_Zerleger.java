package primfak_zerlegung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class PrimFak_Zerleger {
	
	private boolean check_Primzahl(long zahl) {
		for(long i=2; i < zahl; i++)
			if(zahl % i == 0)
				return false;
		return true;
	}
	
	private long next_Primzahl(long zahl){
	    
	    //checken ob Primzahl:
	    while(!check_Primzahl(++zahl))
	        ;

	    return zahl;
	}

	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(System.in);
		long input = in.nextLong();
	    
	}

}
