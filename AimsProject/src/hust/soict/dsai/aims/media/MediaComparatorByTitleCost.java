package hust.soict.dsai.aims.media;

import java.util.Comparator;

public class MediaComparatorByTitleCost implements Comparator<Media> {
    public int compare(Media media1, Media media2) {
        String title1 = media1.getTitle();
        String title2 = media2.getTitle();
        float cost1 = media1.getCost();
        float cost2 = media2.getCost();
        if (title1.equals(title2)) {
            return (int) (cost1 - cost2);
        } else {
            return title1.compareToIgnoreCase(title2);
        }
    }
}