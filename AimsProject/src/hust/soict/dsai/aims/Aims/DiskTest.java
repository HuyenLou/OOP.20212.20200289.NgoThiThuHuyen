package hust.soict.dsai.aims.Aims;

import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.media.Media;

public class DiskTest {

	public static void main(String[] args) {
		
		// TODO Auto-generated method stub
		Media dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Aller", 87, 19.95f);

		Media dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 87, 24.95f);

		Media dvd3 = new DigitalVideoDisc("Aladin", "Animation", 18.99f);
		
		System.out.println(dvd2.getId());
		System.out.println(dvd1.getId());
		
	}

}
