package hust.soict.dsai.test.media;

import java.util.ArrayList;
import java.util.List;

import hust.soict.dsai.aims.media.Book;
import hust.soict.dsai.aims.media.CompactDisc;
import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.media.Media;

public class TestPolymorphismToString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        List<Media> mediae = new ArrayList<Media>();
        List<String> authors = new ArrayList<String>();
        authors.add("JK");
        Book book = new Book("Harry Potter", "Fiction", 12.78f, authors);

		CompactDisc cd = new CompactDisc("Star Wars", "Science Fiction", "George Lucas", 87, 24.95f);

		DigitalVideoDisc dvd = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 87, 24.95f);
        mediae.add(cd);
        mediae.add(dvd);
        mediae.add(book);
        
        for(Media m : mediae) {
        	System.out.println(m.toString());
        }
	}

}
