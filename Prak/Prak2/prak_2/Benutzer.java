package prak_2;

import java.util.Arrays;

public class Benutzer {

	String userId;
	char [] passWort;
	
	Benutzer(){
		userId = null;
		passWort = null;
	}
	
	Benutzer(String userId, char [] passWort){
		this.userId = userId;
		this.passWort = passWort;
	}
	
	public String toString() {
		return ("Benutzer(" + userId + ", " + String.valueOf(passWort) +  ")");
	}
	
	public boolean equals(Benutzer b) {
		System.out.println(this.userId + " == " + b.userId + " - " 
				+ String.valueOf(this.passWort) + " == " + String.valueOf(b.passWort));
		return (
				this.userId == b.userId && 
				Arrays.equals(this.passWort, b.passWort)
				//String.valueOf(this.passWort) == String.valueOf(b.passWort)
				);				
	}
	
	public static void main(String[] args) {
		Benutzer b1 = new Benutzer("1337", "hello123".toCharArray());
		//System.out.println(b1);
		Benutzer b2 = new Benutzer("1337", "hello124".toCharArray());
		System.out.println(b1.equals(b2));
	}

}
