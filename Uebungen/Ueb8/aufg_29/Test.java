package aufg_29;

public class Test {
		public boolean meth (Benutzer ben, Bv bv) {
			return(bv.benutzerOk(ben));
		}	
		
		public static void main(String[] args) {
			System.out.println("Hallo");
			Benutzer b1 = new Benutzer("1", "2".toCharArray());
			Test test = new Test();
			test.meth(b1, new Bv() {

				@Override
				public void benutzerEintragen(Benutzer b) {
					System.out.println("in benEin");
				}
				
			});
		}
	}
