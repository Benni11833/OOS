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
	
	public Object clone() {	//testen
		MeineListe newList = new MeineListe();
		Node runNode1 = this.head, runNode2;
		
		if (runNode1 != null){
			newList.head = new Node(runNode1.item);
			runNode1 = runNode1.next;
		}
		
		runNode2 = newList.head;
		
		while(runNode1 != null) {
			runNode2.next = new Node(runNode1.item);
			runNode1 = runNode1.next;
			runNode2 = runNode2.next;
		}
		
		return newList;
	}
	
	public boolean equals(Object l) {
		MeineListe ml = (MeineListe) l;
		/*try {
			return ( ml.head.item.equals(this.head.item) && ml.tail().equals(this.tail()) );
		}catch(IstLeerException e) {
			e.printStackTrace();
		}
		return false;*/
		
		Node run1 = this.head, run2 = ml.head;
		
		while(run1 != null && run2 != null) {
			if(!run1.item.equals(run2.item)) {
				return false;
			}else {
				run1 = run1.next;
				run2 = run2.next;
			}
		}//entweder run1 und/oder run2 sind null
		
		System.out.println("Hier");
		
		//run1 und run2 muessen beide null sein
		return (run1 == run2);		
	}

	
	//Problem: alte Liste wird ohne clone zerschossen
	public LinListe vorhängen(Object obj) throws CloneNotSupportedException {
		MeineListe ml = (MeineListe) this.clone();
		//System.out.println("In Clone... this: " + this.head + ", ml: " + ml.head);
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