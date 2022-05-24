package hust.soict.dsai.test.utils.DVDTest;
import hust.soict.dsai.aims.disc.DigitalVideoDisc.DigitalVideoDisc;
import hust.soict.dsai.aims.utils.DVDUtils.DVDUtils;

public class DVDTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DigitalVideoDisc dvd1 = new DigitalVideoDisc("AAAAA", "aaaaa", "aaaaa", 1, 5.6f);
		DigitalVideoDisc dvd2 = new DigitalVideoDisc("BBBBB", "bbbbb", "bbbbb", 2, 5.3f);
		DigitalVideoDisc dvd3 = new DigitalVideoDisc("CCCCC", "ccccc", "ccccc", 3, 5f);
		DigitalVideoDisc dvd4 = new DigitalVideoDisc("DDDDD", "ddddd", "ddddd", 4, 7.1f);
		DigitalVideoDisc dvd5 = new DigitalVideoDisc("EEEEE", "eeeee", "eeeee", 5, 3.3f);
		
		System.out.println(DVDUtils.compareByCost(dvd1, dvd2));
		System.out.println(DVDUtils.compareByTitle(dvd5, dvd3));
		

		DigitalVideoDisc[] sorted = DVDUtils.sortByCost(new DigitalVideoDisc[] {dvd1, dvd2, dvd3,dvd4,dvd5});
		System.out.println("sort by cost: ");

		for ( int i = 0; i < sorted.length ; i++) {
			System.out.println(sorted[i].toString());
		}
		sorted = DVDUtils.sortByTitle(new DigitalVideoDisc[] {dvd1, dvd2, dvd3,dvd4,dvd5});
		System.out.println("sort by cost: ");
		for ( int i = 0; i < sorted.length; i++) {
			System.out.println(sorted[i].toString());
		}
	}

}
