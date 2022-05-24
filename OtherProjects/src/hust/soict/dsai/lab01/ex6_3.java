package hust.soict.dsai.lab01;
import java.util.Scanner;

public class ex6_3 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n, k = 0;
		System.out.println("height of n stars :  ");
		n = scanner.nextInt();
		for( int i = 1; i <= n; ++i, k = 0 ) {
			for (int space = 1; space <= n-i; ++space ) {
				System.out.print(" ");
			}
			while (k != 2*i -1) {
				System.out.print("*");
				++k;
			}
			System.out.println();
		}
	}

}
