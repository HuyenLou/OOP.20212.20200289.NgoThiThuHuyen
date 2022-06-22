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

import javax.swing.JPanel;

import hust.soict.dsai.aims.media.Book;
import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.store.Store.Store;

public class AddBookToStoreScreen extends AddItemToStoreScreen {

	public AddBookToStoreScreen(Store store) {
		super(store);
 
		setTitle("Add Book");	
		JLabel lblNewLabel_3 = new JLabel("Authors");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_3.setBounds(126, 144, 58, 28);
		contentPane.add(lblNewLabel_3);

		JTextField Authors = new JTextField();
		Authors.setBounds(195, 151, 193, 28);
		contentPane.add(Authors);
		Authors.setColumns(10);

		JButton btnNewButton = new JButton("Add");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ArrayList<String> authors = new ArrayList<>();
				Collections.addAll(authors, Authors.getText().split(",", 0));
				String title = Title.getText();
				String category = Category.getText();
				String cost = Cost.getText();
				float cost_ = Float.parseFloat(cost);
				Book book = new Book(title, category, cost_, authors);
				store.addMedia(book);
				success();

			}
		});
		btnNewButton.setBounds(327, 232, 85, 21);
		contentPane.add(btnNewButton);

		this.setVisible(true);
	}

}
