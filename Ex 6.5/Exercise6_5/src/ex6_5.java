import java.util.Scanner;
import java.text.DecimalFormat;

class ex6_5 {
	public static double Sum(double a[]) {
		int sum = 0;
		for (int i = 0; i < a.length; i++) {
			sum += a[i];
		}
		return sum;
	}
	public static double Average(double a[]) {
		return Sum(a)/a.length;
		
	}
    public static void main(String[] args) {
        int num, i, j;
        double temp;
        Scanner input = new Scanner(System.in);
        System.out.println("enter the number of elements in the array:");
        num = input.nextInt();
        double array[] = new double[num];
        System.out.println("Enter the values of the elements in the array:");
        for (i = 0; i < num; i++)
            array[i] = input.nextDouble();
        for (i = 0; i < (num - 1); i++) {
            for (j = 0; j < num - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
        DecimalFormat df = new DecimalFormat("#.##");
        System.out.println("after sorting: ");
        for (i = 0; i < num; i++) {
            System.out.print(array[i] + "\t");
        }
        System.out.println();
        System.out.println("sum of value of array elements : " + Sum(array));
        System.out.println("average of value of array elements : " + df.format(Average(array)));
    }
}