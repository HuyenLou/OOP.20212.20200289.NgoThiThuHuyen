package hust.soict.dsai.aims.screen.manager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.media.Playable;

public class MediaStore extends JPanel {
	private Media media;

	public MediaStore(Media media) {
		this.media = media;
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

		JLabel title = new JLabel(media.getTitle());
		title.setFont(new Font(title.getFont().getName(), Font.PLAIN, 15));
		title.setAlignmentX(CENTER_ALIGNMENT);

		JLabel cost = new JLabel("" + media.getCost() + "$");
		cost.setAlignmentX(CENTER_ALIGNMENT);

		JPanel container = new JPanel();
		container.setLayout(new FlowLayout(FlowLayout.CENTER));

		if (media instanceof Playable) {
			JButton playButton = new JButton("Play");
			container.add(playButton);

			JDialog playDialog = new JDialog();
			playDialog.setTitle(this.media.getTitle());
			JLabel content;
			((Playable) media).play();
			content = new JLabel("Playing...");
			playDialog.add(content);
			playDialog.pack();

			playButton.addActionListener(e -> {
				playDialog.setSize(400, 200);
				playDialog.setVisible(true);
			});
		}
		this.add(Box.createVerticalGlue());
		this.add(title);
		this.add(cost);
		this.add(Box.createVerticalGlue());
		this.add(container);

		this.setBorder(BorderFactory.createLineBorder(Color.BLACK));

	}
}
