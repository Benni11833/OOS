package linListe;

public class MeineListe implements LinListe {

	
	public boolean isEmpty() {
		return (this.head == null);
	}

	
	public Object head() throws IstLeerException {
		if (this.isEmpty()) throw new IstLeerException 
 							("Liste ist leer!");
		return this.head.item;
	}

	
	public LinListe tail() throws IstLeerException {
		if (this.isEmpty()) throw new IstLeerException 
 							("Liste ist leer!");
		MeineListe ml = new MeineListe();
		ml.head = this.head.next;
		return ml;
	}

	
	//Problem: alte Liste wird ohne clone zerschossen
	public LinListe vorhängen(Object obj) {
		MeineListe ml = (MeineListe) this.clone();
		Node newHead = new Node(obj);
		newHead.next = ml.head;
		ml.head = newHead;
		return ml;
	}
	
	//Üblicherweise leere Liste separat behandeln
	public String toString() {
	  try {
	    return (	this.head().toString() + 
				this.tail().toString());
		} catch (IstLeerException e) {
			return "";
		}
	}
	

	class Node {
		Object item;
		Node next;
		Node(Object item) {
			this.item = item;
		}
	}
	
	private Node head = null;

}
