import java.util.Scanner;

public class exercise2_2_5 {
	public static double Sum(double a, double b) {
		return a + b;
	}
    public static double Difference(double a, double b) {
    	return Math.abs(a - b);
    }
    public static double product(double a, double b) {
    	return a*b;
    }
    public static void quotient(double a, double b) {
        if (b == 0){
            System.out.println("error can not divide by 0");
        }
        else{
    	    System.out.println("quotient of two numbers: " + a/b);
        }
    }
	public static void main(String[] args) {
		String StrNum1;
		String StrNum2;
		Scanner sc = new Scanner(System.in);
		
		StrNum1 = sc.nextLine();
		StrNum2 = sc.nextLine();
		double num1 = Double.parseDouble(StrNum1);
		double num2 = Double.parseDouble(StrNum2);
		
		System.out.println("sum of two numbers: " + Sum(num1, num2));
        System.out.println("difference of two numbers: " + Difference(num1, num2));
        System.out.println("product of two numbers: " + product(num1, num2));
        quotient(num1, num2);
		
		sc.close();
	}

}