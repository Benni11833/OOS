public class Aufg1 {

    static final int tiefe = 11;

    static int [][]pascal = new int[tiefe][];

	static void init(){
		for(int i=0; i < tiefe; i++){
			pascal[i] = new int[i+1];
		}
	}
  
	static void pascal(){
		for(int i=0; i < tiefe; i++){
			for(int j=0; j < i; j++){
				if(j == 0 || j == i-1){
					pascal[i][j] = 1;
				}else{
					pascal[i][j] = pascal[i-1][j-1] + pascal[i-1][j];
				}
			}//for(int j=0 ...
		}//for(int i=0 ...
	}
  
	static void printVec(){
		for(int i=0; i < tiefe; i++){
			for(int j=0; j < i; j++)
			System.out.print(pascal[i][j] + " ");
		System.out.println();
		}
	}
	
    public static void main(String[] args) {
        init();
		pascal();
		printVec();
    }
}