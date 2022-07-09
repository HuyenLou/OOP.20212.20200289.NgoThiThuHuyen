package hust.soict.dsai.test.screen.customer.store;

import javax.naming.LimitExceededException;

import hust.soict.dsai.aims.cart.Cart.Cart;
import hust.soict.dsai.aims.media.Book;
import hust.soict.dsai.aims.media.CompactDisc;
import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.screen.customer.controller.ViewStoreController;
import hust.soict.dsai.aims.store.Store.Store;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class TestViewStoreScreen extends Application{
	private static Store store;
	private static Cart cart; 
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		final String STORE_FXML_FILE_PATH = "/hust/soict/dsai/aims/screen/customer/view/Store.fxml";
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(STORE_FXML_FILE_PATH));
		ViewStoreController viewStoreController = new ViewStoreController(store, getCart());
		fxmlLoader.setController(viewStoreController);
		Parent root = fxmlLoader.load();
		 
		primaryStage.setTitle("Store");
		primaryStage.setScene(new Scene(root));
		primaryStage.show();
		
	}
	public static void main(String[] args) throws LimitExceededException {
		store = new Store();
		Book book = new Book("HP", "Fiction", 12.78f);
    	store.addMedia(book);

 		CompactDisc cd = new CompactDisc("Robot", "Science Fiction", "Unknown", "Unknown", 12.24f);
 		store.addMedia(cd);

 		DigitalVideoDisc dvd = new DigitalVideoDisc("Stars War", "Science Fiction", "George Lucas", 87, 24.95f);
        store.addMedia(dvd);
        
        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Aller", 87, 19.95f);
		store.addMedia(dvd1);
		
		DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin", "Animation", 18.99f);
		store.addMedia(dvd3);
        
        
		cart = new Cart();
		

		DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 87, 24.95f);
		cart.addMedia(dvd2);

		
		Book book1 = new Book("Harry Potter", "Fantasy", 30.00f);
		cart.addMedia(book1);
		launch(args);
	}
	public static Cart getCart() {
		return cart;
	}
	public static void setCart(Cart cart) {
		TestViewStoreScreen.cart = cart;
	}

}
