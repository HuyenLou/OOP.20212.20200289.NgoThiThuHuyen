package hust.soict.dsai.aims.screen.manager;


import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;

import javax.swing.JTextField;

import hust.soict.dsai.aims.media.Book;
import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.store.Store.Store;

public class AddItemToStoreScreen extends JFrame {
	private Store store;
	protected JPanel contentPane;
	JTextField Title;
	JTextField Category;
	JTextField Cost;
	
	public AddItemToStoreScreen(Store store) {

		setTitle("Add Item");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 568, 406);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Title");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setBounds(130, 22, 46, 32);
		contentPane.add(lblNewLabel);

		Title = new JTextField();
		Title.setBounds(197, 26, 191, 28);
		contentPane.add(Title);
		Title.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("Category");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(126, 63, 60, 32);
		contentPane.add(lblNewLabel_1);

		Category = new JTextField();
		Category.setColumns(10);
		Category.setBounds(197, 68, 191, 28);
		contentPane.add(Category);

		JLabel lblNewLabel_2 = new JLabel("Cost");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2.setBounds(126, 111, 76, 23);
		contentPane.add(lblNewLabel_2);

		Cost = new JTextField();
		Cost.setBounds(197, 106, 191, 28);
		contentPane.add(Cost);
		Cost.setColumns(10);

		JMenuBar menuBar = new JMenuBar();
		menuBar.setToolTipText("View Store");
		menuBar.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		menuBar.setBounds(10, 0, 107, 22);
		contentPane.add(menuBar);

		JMenu mnNewMenu = new JMenu("Options");
		mnNewMenu.setFont(new Font("Segoe UI", Font.BOLD, 14));
		menuBar.add(mnNewMenu);

		JMenuItem mntmNewMenuItem = new JMenuItem("View Store");
		mntmNewMenuItem.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new StoreManagerScreen(store);

			}

		});
		mnNewMenu.add(mntmNewMenuItem);
	}

	public void success() {

		JFrame f = new JFrame();
		JOptionPane.showMessageDialog(f, "Successfully Updated.", "Alert", JOptionPane.WARNING_MESSAGE);

		this.setVisible(true);
	}
}
