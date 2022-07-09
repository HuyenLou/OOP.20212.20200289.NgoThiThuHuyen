package hust.soict.dsai.aims.screen.customer.controller;


import hust.soict.dsai.aims.cart.Cart.Cart;
import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.media.Playable;
import hust.soict.dsai.aims.store.Store.Store;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.transformation.FilteredList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import static java.lang.Integer.parseInt;

import java.io.IOException;

public class CartController {
	
	private Cart cart;
	private Store store;
	
	public Cart getCart() {
		return cart;
	}

    public Store getStore() {
        return store;
    }

    public void setStore(Store store) {
        this.store = store;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }
	
	public CartController(Store store, Cart cart) {
		this.cart = cart;
		this.store = store;
	}

    @FXML
    private Button btnPlaceOrder;
    
    @FXML
    private TextField tfFilter;

    @FXML
    private Button btnPlay;

    @FXML
    private Button btnRemove;

    @FXML
    private TableColumn<Media, String> colMediaCategory;

    @FXML
    private TableColumn<Media, Float> colMediaCost;

    @FXML
    private TableColumn<Media, Integer > colMediaId;

    @FXML
    private TableColumn<Media, String> colMediaTitle;

    @FXML
    private Label costLabel;

    @FXML
    private ToggleGroup filterCategory;

    @FXML
    private TableView<Media> tblMedia;
    
    @FXML
    private RadioButton radioBtnFilterId;

    @FXML
    private RadioButton radioBtnFilterTitle;

    @FXML
    void btnPlayPressed(ActionEvent event) {
        Media media = tblMedia.getSelectionModel().getSelectedItem();
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Playing...");
        alert.setHeaderText(null);
        alert.setContentText(media.toString());
        alert.showAndWait();
    }

    @FXML
    void btnViewStorePressed(ActionEvent event) {
        try {
       	 final String STORE_FXML_FILE_PATH = ("/hust/soict/dsai/aims/screen/customer/view/Store.fxml");
       	 FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(STORE_FXML_FILE_PATH));
    		 fxmlLoader.setController(new ViewStoreController(store, cart));
    		 Parent root = fxmlLoader.load();
    		 Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
    		 stage.setScene(new Scene(root));
    		 stage.setTitle("Store");
    		 stage.show();
        } catch (IOException e) {
       	 e.printStackTrace();
        }
   }
    
    
    
    
    @FXML 
    public void initialize() {
    	colMediaId.setCellValueFactory(
    			new PropertyValueFactory<Media, Integer>("id"));
		colMediaTitle.setCellValueFactory(
				new PropertyValueFactory<Media, String>("Title"));
		colMediaCategory.setCellValueFactory(
				new PropertyValueFactory<Media, String>("Category"));
		colMediaCost.setCellValueFactory(
				new PropertyValueFactory<Media, Float>("Cost"));	
    	if (cart.getItemsOrdered() != null) {
    		tblMedia.setItems(cart.getItemsOrdered());
    	}
        updateCost();
        
    	btnPlay.setVisible(false);
		btnRemove.setVisible(false);

		tblMedia.getSelectionModel().selectedItemProperty().addListener(
				new ChangeListener<Media>() {
					@Override
					public void changed(ObservableValue<? extends Media> observable, Media oldValue, Media newValue) {
						updateButtonBar(newValue);
					}
				});
        tfFilter.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observableValue, String oldValue, String newValue) {
                showFilteredMedia(newValue);
            }
        });
    }
    
	void updateButtonBar(Media media) {
		if(media == null) {
			btnRemove.setVisible(true);
			btnPlay.setVisible(true);
		}
		else {
			btnRemove.setVisible(true);
			if(media instanceof Playable) {
				btnPlay.setVisible(true);
			} else {
				btnPlay.setVisible(false);
			}
		}
	}
	
	@FXML
	void btnRemovePressed(ActionEvent event) {
		Media media = tblMedia.getSelectionModel().getSelectedItem();
		cart.removeMedia(media);
		updateCost();
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("");
        alert.setHeaderText(null);
        alert.setContentText("Successfully removed!");
        alert.showAndWait();

	}
	
	
    void showFilteredMedia(String newValue) {
        FilteredList<Media> filterData = new FilteredList<>(this.cart.getItemsOrdered(), p -> true);
        filterData.setPredicate(media -> {
            if (newValue.length() == 0) {
                return true;
            }
            String newValueLower = newValue.toLowerCase();

            if (radioBtnFilterId.isSelected()) {
                    int idSearch = parseInt(newValueLower);
                    return media.getId() == idSearch;

            } else if (radioBtnFilterTitle.isSelected()) {
                return media.getTitle().toLowerCase().contains(newValueLower);
            }
            return false;
        });

        tblMedia.setItems(filterData);
    }
    
    @FXML
    void btnPlaceOrderPressed(ActionEvent event) {
        tblMedia.getItems().clear();
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("");
        alert.setHeaderText(null);
        alert.setContentText("Place order successfully!");
        alert.showAndWait();
    }
    
    void updateCost() {
    	costLabel.setText(String.valueOf(this.cart.totalCost()) + "$");
    }




	

}

