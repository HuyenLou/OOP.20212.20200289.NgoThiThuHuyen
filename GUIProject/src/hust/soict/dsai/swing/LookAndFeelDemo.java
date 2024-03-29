package hust.soict.dsai.swing;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;

public class LookAndFeelDemo extends JFrame {
     public LookAndFeelDemo() {
    	 
    	 addDemoComponents();
    	 addLookAndFeelComboBox();
    	 
    	 setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	 setSize(30,100);
    	 setVisible(true);
     }
     
     void addDemoComponents() {
    	 Container cp = getContentPane();
    	 cp.setLayout(new FlowLayout());
    	 cp.add(new JLabel("JLabel:"));
    	 cp.add(new JTextField("Text field"));
    	 cp.add(new JRadioButton("Radio button"));
    	 cp.add(new JButton("Button"));
    	 
     }
     
     void addLookAndFeelComboBox() {
    	 Container cp = getContentPane();
    	 cp.add(new JLabel("Change Look and Feel Here"));
    	 
    	 LookAndFeelInfo[] lafInfos = UIManager.getInstalledLookAndFeels();
    	 String Java = UIManager.getCrossPlatformLookAndFeelClassName();
    	 String System = UIManager.getSystemLookAndFeelClassName();
    	 
    	 String[] lafClassName = new String[lafInfos.length+2];
    	 for (int i=0; i < lafInfos.length; i++) {
    		 lafClassName[i] = lafInfos[i].getClassName();
    	 }
    	 lafClassName[lafInfos.length] = UIManager.getCrossPlatformLookAndFeelClassName();
    	 lafClassName[lafInfos.length + 1] = UIManager.getSystemLookAndFeelClassName();

    	 String[] lafNames = new String[lafInfos.length + 2];
    	 for (int i=0; i < lafInfos.length; i++) {
    		 lafNames[i] = lafInfos[i].getName();
    	 }
    	 lafNames[lafInfos.length] = "Java";
    	 lafNames[lafInfos.length + 1] = "System";
    	 
    	 JComboBox cbLookAndFeel = new JComboBox(lafNames);
    	 cp.add(cbLookAndFeel);
    	 
    	 JFrame frame = this;
    	 cbLookAndFeel.addActionListener(new ActionListener(){
    		 @Override
    		 public void actionPerformed(ActionEvent ae) {
    			 int index = cbLookAndFeel.getSelectedIndex();
    			 try {
    				 UIManager.setLookAndFeel(lafClassName[index]);
    			 } catch (Exception e) {
    				 e.printStackTrace();
    			 }
    			 SwingUtilities.updateComponentTreeUI(frame);
    			 setTitle(lafNames[index] + " Look And Feel");
    			 
    		 }
    	 });
     }
     public static void main(String[] args) {
    	 new LookAndFeelDemo();
     }
}
