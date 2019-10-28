//package übung3;

public class Klasse1 {

	public static void main(String[] args) {
		Klasse2 k2 = new Klasse2();
		k2.pub = 0;
		k2.pro = 0;
		k2.fri = 0;	//Friendly -> Im ganzen Packet nutzbar
		//k2.pri = 0; ->private, nur innerhalb von Klasse2 nutzbar
		
		Klasse3 k3 = new Klasse3();
		k3.pub = 0;
		k3.pro = 0;
		k3.fri = 0;
		
		übung3a.Klasse4 k4 = new übung3a.Klasse4(); //nur bei public class, da friendly Klasse4 nicht im gleichen Package ist
	}

}


class Klasse2{
	public int pub;
	protected int pro;
	int fri;
	private int pri;
}