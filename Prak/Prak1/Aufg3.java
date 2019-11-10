public class Aufg3 {

    static double getGesamtFlaecheninhalt(Figur f_array[]){
        double sum = 0;
        for (Figur f : f_array){
            if(f != null){
                System.out.println(f.getFlaecheninhalt());
                sum += f.getFlaecheninhalt();
            }
        }
        return sum;
    }

	public static void main(String []args) throws CloneNotSupportedException {
		KreisAgg k1 = new KreisAgg(3, 1, 2);
		KreisAgg k2 = (KreisAgg) k1.clone();
      	Figur []figuren = new Figur[10];
      	figuren[0] = new Rechteck(3, 1, 2, 4);
      	//figuren[1] = k1;
      	//figuren[2] = k2;
      	//figuren[3] = new KreisAgg(9, 1, 1);
        figuren[1] = new Rechteck(3, 1, 3, 4);

        System.out.println( "Gesamter FLaecheninhalt: " + getGesamtFlaecheninhalt(figuren) );
		
	}
}


interface Figur{
	public double getFlaecheninhalt();
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
		//System.out.println("X: " + this.x + " == " + p.x + " - Y: " + this.y + " == " + p.y);
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

class KreisAgg implements Figur, Cloneable {
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
	
	public double getFlaecheninhalt() {
		return Math.PI * this.radius * this.radius;
	}
	
	public boolean equals(KreisAgg k){
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

class Rechteck implements Figur, Cloneable {
	
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
        //System.out.println(rechtsUnten.x + " - " + linksOben.x + " = " + (rechtsUnten.x - linksOben.x) );
		return (linksOben.x - rechtsUnten.x);
	}
	
	int getLaenge(){
		return (rechtsUnten.y - linksOben.y);
	}
	
	public double getFlaecheninhalt(){
		return getBreite() * getLaenge();
	}
	
	public boolean equals(Rechteck r){
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
