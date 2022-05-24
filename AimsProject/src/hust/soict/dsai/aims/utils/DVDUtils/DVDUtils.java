package hust.soict.dsai.aims.utils.DVDUtils;
import java.lang.Float;

import hust.soict.dsai.aims.disc.DigitalVideoDisc.DigitalVideoDisc;

public class DVDUtils {
	public static int compareByCost(DigitalVideoDisc dvd1, DigitalVideoDisc dvd2) {
		return Float.compare(dvd1.getCost(), dvd2.getCost());
		// return -1 if cost of dvd1 < cost of dvd2, 0 if equal, else 1
	}

	public static int compareByTitle(DigitalVideoDisc dvd1, DigitalVideoDisc dvd2) {
		return dvd1.getTitle().compareToIgnoreCase(dvd2.getTitle());
	}
	// 0 if the string is equal to the other string, ignoring case differences.
	// < 0 if the string is lexicographically less than the other string
	// > 0 if the string is lexicographically greater than the other string

	public static DigitalVideoDisc[] sortByCost(DigitalVideoDisc[] listDVD) {
		DigitalVideoDisc temp = listDVD[0];
		for (int i = 0; i < listDVD.length-1; i++) {
			for (int j = i + 1; j < listDVD.length; j++) {
				if (compareByCost(listDVD[i], listDVD[j]) == 1) {
					temp = listDVD[i];
					listDVD[i] = listDVD[j];
					listDVD[j] = temp;	
				}

			}
		}
		return listDVD;
	}
	public static DigitalVideoDisc[] sortByTitle(DigitalVideoDisc[] listDVD) {
		DigitalVideoDisc temp = listDVD[0];
		for (int i = 0; i < listDVD.length-1; i++) {
			for (int j = i + 1; j < listDVD.length; j++) {
				if (compareByTitle(listDVD[i], listDVD[j]) > 0) {
					temp = listDVD[i];
					listDVD[i] = listDVD[j];
					listDVD[j] = temp;	
				}

			}
		}
		return listDVD;
	}
}
