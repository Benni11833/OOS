public class Aufg2 {
	public static void main(String []args){
		//KreisVererb p = new KreisVererb(2, 3, 4);
		//System.out.print(p.equals(new KreisVererb(0, 1, 4)));
      	Point p1 = new Point(3, 4);
		Point p2 = new Point(4, 4);
		System.out.println(p1.equals(p2));
        System.out.println(p1);
	}
}


class Point {
  
	int x, y;
	
	Point(){
		this.x = this.y = 0;
	}
	
	Point(Point p){
		this.x = p.x;
		this.y = p.y;
	}
	
	Point(int x, int y){
		this.x = x;
		this.y = y;
	}
	
	Point getLocation(){
		return this;
	}
	
	void setLocation(Point p){
		this.x = p.x;
		this.y = p.y;
	}
	
	void setLocation(int x, int y){
		this.x = x;
		this.y = y;
	}
	
	void move(int dx, int dy){
		this.x += dx;
		this.y += dy;
	}
	
	boolean equals(Point p){
		System.out.println("X: " + this.x + " == " + p.x + " - Y: " + this.y + " == " + p.y);
		return (this.x == p.x && this.y == p.y);
	}
	
	public String toString(){
		return ("X: " + this.x + ", Y: " + this.y);
	}
}



class KreisVererb extends Point {
	double radius;
	
	KreisVererb(){
		super();
		this.radius = 1;
	}
	
	KreisVererb(double radius){
		super();
		this.radius = radius;
	}
	
	KreisVererb(double radius, Point p){
		super(p);
		this.radius = radius;
	}
	
	KreisVererb(double radius, int x, int y){
		super(x, y);
		this.radius = radius;
      	System.out.println("Radius set to : " + this.radius + " von " + radius);
	}
	
	void setRadius(double radius){
		this.radius = radius;
	}
	
	double getUmfang(){
		return 2 * Math.PI * this.radius;
	}
	boolean equals(KreisVererb k){
      System.out.println(this.radius + " == " + k.radius);
		return (super.equals(k) && this.radius == k.radius);
	}
	
	public String toString(){
		return ( "Radius: " + this.radius + ", " + super.toString());
	}
}
