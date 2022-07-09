package hust.soict.dsai.aims.media;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.naming.LimitExceededException;

import hust.soict.dsai.aims.exception.PlayerException;

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


	public CompactDisc(String title, float cost) {
		super(title, cost);
		nCompactDiscs++;
		count++;
		this.setId(count);
	}

	public CompactDisc(String title, String category, String director, String artist, float cost) throws NumberFormatException, NullPointerException {
		super(title, category, director, cost);
		this.artist = artist;
		nCompactDiscs++;
		count++;
		this.setId(count);
		if(artist==null|| artist.isBlank())
			throw new NullPointerException("Artist field is empty!");
	}

	public CompactDisc(String title, String category, String director, int length, float cost, String artist,
			List<Track> tracks) {
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

	public void addTrack(Track track) throws Exception  {
		if (this.tracks.contains(track) == false) {
			this.tracks.add(track);
			System.out.println("A track has been added");
		} else {
			throw new Exception("ERROR: The track has already been in the CD");
		}
	}

	public void addTrack(Track track, Track... trackList) throws Exception  {
		this.addTrack(track);
		for (Track track_ : trackList) {
			this.addTrack(track_);
		}
	}

	public void removeTrack(Track track) {
		if (this.tracks.contains(track) == true) {
			this.tracks.remove(track);
			System.out.println("A track has been removed");
		} else {
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
	public void play() throws PlayerException {
		if (getLength() > 0) {
			Iterator<Track> iter = tracks.iterator();
			Track nextTrack;
			while (iter.hasNext()) {
				nextTrack = (Track) iter.next();
				nextTrack.play();
			}
		} else {
			throw new PlayerException("ERROR: The CD length is non-positive!");

		}
	}

	

	@Override
	public String toString() {
		StringBuilder info = new StringBuilder(super.toString());
		if (this.artist != null) {
			info.append("Artist:  ").append(this.getArtist()).append("\n");
		}
		if (this.getLength() != 0) {
			info.append("Length:  ").append(this.getLength()).append("\n");
		}
		if (this.tracks.size() != 0) {
			info.append("Tracks:  " + "\n");
			for (Track track : this.tracks) {
				info.append("Track: ").append(track.toString()).append("\n");
			}
		}

		return info.toString();
	}

}
