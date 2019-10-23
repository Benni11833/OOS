public class Aufg3 {
	public static void main(String []args) throws CloneNotSupportedException {
		/*KreisAgg k1 = new KreisAgg(3, 1, 2);
		KreisAgg k2 = (KreisAgg) k1.clone();
      	k2.midPoint = new Point(2, 1);
     	System.out.println(k1.equals(k2));*/
		
		/*SammLung []sammlung = new SammLung[2];
		sammlung[0] = new Rechteck(0, 1, 2, 4);*/
		
	}
}

class Point implements Cloneable{
  
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
	
	public Object clone() throws CloneNotSupportedException 
    { 
        return super.clone(); 
    } 
}

class KreisAgg implements Cloneable {
	Point midPoint;
	double radius;
	
	KreisAgg(double radius, int x, int y){
		this.radius = radius;
		this.midPoint = new Point(x, y);
	}
	
	KreisAgg(double radius, Point midPoint){
		this.radius = radius; 
		this.midPoint = midPoint;
	}
	
	boolean equals(KreisAgg k){
		return ( midPoint.equals(k.midPoint) && this.radius == k.radius );
	}
	
	public String toString(){
		return ("KreisAgg: Radius: " + this.radius + ", midPoint: " + this.midPoint.toString() );
	}
	
	public Object clone() throws CloneNotSupportedException 
    { 
        return super.clone(); 
    } 
}

class Rechteck implements Cloneable {
	
	Point linksOben, rechtsUnten;
	
	Rechteck(int x1, int y1, int x2, int y2){
		this.linksOben = new Point(x1, y1);
		this.rechtsUnten = new Point(x2, y2);
	}
	
	Rechteck(Point linksOben, int breite, int laenge){
		this.linksOben = linksOben;
		this.rechtsUnten = new Point(linksOben.x + breite, linksOben.y + laenge);
	}
	
	Rechteck(Point linksOben, Point rechtsUnten){
		this.linksOben = linksOben;
		this.rechtsUnten = rechtsUnten;
	}
	
	int getBreite(){
		return (rechtsUnten.x - linksOben.x);
	}
	
	int getLaenge(){
		return (rechtsUnten.y - linksOben.y);
	}
	
	double getFlaecheninhalt(){
		return getBreite() * getLaenge();
	}
	
	boolean equals(Rechteck r){
		return ( linksOben.equals(r.linksOben) && rechtsUnten.equals(r.rechtsUnten) );
	}
	
	public String toString(){
		return ("Rechteck: linksOben: " + linksOben.toString() + " -- RechtsUnten: " + rechtsUnten.toString());
	}
	
	public Object clone() throws CloneNotSupportedException 
    { 
        return super.clone(); 
    }
	
}