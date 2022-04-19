
import java.util.Scanner;
import java.util.ArrayList;

public class ex6_4 {
    public static void main(String[] args){
        int number_of_day = 0;
        String month;
        int year;
        ArrayList<String> months_31days = new ArrayList<String>();
        months_31days.add("January");months_31days.add("Jan.");months_31days.add("1");
        months_31days.add("Jan"); months_31days.add("March"); months_31days.add("Mar");
        months_31days.add("Mar."); months_31days.add("3");months_31days.add("May");months_31days.add("5");
        months_31days.add("July"); months_31days.add("Jul"); months_31days.add("7"); months_31days.add("August");
        months_31days.add("Aug"); months_31days.add("Aug.");months_31days.add("8"); months_31days.add("October"); 
        months_31days.add("Oct."); months_31days.add("Oct"); months_31days.add("10");
        months_31days.add("December"); months_31days.add("Dec."); months_31days.add("Dec"); months_31days.add("12");

        ArrayList<String> months_30days = new ArrayList<String>();
        months_30days.add("April"); months_30days.add("Apr"); months_30days.add("Apr."); months_30days.add("4");
        months_30days.add("June"); months_30days.add("Jun"); months_30days.add("6");
        months_30days.add("September"); months_30days.add("Sep."); months_30days.add("Sep"); months_30days.add("9");
        months_30days.add("November"); months_30days.add("11"); months_30days.add("Nov."); months_30days.add("Nov");

        ArrayList<String>special_month = new ArrayList<String>();
        special_month.add("February"); special_month.add("Feb"); special_month.add("Feb."); special_month.add("2"); 
         
        Scanner input = new Scanner(System.in);
        System.out.println("enter the month: ");
        month = input.nextLine();
        if (months_31days.contains(month) == false & months_30days.contains(month) == false & special_month.contains(month) == false){
        	Scanner input2 = new Scanner(System.in);
            System.out.println("enter the month again: ");
            month = input2.nextLine();
        }
        
        System.out.println("enter the year: ");
        year = input.nextInt();
        if (year < 0) {
            	Scanner input3 = new Scanner(System.in);
                System.out.println("enter the year again: ");
                year = input3.nextInt();}
            
        if (months_31days.contains(month) == true){
                number_of_day = 31;
                }
        else if (months_30days.contains(month) == true){
                        number_of_day = 30;}
        else{
                    if ((year % 400 == 0) || ((year % 4 == 0) && (year % 100 != 0))) {
                            number_of_day = 29;
                  } else {
                            number_of_day = 28;
                    }
                }   
            
        System.out.println(month + " of " + year + " has " + number_of_day + " days\n");    
  }  
        } 
  
    
  
    