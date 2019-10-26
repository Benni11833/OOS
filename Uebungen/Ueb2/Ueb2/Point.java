package Ueb2;

public class Point {
	int x, y;
	
	Point(){
		x = y = 0;
	};
	Point(Point p){	//??
		 this.x = p.x;
		 this.y = p.y;
	}
	Point(int x, int y){
		this.x = x;
		this.y = y;
	}
	
	Point getLocation() {
		return this;
	}
	
	void setLocation(Point p) {
		this.x = p.x;
		this.y = p.y;
	}
	
	void setLocation(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	void move(int dx, int dy) {
		this.x += dx;
		this.y += dy;
	}
	
	boolean equals(Point p) {
		return (this.x == p.x && this.y == p.y);
	}
	
	public String toString() {
		return (
			"X: "+this.x + ", Y: " + this.y
		);
	}
}
