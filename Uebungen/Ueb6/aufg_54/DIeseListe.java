package aufg_54;

import linListe.IstLeerException;
import linListe.MeineListe;

public class DIeseListe {

	static MeineListe list = new MeineListe();
	
	static void append(MeineListe l) throws CloneNotSupportedException {
		System.out.println("DIeseListe: " + DIeseListe.list + ", L: " + l);
		l = (MeineListe) l.vorhängen(DIeseListe.list);
		DIeseListe.list = l;
		System.out.println("Nach COncat: " + DIeseListe.list);
	}
	
	static void attach(Object o) throws CloneNotSupportedException {
		DIeseListe.append(
				(MeineListe) new MeineListe().vorhängen(o)
				);				
	}
	
	static MeineListe reverse() throws CloneNotSupportedException {
		MeineListe rev = new MeineListe(), run = DIeseListe.list;
		
		/*
		 * [ 1|[2|3] ] -> [ 3 | [2|1] ]
		 */
		
			try {
				
				while(!run.isEmpty()) {
					System.out.println("While");
					rev = (MeineListe) rev.vorhängen(run.head());
					run = (MeineListe) run.tail();
				}
				
			} catch (IstLeerException e) {
				// TODO Auto-generated catch block
				System.out.println("Leer in reverse...");
				e.printStackTrace();
			}
		
		return rev;
	}
	
	static boolean palindrom() throws CloneNotSupportedException {
		return (DIeseListe.list.equals( reverse() ));
	}
	
	public static void main(String[] args) {
		MeineListe l1 = new MeineListe();
		try {
			DIeseListe.list = (MeineListe) DIeseListe.list.vorhängen(3);
			DIeseListe.list = (MeineListe) DIeseListe.list.vorhängen(2);
			DIeseListe.list = (MeineListe) DIeseListe.list.vorhängen(1);
			//DIeseListe.list = (MeineListe) DIeseListe.list.vorhängen(0);
			System.out.println(DIeseListe.list);

			//l1 = (MeineListe) l1.vorhängen(14);
			//l1 = (MeineListe) l1.vorhängen(8);
			
			//append
			//DIeseListe.append(l1);
			
			//attach
			//System.out.println("Vor attach: " + DIeseListe.list);
			//DIeseListe.attach(33);
			//System.out.println("Nach attach(33): " + DIeseListe.list);
			
			//reverse
			System.out.println( DIeseListe.list + " REV: " + DIeseListe.reverse() );
			
			//palindrom
			System.out.println("Palindrom: " + DIeseListe.palindrom());
			
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(DIeseListe.list);
	}

}