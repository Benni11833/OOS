package linkedListPackage;

public class LinkedList {
	
	public static void main(String[] args) {
		System.out.println("Hello");
	}

	private Node head = null;
	
	class Node {
		Object item;
		Node next;
		Node(Object n){
			item = n;
			next = null;
		}
	}
	
	public boolean isEmpty() {
		return (head == null);
	}
	
	private Node lastNode() throws LinkedListException {
		if(this.isEmpty())
			throw new LinkedListException("Liste leer!");
		else {
			Node n = head;
			while(n.next != null)
				n = n.next;
			return n;
		}
	}
	
	public void insertNode(Object o){
		if(this.isEmpty())
			head = new Node(o);
		else
			lastNode().next = new Node(o);
	}
	
	public boolean deleteNode(Node n) {
		Node run1 = head, run2 = run1;
		while(run1 != null && run1 != n) {
			run1 = run1.next;
			run2 = run2.next;
		}
		if(run1 == null)
			return false;
		
		//else
		run2.next = run1.next;
		return true;
	}

}
