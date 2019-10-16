package primfak_zerlegung;

import java.util.Scanner;

public class FakultaetsFunktion {
	
	public static void fakultaet(int n) {
		long erg = 1;
		for(long i=2; i <= n; i++) {
			erg *= i;
		}
		System.out.println("!" + n + "= " + erg);
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		fakultaet(in.nextInt());
	}

}