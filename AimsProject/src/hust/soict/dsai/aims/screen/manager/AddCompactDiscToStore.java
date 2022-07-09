package hust.soict.dsai.aims.screen.manager;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

import hust.soict.dsai.aims.media.CompactDisc;
import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.media.Track;
import hust.soict.dsai.aims.store.Store.Store;

public class AddCompactDiscToStore extends AddItemToStoreScreen {

	public AddCompactDiscToStore(Store store) {
		super(store);
		setTitle("CD");
		JLabel lblNewLabel_3 = new JLabel("Artist");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_3.setBounds(126, 144, 58, 28);
		contentPane.add(lblNewLabel_3);

		JTextField Artist = new JTextField();
		Artist.setBounds(195, 151, 193, 28);
		contentPane.add(Artist);
		Artist.setColumns(10);

		JLabel lbl = new JLabel("Director");
		lbl.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lbl.setBounds(126, 197, 58, 19);
		contentPane.add(lbl);

		JTextField Director = new JTextField();
		Director.setBounds(197, 195, 191, 27);
		contentPane.add(Director);
		Director.setColumns(10);

		JLabel lblNewLabel_4 = new JLabel("Tracks");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_4.setBounds(126, 237, 45, 13);
		contentPane.add(lblNewLabel_4);

		JTextField Tracks = new JTextField();
		Tracks.setBounds(197, 232, 191, 28);
		contentPane.add(Tracks);
		Tracks.setColumns(10);

		JButton btnNewButton = new JButton("Add");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String artist = Artist.getText();
				String title = Title.getText();
				String category = Category.getText();
				String director = Director.getText();
				float cost = Float.parseFloat(Cost.getText());
				CompactDisc CD = new CompactDisc(title, category, director, artist, cost);
				if (!Tracks.getText().isEmpty()) {
					for (String line : Tracks.getText().split(",", 0)) {
						if (createTrack(line) != null) {
							try {
								CD.addTrack(createTrack(line));
							} catch (Exception e1) {
								e1.printStackTrace();
							}
						}
					}
					store.addMedia(CD);
					success();

				}
			}
		});
		btnNewButton.setBounds(432, 324, 85, 21);
		contentPane.add(btnNewButton);

		this.setVisible(true);
	}

	Track createTrack(String line) {
		String titleTrack = line.split("-")[0];
		String lengthTrack = line.split("-")[1];
		int length = Integer.parseInt(lengthTrack);

		return new Track(titleTrack, length);

	}

}
