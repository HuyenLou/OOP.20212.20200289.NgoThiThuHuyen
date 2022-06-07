package hust.soict.dsai.aims.Aims;

import hust.soict.dsai.aims.cart.Cart.Cart;
import hust.soict.dsai.aims.media.Media;

import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.store.Store.Store;

import java.util.Scanner;

public class Aims {
	static Scanner sc = new Scanner(System.in);

	public static void showMenu() {
		System.out.println("\nAIMS: ");
		System.out.println("--------------------------------");
		System.out.println("1. View store");
		System.out.println("2. Update store");
		System.out.println("3. See current cart");
		System.out.println("0. Exit");
		System.out.println("--------------------------------");
		System.out.println("Please choose a number: 0-1-2-3");
	}

	public static void storeMenu() {
		System.out.println("\nOptions: ");
		System.out.println("--------------------------------");
		System.out.println("1. See a DVD’s details");
		System.out.println("2. Add a DVD to cart");
		System.out.println("3. See current cart");
		System.out.println("0. Back");
		System.out.println("--------------------------------");
		System.out.println("Please choose a number: 0-1-2-3");
	}

	public static void cartMenu() {
		System.out.println("\nOptions: ");
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
		anOrder.addMedia(dvd1);

		DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 87, 24.95f);
		anOrder.addMedia(dvd2);

		DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin", "Animation", 18.99f);
		anOrder.addMedia(dvd3);

		System.out.println("Total cost is :");
		System.out.println(anOrder.totalCost());

		System.out.println("id :" + dvd1.getId());
		System.out.println("id :" + dvd2.getId());

		System.out.println("Date :" + dvd1.getDate());
		System.out.println("Date :" + dvd2.getDate());

		Store store = new Store();

		Media d1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Aller", 87, 19.95f);
		store.addMedia(d1);

		Media d2 = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 87, 24.95f);
		store.addMedia(d2);

		Media d3 = new DigitalVideoDisc("Aladin", "Animation", 18.99f);
		store.addMedia(d3);

		int a, b, c, d, e, f, id;

		Cart currentCart = new Cart();

		DigitalVideoDisc dvd4 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Aller", 87, 19.95f);
		currentCart.addMedia(dvd4);

		DigitalVideoDisc dvd5 = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 87, 24.95f);
		currentCart.addMedia(dvd5);

		DigitalVideoDisc dvd6 = new DigitalVideoDisc("Aladin", "Animation", 18.99f);
		currentCart.addMedia(dvd6);
		
		Media dvd8 = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 87, 24.95f);
		currentCart.addMedia(dvd8);

		Media dvd9 = new DigitalVideoDisc("Aladin", "Animation", 18.99f);
		currentCart.addMedia(dvd9);
		

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
					sc.nextLine();
					String title = sc.nextLine();
					Media findDVD = store.searchByTitle(title);

					System.out.println(findDVD.toString());

					break;
				case 2:
					System.out.println("list DVDs in store: ");
					store.DisplayStore();
					System.out.println("please enter the title of DVD you choose: ");
					sc.nextLine();
					String title2 = sc.nextLine();
					Media findDVD2 = store.searchByTitle(title2);
					currentCart.addMedia(findDVD2);
					System.out.println("The number of DVDs in the current cart: ");
					System.out.println(currentCart.getQtyOrdered());
					break;

				case 3:
					cartMenu();
					c = sc.nextInt();
					switch (c) {
					case 1:
						System.out.println("\n Options: \n 1.Filter by id \n 2.Filter by title");
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
							sc.nextLine();
							title = sc.nextLine();
							currentCart.searchByTitle(title);
							break;
						}
						break;
					case 2:
						System.out.println("\n Options: \n 1.Sort by title \n 2.Sort by cost");
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
						break;
					case 3:
						System.out.println("please enter the title of DVD you want to remove(from 0): ");
						sc.nextLine();
						String title3 = sc.nextLine();
						Media findDVD3 = currentCart.removeByTitle(title3);
						currentCart.removeMedia(findDVD3);
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
				break;
			case 2:
				System.out.println("\n Options: \n 1.add a DVD from the store \n 2.remove a DVD from the store");
				System.out.println("Please choose a number: 1-2 ");
				f = sc.nextInt();
				switch (f) {
				case 1:
					DigitalVideoDisc dvd = new DigitalVideoDisc(null, null, null, 0, 0.0f); ;
					System.out.println("enter the title of DVD");
					sc.nextLine();
					dvd.setTitle(sc.nextLine());
					System.out.println("enter the category of DVD");
					dvd.setCategory(sc.nextLine());
					System.out.println("enter the director of DVD");
					dvd.setDirector(sc.nextLine());
					System.out.println("enter the length of DVD");
					dvd.setLength(sc.nextInt());
					System.out.println("enter the cost of DVD");
					dvd.setCost(sc.nextFloat());

					store.addMedia(dvd);
					break;
				case 2:
					System.out.println("please enter the title of DVD you want to remove from store: ");
					sc.nextLine();
					String title = sc.nextLine();
					Media dvdFound = store.searchByTitle(title);
					store.removeMedia(dvdFound);
					break;
				}
				break;
			case 3:
				cartMenu();
				c = sc.nextInt();
				switch (c) {
				case 1:
					System.out.println("\n Options: \n 1.Filter by id \n 2.Filter by title");
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
						sc.nextLine();
						String title = sc.nextLine();
						currentCart.searchByTitle(title);
						break;
					}
					break;
				case 2:
					System.out.println("\n Options: \n 1.Sort by title \n 2.Sort by cost");
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
					break;
				case 3:
					System.out.println("please enter the title of DVD you want to remove(from 0): ");
					sc.nextLine();
					String title3 = sc.nextLine();
					Media findDVD3 = currentCart.removeByTitle(title3);
					currentCart.removeMedia(findDVD3);
					break;
				case 4:
					System.out.println("an order is created");
					if (currentCart.getQtyOrdered() >= 5) {
						System.out.println("your lucky item is : ");
						System.out.println(currentCart.getALuckyItem().toString());
					}
					
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
