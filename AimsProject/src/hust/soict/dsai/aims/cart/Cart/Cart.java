package hust.soict.dsai.aims.cart.Cart;

import hust.soict.dsai.aims.disc.DigitalVideoDisc.DigitalVideoDisc;
import hust.soict.dsai.aims.utils.DVDUtils.DVDUtils;

public class Cart {
	public static final int MAX_NUMBERS_ORDERED = 20;
	private DigitalVideoDisc itemsOrdered[] = new DigitalVideoDisc[MAX_NUMBERS_ORDERED];
	private int qtyOrdered;

	public int getQtyOrdered() {
		return qtyOrdered;
	}

	public void addDigitalVideoDisc(DigitalVideoDisc disc) {
		if (qtyOrdered == MAX_NUMBERS_ORDERED) {
			System.out.println("The cart is almost full");
		} else {
			itemsOrdered[qtyOrdered] = disc;
			qtyOrdered++;
			System.out.println("The disc has been added");
		}
	}

	public void removeDigitalVideoDisc(DigitalVideoDisc disc) {

		int total = 0;
		DigitalVideoDisc[] Orders_Left = new DigitalVideoDisc[MAX_NUMBERS_ORDERED];
		for (int i = 0; i < qtyOrdered; i++) {
			if (itemsOrdered[i].getTitle() != disc.getTitle()) {
				Orders_Left[total] = itemsOrdered[i];
				total++;

			} else {
				System.out.println("The disc " + itemsOrdered[i].getTitle() + " has been erased");
				qtyOrdered -= 1;
			}
		}
		System.arraycopy(Orders_Left, 0, itemsOrdered, 0, qtyOrdered);
		System.out.println("number of discs remaining : " + qtyOrdered);
	}

	public float totalCost() {
		float totalCost = 0;
		for (int i = 0; i < qtyOrdered; i++) {
			totalCost += itemsOrdered[i].getCost();
		}
		return totalCost;
	}

	public void addDigitalVideoDisc(DigitalVideoDisc[] dvdList) {
		int first_qtyOrderd = qtyOrdered;
		if (qtyOrdered == MAX_NUMBERS_ORDERED) {
			System.out.println("The cart is almost full");
		} else if (first_qtyOrderd + dvdList.length <= MAX_NUMBERS_ORDERED) {
			for (int i = first_qtyOrderd; i < first_qtyOrderd + dvdList.length; i++) {
				itemsOrdered[i] = dvdList[i - first_qtyOrderd];
				qtyOrdered++;
			}
		} else {
			for (int i = qtyOrdered; i < MAX_NUMBERS_ORDERED; i++) {
				itemsOrdered[i] = dvdList[i - qtyOrdered];
			}
			qtyOrdered = MAX_NUMBERS_ORDERED;
		}

	}

	public void addDigitalVideoDisc(DigitalVideoDisc dvd1, DigitalVideoDisc dvd2) {
		int first_qtyOrderd = qtyOrdered;
		if (qtyOrdered == MAX_NUMBERS_ORDERED) {
			System.out.println("The cart is almost full");
		} else if (first_qtyOrderd + 2 <= MAX_NUMBERS_ORDERED) {
			itemsOrdered[first_qtyOrderd] = dvd1;
			itemsOrdered[first_qtyOrderd + 1] = dvd2;
			qtyOrdered += 2;
		} else {
			itemsOrdered[qtyOrdered] = dvd1;
			qtyOrdered = MAX_NUMBERS_ORDERED;
		}
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
	public DigitalVideoDisc removeByTitle(String title) {
		int tmp =0;
		for (int i = 0; i < qtyOrdered; i++) {
			if (itemsOrdered[i].getTitle().compareToIgnoreCase(title) == 0) {
				tmp = i;
			}
		}
		return itemsOrdered[tmp];
	}
	
	
	public DigitalVideoDisc[] emptyCart() {
		DigitalVideoDisc empty[] = new DigitalVideoDisc[MAX_NUMBERS_ORDERED];
		return empty;
	}
	
	
}
