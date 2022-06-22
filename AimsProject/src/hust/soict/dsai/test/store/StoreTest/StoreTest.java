package hust.soict.dsai.test.store.StoreTest;

import hust.soict.dsai.aims.media.Book;
import hust.soict.dsai.aims.media.CompactDisc;
import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.store.Store.Store;

public class StoreTest {
    public static void main(String[] args){
        Store store = new Store();
        Book book = new Book("Harry Potter", "Fiction", 12.78f);
    	store.addMedia(book);
    	System.out.println(book.getTitle());
    	System.out.println(book.getCost());
 		CompactDisc cd = new CompactDisc("Star Wars", "Science Fiction", "George Lucas", 87, 24.95f);
 		store.addMedia(cd);

 		DigitalVideoDisc dvd = new DigitalVideoDisc("Star War", "Science Fiction", "George Lucas", 87, 24.95f);
        store.addMedia(dvd);
		
        
        System.out.println(store.searchByTitle("Harry Potter").toString());
        
        store.DisplayStore();

    }
    
}