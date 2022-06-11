package hust.soict.dsai.aims.media;

import java.util.ArrayList;
import java.util.List;

public class CompactDisc extends Disc implements Playable {
	
	
	private static int nCompactDiscs = 0;
	private static int count = 0;
	private String artist;
	private List<Track> tracks = new ArrayList<Track>();


    public CompactDisc() {
        super();
        nCompactDiscs++;
        count++;
        this.setId(count);
    }

    public CompactDisc(String title) {
        super(title);
        nCompactDiscs++;
        count++;
        this.setId(count);
    }

    public CompactDisc(String title, float cost) {
        super(title, cost);
        nCompactDiscs++;
        count++;
        this.setId(count);
    }

    public CompactDisc(String title, String category, String director, int length, float cost) {
        super(title, category, director, length, cost);
        nCompactDiscs++;
        count++;
        this.setId(count);
    }

    public CompactDisc(String title, String category, String director, int length, float cost, String artist, List<Track> tracks) {
        super(title, category, director, length, cost);
        this.artist = artist;
        this.tracks = tracks;
        nCompactDiscs++;
        count++;
        this.setId(count);
    }

    public String getArtist() {
        return artist;
    }
    
    public void addTrack(Track track) {
        if (this.tracks.contains(track) == false) {
            this.tracks.add(track);
            System.out.println("A track has been added");
        } else {
            System.out.println("The track has already been in the CD");
        }
    }

    public void addTrack(Track track, Track... trackList) {
        this.addTrack(track);
        for (Track track_ : trackList) {
            this.addTrack(track_);
        }
    }

    public void removeTrack(Track track) {
        if (this.tracks.contains(track) == true) {
            this.tracks.remove(track);
            System.out.println("A track has been removed");
        }
        else {
        	System.out.println("This track is not exist in the CD");
        }
    }


    public int getLength() {
        if (this.tracks.size() == 0) {
            return 0;
        }
        int length = 0;
        for (Track track : this.tracks) {
            length += track.getLength();
        }
        return length;
    }
    
    @Override
    public void play() {
        if (this.tracks.size() == 0) {
            System.out.println("there is no song in the CD");
        } else {
            for (Track track : this.tracks) {
                track.play();
            }
        }
    }



	

}
