package primfak_zerlegung;

public class Fibonacci_Ausgabe {
	
	static private long []fib_numbers = {1,1,2,3,5,8,13,21,34,55,89,144,233,377,610,987,1597,2584,4181,6765,10946,17711,28657,46368,75025,121393,196418,	317811,514229,832040,1346269,2178309,3524578,5702887,9227465,14930352,24157817,39088169,63245986,	102334155,165580141,267914296,433494437,701408733,
			1134903170,1836311903,2971215073L,4807526976L,7778742049L, 12586269025L};
	
	private static void print_fib() {
		for(int i=0; i < fib_numbers.length; i++) {
			System.out.println( i+1 + " -> " + fib_numbers[i]);
		}
	}
	
	static final int dim1 = 2, dim2 = 2;
	static int[][] a = new int[dim1][dim2];
	static int[][] b = new int[dim1][dim2];
	
	public static void init_matrizen() {
		for(int i=0; i < dim1; i++)
			for(int j=0; j < dim2; j++) {
				a[i][j] = 10*i + j;
				b[i][j] = i + 10*j;
			}
	}
	
	public static void print_matrix(int [][]m) {
		for(int i=0; i < dim1; i++) {
			System.out.println();
			for(int j=0; j < dim2; j++) {
				System.out.print(m[i][j] + "\t");
			}
		}
		System.out.println();
				
	}
	
	public static int[][] matrix_mult(){
		int [][]erg = new int[dim1][dim2];
		
		for(int i=0; i < dim2; i++) {
			for(int j=0; j < dim1; j++) {
				for(int k=0; k < dim2; k++) {
					erg[i][j] += a[i*k][j*k]*b[i*k][j*k];
				}
			}
		}
		
		return erg;
	}
	
	public static void main(String[] args) {
		//print_fib();
		init_matrizen();
		System.out.print("Matrix a: ");
		print_matrix(a);
		System.out.print("\nMatrix b: ");
		print_matrix(b);
		
		System.out.print("\na*b: ");
		print_matrix(matrix_mult());
		
	}

}
