import java.util.Scanner;

public class exercise2_2_6 {
    
	public static void linear_equation(double a, double b) {
		double root = 0;

        System.out.println("linear equation: " + a + "x + " + b + " = 0.");
        if (a == 0) {
            if (b == 0) {
                System.out.println("This equation has infinitely many solutions.");
            } else {
                System.out.println("This equation has no solution.");
            }
        } else {
                root = (double) -b / a; 
                System.out.println("the root of this equation: x = " + root);
            }		
	}
    public static void linear_system(double a11, double a12, double a21, double a22, double b1, double b2) {
        double det = ((a11) * (a22) - (a12) * (a21));  
        double det1 = ((a22) * (b1) - (a12) * (b2));
        double det2 = ((a11) * (b2) - (a21) * (b1));
        if ( det != 0 ){
            double x = det1 / det;
            double y = det2 / det;
            System.out.println("x=" + x + " y=" + y);
        } 
        else if (det1 != 0 || det2 != 0){
            System.out.println("This linear system has no solution.");
        }
        else  {
            System.out.println("This linear system has infinitely many solutions.");
        }  
    }
    public static void second_degree_equation(double a, double b, double c) {

        if (a == 0) {
            if (b == 0) {
                System.out.println("This equation has no solution.");
            } else {
                System.out.println("This equation has 1 solution. "
                        + "x = " + (-c / b));
            }
            return;
        }
        double delta = b*b - 4*a*c;
        double x1;
        double x2;
        if (delta > 0) {
            x1 = (double) ((-b + Math.sqrt(delta)) / (2*a));
            x2 = (double) ((-b - Math.sqrt(delta)) / (2*a));
            System.out.println("This equation has 2 distinct solution. "
                    + "x1 = " + x1 + " và x2 = " + x2);
        } else if (delta == 0) {
            x1 = (-b / (2 * a));
            System.out.println("The equation has a double solution:"
                    + "x1 = x2 = " + x1);
        } else {
            System.out.println("This equation has no solution.");
        }
    }

    
    public static void main(String[] args){
        int type;
        double a, b, c, a11, a12, a21, a22, b1, b2;
        Scanner input = new Scanner(System.in);
        System.out.println("enter the type of equation you want to solve:(enter 1 if linear equation, 2 if linear system, 3 if  second-degree equation) ");
        type = input.nextInt();

        switch (type){
            case 1: 
            System.out.println("enter the value of a: ");
            a = input.nextDouble();
            
            System.out.println("enter the value of b: ");
            b = input.nextDouble();
            linear_equation(a, b);
            break;  

            case 2:
            System.out.println("enter the value of a11: ");
            a11 = input.nextDouble();
            
            System.out.println("enter the value of a12: ");
            a12 = input.nextDouble();

            System.out.println("enter the value of b1: ");
            b1 = input.nextDouble();
            
            System.out.println("enter the value of a21: ");
            a21 = input.nextDouble();
            
            System.out.println("enter the value of a22: ");
            a22 = input.nextDouble();
            
            System.out.println("enter the value of b2: ");
            b2 = input.nextDouble();

            linear_system(a11, a12, a21, a22, b1, b2);
            break;

            case 3:
            System.out.println("enter the value of a: ");
            a = input.nextDouble();
            
            System.out.println("enter the value of b: ");
            b = input.nextDouble();

            System.out.println("enter the value of c: ");
            c = input.nextDouble();

            second_degree_equation(a, b, c);
            break;
        
            default:
                System.out.println("enter the type of equation again");
                break;
        }

    }     
}