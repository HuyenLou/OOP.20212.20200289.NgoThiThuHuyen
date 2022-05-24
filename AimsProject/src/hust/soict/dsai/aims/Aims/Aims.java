package hust.soict.dsai.aims.Aims;

import hust.soict.dsai.aims.cart.Cart.Cart;
import hust.soict.dsai.aims.disc.DigitalVideoDisc.DigitalVideoDisc;
import hust.soict.dsai.aims.store.Store.Store;

import java.util.Scanner;

public class Aims {
	static Scanner sc = new Scanner(System.in);
		   
	public static void showMenu() {
		System.out.println("/nAIMS: ");
		System.out.println("--------------------------------");
		System.out.println("1. View store");
		System.out.println("2. Update store");
		System.out.println("3. See current cart");
		System.out.println("0. Exit");
		System.out.println("--------------------------------");
		System.out.println("Please choose a number: 0-1-2-3");
	}

	public static void storeMenu() {
		System.out.println("/nOptions: ");
		System.out.println("--------------------------------");
		System.out.println("1. See a DVD’s details");
		System.out.println("2. Add a DVD to cart");
		System.out.println("3. See current cart");
		System.out.println("0. Back");
		System.out.println("--------------------------------");
		System.out.println("Please choose a number: 0-1-2-3");
	}

	public static void cartMenu() {
		System.out.println("/nOptions: ");
		System.out.println("--------------------------------");
		System.out.println("1. Filter DVDs in cart");
		System.out.println("2. Sort DVDs in cart");
		System.out.println("3. Remove DVD from cart");
		System.out.println("4. Place order");
		System.out.println("0. Back");
		System.out.println("--------------------------------");
		System.out.println("Please choose a number: 0-1-2-3-4");
	}

	public static void main(String[] args) {
		Cart anOrder = new Cart();

		DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Aller", 87, 19.95f);
		anOrder.addDigitalVideoDisc(dvd1);

		DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 87, 24.95f);
		anOrder.addDigitalVideoDisc(dvd2);

		DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin", "Animation", 18.99f);
		anOrder.addDigitalVideoDisc(dvd3);

		System.out.println("Total cost is :");
		System.out.println(anOrder.totalCost());

		System.out.println("id :" + dvd1.getId());
		System.out.println("id :" + dvd2.getId());

		System.out.println("Date :" + dvd1.getDate());
		System.out.println("Date :" + dvd2.getDate());

		anOrder.removeDigitalVideoDisc(dvd3);

		Store store = new Store();

		DigitalVideoDisc d1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Aller", 87, 19.95f);
		store.addDVD(d1);

		DigitalVideoDisc d2 = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 87, 24.95f);
		store.addDVD(dvd2);

		DigitalVideoDisc d3 = new DigitalVideoDisc("Aladin", "Animation", 18.99f);
		store.addDVD(d3);

		int a, b, c, d, e, f, id;

		Cart currentCart = new Cart();

		boolean flag = true;

		do {
			showMenu();
			a = sc.nextInt();
			switch (a) {
			case 1:
				storeMenu();
				b = sc.nextInt();
				switch (b) {
				case 1:
					System.out.println("please enter the title: ");
					String title = sc.next();
					DigitalVideoDisc findDVD = store.searchByTitle(title);

					System.out.println(findDVD.toString());

					break;
				case 2:
					System.out.println("list DVDs in store: ");
					store.DisplayStore();
					System.out.println("please enter the title of DVD you choose: ");
					String title2 = sc.next();
					DigitalVideoDisc findDVD2 = store.searchByTitle(title2);
					currentCart.addDigitalVideoDisc(findDVD2);
					System.out.println("The number of DVDs in the current cart: ");
					currentCart.getQtyOrdered();
					break;

				case 3:
					cartMenu();
					c = sc.nextInt();
					switch (c) {
					case 1:
						System.out.println("/n Options: /n 1.Filter by id /n 2.Filter by id");
						System.out.println("Please choose a number: 1-2 ");
						d = sc.nextInt();
						switch (d) {
						case 1:
							System.out.println("please enter the ID of DVD you want to filter: ");
							id = sc.nextInt();
							currentCart.searchByID(id);
							break;
						case 2:
							System.out.println("please enter the title of DVD you want to filter: ");
							title = sc.next();
							currentCart.searchByTitle(title);
							break;
						}
					case 2:
						System.out.println("/n Options: /n 1.Sort by title /n 2.Sort by cost");
						System.out.println("Please choose a number: 1-2 ");
						e = sc.nextInt();
						switch (e) {
						case 1:
							currentCart.DisplayByTitle();
							break;
						case 2:
							currentCart.DisplayByCost();
							break;
						}
					case 3:
						System.out.println("please enter the title of DVD you want to remove(from 0): ");
						String title3  = sc.next();
						DigitalVideoDisc findDVD3 = currentCart.removeByTitle(title3);
						currentCart.removeDigitalVideoDisc(findDVD3);	
						break;
					case 4:
						System.out.println("an order is created");
						currentCart.emptyCart();
						break;
					case 0:
						break;
					}
					break;
				case 0:
					break;
				}
			case 2:
				System.out.println("/n Options: /n 1.add a DVD from the store /n 2.remove a DVD from the store");
				System.out.println("Please choose a number: 1-2 ");
				f = sc.nextInt();
				switch(f) {
				case 1:
					DigitalVideoDisc dvd = null;
					System.out.println("enter the title of DVD");
					dvd.setTitle(sc.next());
					System.out.println("enter the category of DVD");
					dvd.setCategory(sc.next());
					System.out.println("enter the director of DVD");
					dvd.setDirector(sc.next());
					System.out.println("enter the length of DVD");
					dvd.setLength(sc.nextInt());
					System.out.println("enter the cost of DVD");
					dvd.setCost(sc.nextFloat());
					
					store.addDVD(dvd);
				case 2:
					System.out.println("please enter the title of DVD you want to remove from cart: ");
					String title = sc.next();
					DigitalVideoDisc dvdFound = store.searchByTitle(title);
					store.removeDVD(dvdFound);
					break;
				}
			case 3:	
				cartMenu();
				c = sc.nextInt();
				switch (c) {
				case 1:
					System.out.println("/n Options: /n 1.Filter by id /n 2.Filter by id");
					System.out.println("Please choose a number: 1-2 ");
					d = sc.nextInt();
					switch (d) {
					case 1:
						System.out.println("please enter the ID of DVD you want to filter: ");
						id = sc.nextInt();
						currentCart.searchByID(id);
						break;
					case 2:
						System.out.println("please enter the title of DVD you want to filter: ");
						String title = sc.next();
						currentCart.searchByTitle(title);
						break;
					}
				case 2:
					System.out.println("/n Options: /n 1.Sort by title /n 2.Sort by cost");
					System.out.println("Please choose a number: 1-2 ");
					e = sc.nextInt();
					switch (e) {
					case 1:
						currentCart.DisplayByTitle();
						break;
					case 2:
						currentCart.DisplayByCost();
						break;
					}
				case 3:
					System.out.println("please enter the title of DVD you want to remove(from 0): ");
					String title3  = sc.next();
					DigitalVideoDisc findDVD3 = currentCart.removeByTitle(title3);
					currentCart.removeDigitalVideoDisc(findDVD3);	
					break;
				case 4:
					System.out.println("an order is created");
					currentCart.emptyCart();
					break;
				case 0:
					break;
				}
				break;
			case 0:
				System.out.println("Goodbye");
                flag = false;
                break;
			}	
		} while (flag);

	}

}
