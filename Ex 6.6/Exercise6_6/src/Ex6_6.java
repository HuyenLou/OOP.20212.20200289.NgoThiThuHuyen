import java.util.Scanner;
public class Ex6_6 {

	public static void main(String[] args) {
	    int m;  
	    int n;  
	    Scanner scanner = new Scanner(System.in);
	         
	    do {
	        System.out.println("the number of row");
	        m = scanner.nextInt();
	        System.out.println("the number of column");
	        n = scanner.nextInt();
	    } while (m < 1 || n < 1);
	         
	    int A[][] = new int[m][n];
	    int B[][] = new int[m][n];
	         
	    int C[][] = new int [m][n];
	         
	    System.out.println("enter theelements of  A:");
	    for (int i = 0; i < m; i++) {
	        for (int j = 0; j < n; j++) {
	            System.out.print("A[" + i + "," + j + "] = ");
	            A[i][j] = scanner.nextInt();
	        }
	    }
	         
	    System.out.println("enter the elements of B:");
	    for (int i = 0; i < m; i++) {
	        for (int j = 0; j < n; j++) {
	            System.out.print("B[" + i + "," + j + "] = ");
	            B[i][j] = scanner.nextInt();
	        }
	    }
	         
	    System.out.println("matrix A:");
	    for (int i = 0; i < m; i++) {
	        for (int j = 0; j < n; j++) {
	            System.out.print(A[i][j] + "\t");
	        }
	        System.out.println("\n");
	    }
	         
	    System.out.println("matrix B:");
	    for (int i = 0; i < m; i++) {
	        for (int j = 0; j < n; j++) {
	            System.out.print(B[i][j] + "\t");
	        }
	        System.out.println("\n");
	    }
	         

	    for (int i = 0; i < m; i++) {
	        for (int j = 0; j < n; j++) {
	            C[i][j] = A[i][j] + B[i][j];
	        }
	    }
	         

	    System.out.println("sum matrix C:");
	    for (int i = 0; i < m; i++) {
	        for (int j = 0; j < n; j++) {
	            System.out.print(C[i][j] + "\t");
	        }
	        System.out.println("\n");
	    }
   }
}