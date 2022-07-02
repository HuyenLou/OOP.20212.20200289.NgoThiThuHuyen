package hust.soict.dsai.aims.screen.manager;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.store.Store.Store;

public class AddDigitalVideoDiscToStore extends AddItemToStoreScreen {

	public AddDigitalVideoDiscToStore(Store store) {
		super(store);
		setTitle("Add DVD");
		
		JLabel lblNewLabel_3 = new JLabel("Director");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_3.setBounds(126, 144, 58, 28);
		contentPane.add(lblNewLabel_3);

		JTextField director = new JTextField();
		director.setBounds(195, 151, 193, 28);
		contentPane.add(director);
		director.setColumns(10);
		
		JLabel lbl = new JLabel("Length");
		lbl.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lbl.setBounds(126, 197, 58, 19);
		contentPane.add(lbl);
		
		JTextField length = new JTextField();
		length.setBounds(197, 195, 191, 27);
		contentPane.add(length);
		length.setColumns(10);
		
		JButton btnNewButton = new JButton("Add");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                String Director = director.getText();
                int Length = Integer.parseInt(length.getText());
				String title = Title.getText();
				String category = Category.getText();
				float cost = Float.parseFloat(Cost.getText());
				DigitalVideoDisc dvd = new DigitalVideoDisc(title, category, Director, Length, cost);
				store.addMedia(dvd);
				success();

			}
		});
		btnNewButton.setBounds(327, 232, 85, 21);
		contentPane.add(btnNewButton);

		this.setVisible(true);
	}

}
