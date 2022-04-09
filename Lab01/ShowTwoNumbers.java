import javax.swing.JOptionPane;

public class ShowTwoNumbers {
    public static void main(String[] arg){
        String strNum1, strNum2;
        String strNotification = "you are just entered: ";
        strNum1 = JOptionPane.showInputDialog(null, "please input the first number: ", "input the first number", JOptionPane.INFORMATION_MESSAGE);
        strNotification += strNum1 + " and ";

        strNum2 = JOptionPane.showInputDialog(null, "please input the second number: ", "input the seconnd number", JOptionPane.INFORMATION_MESSAGE);
        strNotification += strNum2 + " and ";

        JOptionPane.showMessageDialog(null, strNotification, "show two numbers", JOptionPane.INFORMATION_MESSAGE);
        System.exit(0);
    }
    
}