package sample;

import java.io.Serializable;
import java.util.Arrays;

/**
 * Benutzer stellt einen Benutzer mit eindeutiger userId und passwort, dar
 *
 */

public class Benutzer implements Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
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
	/**
	 * @return Benutzer als String
	 */
	public String toString() {
		//@return Benutzer als string
		return ("Benutzer(" + userId + ", " + String.valueOf(passWort) +  ")");
	}

	/**
	 * @param Object o: Benutzer zum vergleichen
	 * @return true, falls Beide Benutzer gleiche Id und passwort, sonst false
	 * @return false, falls nicht true
	 */
	public boolean equals(Object o) {

		//System.out.println(this.userId + " == " + b.userId + " - " + String.valueOf(this.passWort) + " == " + String.valueOf(b.passWort));
		if(o == null || !(o instanceof Benutzer))
			return false;
		Benutzer b = (Benutzer) o;
		return (
				this.userId.equals(b.userId) &&
				Arrays.equals(this.passWort, b.passWort) //array vergleich
				//String.valueOf(this.passWort) == String.valueOf(b.passWort)
				);
	}

	public static void main(String[] args) {
		/*Benutzer b1 = new Benutzer("1337", "hello123".toCharArray());
		//System.out.println(b1);
		Benutzer b2 = new Benutzer("1337", "hello124".toCharArray());
		System.out.println(b1.equals(b2));
		*/
	}

}
