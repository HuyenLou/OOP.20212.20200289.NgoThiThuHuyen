package hust.soict.dsai.aims.store.Store;

import hust.soict.dsai.aims.disc.DigitalVideoDisc.DigitalVideoDisc;
import java.util.Scanner;

public class Store {

	int MAX_NUMBERS_ITEMS = 1000;
	DigitalVideoDisc itemsInStore[] = new DigitalVideoDisc[MAX_NUMBERS_ITEMS];
	int CurrentNumberOfItems;

	public void addDVD(DigitalVideoDisc disc) {

		itemsInStore[CurrentNumberOfItems] = disc;
		CurrentNumberOfItems++;
		System.out.println("The disc has been added in store");
	}

	public void removeDVD(DigitalVideoDisc disc) {
		int total = 0;
		DigitalVideoDisc[] Items_Left = new DigitalVideoDisc[MAX_NUMBERS_ITEMS];
		for (int i = 0; i < CurrentNumberOfItems; i++) {
			if (itemsInStore[i].getTitle() != disc.getTitle()) {
				Items_Left[total] = itemsInStore[i];
				total++;

			} else {
				System.out.println("The disc " + itemsInStore[i].getTitle() + " has been erased");
				CurrentNumberOfItems -= 1;
			}
		}
		System.arraycopy(Items_Left, 0, itemsInStore, 0, CurrentNumberOfItems);
		System.out.println("number of discs remaining : " + CurrentNumberOfItems);
	}

	public DigitalVideoDisc searchByTitle(String title) {
		
		int tmp =0;
		int number = 0;
		DigitalVideoDisc search[] = new DigitalVideoDisc[CurrentNumberOfItems];
		for (int i = 0; i < CurrentNumberOfItems; i++) {
			if (itemsInStore[i].getTitle().compareToIgnoreCase(title) == 0) {
				tmp = i;
				number++;
			}
		}
		return itemsInStore[tmp];
	}

	public void DisplayStore() {

		if (CurrentNumberOfItems == 0) {
			System.out.println("Store has no item");
		} else {
			for (int i = 0; i < CurrentNumberOfItems;) {
				itemsInStore[i].toString();
			}
		}

	}
}
