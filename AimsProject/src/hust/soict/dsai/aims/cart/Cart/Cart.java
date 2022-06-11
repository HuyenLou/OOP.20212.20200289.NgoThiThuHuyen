package hust.soict.dsai.aims.cart.Cart;

import hust.soict.dsai.aims.media.DigitalVideoDisc;

import hust.soict.dsai.aims.media.Media;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Cart {
	public static final int MAX_NUMBERS_ORDERED = 20;
	private final ArrayList<Media> itemsOrdered = new ArrayList<Media>();

	public boolean check_Max() {
		if (this.itemsOrdered.size() < MAX_NUMBERS_ORDERED) {
			return false;
		}
		return true;
	}

	public void addMedia(Media media) {
		if (check_Max() == false) {
			if (this.itemsOrdered.contains(media) == false) {
				this.itemsOrdered.add(media);
				System.out.println("A media has been added");
			} else {
				System.out.println("The media has already been in the cart");
			}
		} else {
			System.out.println("The cart is full");
		}
	}

	public void addMedia(Media[] mediaList) {
		for (Media media : mediaList) {
			this.addMedia(media);
		}
	}

	public void addMedia(Media media1, Media media2) {
		this.addMedia(media1);
		this.addMedia(media2);
	}

	public void removeMedia(Media media) {
		if (this.itemsOrdered.contains(media) == true) {
			this.itemsOrdered.remove(media);
			System.out.println("This media has been removed");
		} else {
			System.out.println("This media is not in the cart");
		}
	}

	public float totalCost() {
		float total = 0;
		if (this.itemsOrdered.size() < 5) {
			for (Media media : this.itemsOrdered) {
				total += media.getCost();
			}
			return total;
		} else {
			Media luckyItem = getALuckyItem();
			for (Media media : this.itemsOrdered) {
				if (media.equals(luckyItem) == false) {
					total += media.getCost();
				}
			}
		}
		return total;
	}

	public void searchByID(int id) {
		int count = 0;
		for (int i = 0; i < this.itemsOrdered.size(); i++) {
			if (this.itemsOrdered.get(i).getId() == id) {
				count++;
				System.out.println("item has id " + id + " is: " + this.itemsOrdered.get(i).toString());
			}
		}
	}

	public void searchByTitle(String title) {
		int count = 0;
		for (int i = 0; i < this.itemsOrdered.size(); i++) {
			if (this.itemsOrdered.get(i).getTitle().compareToIgnoreCase(title) == 0) {
				count++;
				System.out.println("item has title " + title + " is: " + this.itemsOrdered.get(i).toString());
			}
		}
		if (count == 0) {
			System.out.println("no match is found.");
		}
	}

	// method getALuckyItem()
	public Media getALuckyItem() {
		double i;

		if (this.itemsOrdered.size() >= 5) {
			i = Math.random();
			return this.itemsOrdered.get((int) i);

		}
		return null;
	}

	public void sortCartByCost() {
		System.out.println("sort by cost: ");
		this.itemsOrdered.sort(Media.COMPARE_BY_TITLE_COST);
		for (Media media : this.itemsOrdered) {
			System.out.println(media.toString());
		}
	}

	public void sortCartByTitle() {
		System.out.println("sort by title: ");
		this.itemsOrdered.sort(Media.COMPARE_BY_TITLE_COST);

		for (Media media : this.itemsOrdered) {
			System.out.println(media.toString());
		}
	}

	public void print() {
		this.itemsOrdered.sort(Media.COMPARE_BY_TITLE_COST);
		System.out.println("***********************CART***********************");
		for (Media media : this.itemsOrdered) {
			System.out.println(media.toString());
		}
		System.out.println("***************************************************");
	}

	public void DisplayByTitle() {
		this.itemsOrdered.sort(Media.COMPARE_BY_TITLE_COST);
		System.out.println("***********************CART***********************");
		for (Media media : this.itemsOrdered) {
			System.out.println(media.toString());
		}
		System.out.println("***************************************************");
	}

	public void DisplayByCost() {
		this.itemsOrdered.sort(Media.COMPARE_BY_COST_TITLE);

		System.out.println("***********************CART***********************");
		for (Media media : this.itemsOrdered) {
			System.out.println(media.toString());
		}
		System.out.println("***************************************************");
	}

	public DigitalVideoDisc[] emptyCart() {
		DigitalVideoDisc empty[] = new DigitalVideoDisc[MAX_NUMBERS_ORDERED];
		return empty;
	}

	public int getQtyOrdered() {
		return this.itemsOrdered.size();
	}

	public Media removeByTitle(String title3) {
		for (int i = 0; i < this.itemsOrdered.size(); i++) {
			if (this.itemsOrdered.get(i).getTitle().compareToIgnoreCase(title3) == 0) {
				return this.itemsOrdered.get(i);
			}
		}
		return null;
	}

	@Override
	public String toString() {
		if (this.itemsOrdered.size() == 0) {
			return "There is no media in the cart";
		} else {
			StringBuilder info = new StringBuilder("");
			for (Media media : this.itemsOrdered) {
				info.append(media.toString());
				info.append("----------------------\n");
			}
			return info.toString();
		}
	}

}