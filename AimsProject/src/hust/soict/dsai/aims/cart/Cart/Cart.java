package hust.soict.dsai.aims.cart.Cart;

import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.utils.DVDUtils.DVDUtils;

import java.util.ArrayList;
public class Cart {
	public static final int MAX_NUMBERS_ORDERED = 20;
	public float totalCost() {
		float totalCost = 0;
		for (int i = 0; i < qtyOrdered; i++) {
			totalCost += itemsOrdered[i].getCost();
		}
		return totalCost;
	}

	public void sortCartByCost() {
		DigitalVideoDisc realOrdered[] = new DigitalVideoDisc[qtyOrdered];
		for (int i = 0; i < qtyOrdered; i++) {
			realOrdered[i] = itemsOrdered[i];
		}
		DigitalVideoDisc[] sorted = DVDUtils.sortByCost(realOrdered);
		System.out.println("sort by cost: ");

		for (int i = 0; i < sorted.length; i++) {
			System.out.println(sorted[i].toString());
		}
	}

	public void sortCartByTitle() {
		DigitalVideoDisc realOrdered[] = new DigitalVideoDisc[qtyOrdered];
		for (int i = 0; i < qtyOrdered; i++) {
			realOrdered[i] = itemsOrdered[i];
		}
		DigitalVideoDisc[] sorted = DVDUtils.sortByTitle(realOrdered);
		System.out.println("sort by cost: ");

		for (int i = 0; i < sorted.length; i++) {
			System.out.println(sorted[i].toString());
		}
	}

	public void searchByID(int id) {
		int count = 0;
		for (int i = 0; i < qtyOrdered; i++) {
			if (itemsOrdered[i].getId() == id) {
				count++;
				System.out.println("item has id " + id + " is: " + itemsOrdered[i].toString());
			}
		}
		if (count == 0) {
			System.out.println("no match is found.");
		}
	}
	public void searchByTitle(String title) {
		int count = 0;
		for (int i = 0; i < qtyOrdered; i++) {
			if (itemsOrdered[i].getTitle().compareToIgnoreCase(title) == 0) {
				count++;
				System.out.println("item has title " + title + " is: " + itemsOrdered[i].toString());
			}
		}
		if (count == 0) {
			System.out.println("no match is found.");
		}
	}

	public void print() {
		DigitalVideoDisc realOrdered[] = new DigitalVideoDisc[qtyOrdered];
		for (int i = 0; i < qtyOrdered; i++) {
			realOrdered[i] = itemsOrdered[i];
		}
		DigitalVideoDisc[] sorted = DVDUtils.sortByTitle(realOrdered);
		DigitalVideoDisc temp = sorted[0];
		for (int i = 0; i < qtyOrdered - 1; i++) {
			if (sorted[i].getTitle().compareToIgnoreCase(sorted[i + 1].getTitle()) == 0) {
				if (Float.compare(sorted[i].getCost(), sorted[i + 1].getCost()) == -1) {
					temp = sorted[i];
					sorted[i] = sorted[i + 1];
					sorted[i + 1] = temp;
				} else {
					if (Integer.compare(sorted[i].getLength(), sorted[i + 1].getLength()) == -1) {
						temp = sorted[i];
						sorted[i] = sorted[i + 1];
						sorted[i + 1] = temp;
					}
				}
			}
		}
		System.out.println("***********************CART***********************");
		for (int i = 0; i < sorted.length; i++) {
			System.out.println(sorted[i].toString());
		}
		System.out.println("***************************************************");
	}


	public void DisplayByTitle() {
		DigitalVideoDisc realOrdered[] = new DigitalVideoDisc[qtyOrdered];
		for (int i = 0; i < qtyOrdered; i++) {
			realOrdered[i] = itemsOrdered[i];
		}
		DigitalVideoDisc[] sorted = DVDUtils.sortByTitle(realOrdered);
		DigitalVideoDisc temp = sorted[0];
		for (int i = 0; i < qtyOrdered - 1; i++) {
			if (sorted[i].getTitle().compareToIgnoreCase(sorted[i + 1].getTitle()) == 0) {
				if (Float.compare(sorted[i].getCost(), sorted[i + 1].getCost()) == -1) {
					temp = sorted[i];
					sorted[i] = sorted[i + 1];
					sorted[i + 1] = temp;
				}

			}
		}
		System.out.println("***********************CART***********************");
		for (int i = 0; i < sorted.length; i++) {
			System.out.println(sorted[i].toString());
		}
		System.out.println("***************************************************");
	}
	public void DisplayByCost() {
		DigitalVideoDisc realOrdered[] = new DigitalVideoDisc[qtyOrdered];
		for (int i = 0; i < qtyOrdered; i++) {
			realOrdered[i] = itemsOrdered[i];
		}
		DigitalVideoDisc[] sorted = DVDUtils.sortByCost(realOrdered);
		DigitalVideoDisc temp = sorted[0];
		for (int i = 0; i < qtyOrdered - 1; i++) {
			if (Float.compare(sorted[i].getCost(), sorted[i + 1].getCost()) == 0) {
				if (sorted[i].getTitle().compareToIgnoreCase(sorted[i + 1].getTitle()) > 0) {
					temp = sorted[i];
					sorted[i] = sorted[i + 1];
					sorted[i + 1] = temp;
				}

			}
		}
		System.out.println("***********************CART***********************");
		for (int i = 0; i < sorted.length; i++) {
			System.out.println(sorted[i].toString());
		}
		System.out.println("***************************************************");
	}
	public DigitalVideoDisc[] emptyCart() {
		DigitalVideoDisc empty[] = new DigitalVideoDisc[MAX_NUMBERS_ORDERED];
		return empty;
	}
	
	
}
