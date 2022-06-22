package hust.soict.dsai.aims.store.Store;


import hust.soict.dsai.aims.media.Media;

import java.util.ArrayList;

import hust.soict.dsai.aims.media.DigitalVideoDisc;

public class Store {

    private final ArrayList<Media> itemsInStore = new ArrayList<Media>();
    
    public ArrayList<Media> getItemsInStore() {
    	return this.itemsInStore;
    }
    public void addMedia(Media media) {
        if (!this.itemsInStore.contains(media)) {
            this.itemsInStore.add(media);
            System.out.println("A media has been added to store!");
        } else {
            System.out.println("The media has already in the store!");
        }
    }                                                                                                                                                                       
    
    public void removeMedia(Media media) {
        if (this.itemsInStore.contains(media) == true) {
            this.itemsInStore.remove(media);
            System.out.println("The Media has been removed!");
        } else {
            System.out.println("This media is not in the store!");
        }
    }
    
    


	public Media searchByTitle(String title) {
		
	       for (Media media : this.itemsInStore){
	            if (media.getTitle().compareToIgnoreCase(title) == 0){
	                return media;
	            }
	        }
	        return null;
	    }
	
	

	public void DisplayStore() {

		if (this.itemsInStore.size() == 0) {
			System.out.println("Store has no item");
		} else {
			for (Media media : this.itemsInStore) {
			System.out.println(media.toString());
			}
		}

	}
    @Override
    public String toString() {
        if (this.itemsInStore.size() == 0) {
            return "There is no media in the store.";
        } else {
            StringBuilder info = new StringBuilder("");
            for (Media media : this.itemsInStore) {
                info.append(media.toString());
                info.append("------------------------\n");
            }
            return info.toString();
        }
    }
}
