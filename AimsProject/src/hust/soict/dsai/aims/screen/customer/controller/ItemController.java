package hust.soict.dsai.aims.screen.customer.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import javax.naming.LimitExceededException;

import hust.soict.dsai.aims.cart.Cart.Cart;
import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.media.Playable;
import hust.soict.dsai.aims.store.Store.Store;
import hust.soict.dsai.test.screen.customer.store.TestViewStoreScreen;
import javafx.geometry.Insets;
import javafx.scene.layout.HBox;

public class ItemController {
	private Cart cart;
	private Store store;
    @FXML
    private Button btnAddToCart;

    @FXML
    private Button btnPlay;

    @FXML
    private Label lblCost;

    @FXML
    private Label lblTitle;




	@FXML
    void btnPlayClicked(ActionEvent event) {
    	Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Playing Window");
        alert.setHeaderText(null);
        alert.setContentText("Playing  " + media.getTitle());
        alert.showAndWait();
    } 
    ViewStoreController viewStoreController = new ViewStoreController(store, cart);
	private Media media;
	public void setData(Media media) {
		this.media = media;
		lblTitle.setText(media.getTitle());
		lblCost.setText(media.getCost() + "$");
		if(media instanceof Playable) {
			btnPlay.setVisible(true);
		}
		else {
			btnPlay.setVisible(false);
			HBox.setMargin(btnAddToCart, new Insets(0, 0, 0, 60));
		}
	}
    @FXML
    void btnAddToCartClicked(ActionEvent event) throws LimitExceededException {
    	
		
		TestViewStoreScreen.getCart().addMedia(this.media);
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Notification");
        alert.setHeaderText("Successfully add to the cart");
        alert.setContentText(media.toString());
        alert.showAndWait();
        
 
    }

}
