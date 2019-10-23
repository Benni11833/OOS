public class Aufg1_eleg {

    static final int tiefe = 10;

    static int []pascal = new int[tiefe];

	static void init(){
		for(int i=0; i < tiefe; i++){
			pascal[i] = -1;
		}
      pascal[0] = pascal[tiefe-1] = 1;
	}
  
	static void print_pascal(){
		int midCounter = 0;
		for(int i=1; i < tiefe; i++){
			if(i%2 == 0)
				midCounter = i/2;
			else
				midCounter = (i+1)/2;
			for(int j=0; j < midCounter; j++){
				//System.out.print(j + " ");
				if(j > 0 && j != midCounter-2){
					pascal[j] = 
				}else{
				  
				}
				System.out.print
			}//for(int j=0 ...
		}//for(int i=0 ...
	}
	
    public static void main(String[] args) {
        init();
		print_pascal();
    }
}