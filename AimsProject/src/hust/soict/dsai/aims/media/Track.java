package hust.soict.dsai.aims.media;

public class Track implements Playable, Comparable<Track>{
	private final int id;
	private static int nTracks = 0;
	private static int count = 0;
	private String title;
	private int length;

	public Track() {
		setnTracks(getnTracks() + 1);
		count++;
		this.id = count++;
	}

	public Track(String title) {
		this.title = title;
		setnTracks(getnTracks() + 1);
		count++;
		this.id = count;
	}

	public Track(int length) {
		this.length = length;
		setnTracks(getnTracks() + 1);
		count++;
		this.id = count;
	}

	public Track(String title, int length) {
		this.title = title;
		this.length = length;
		setnTracks(getnTracks() + 1);
		count++;
		this.id = count;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}
	
	    public boolean equals(Object obj) {
	        if (obj == this) {
	            return true;
	        }
	        if (!(obj instanceof Track)) {
	            return false;
	        }
	        Track track;
	        track = (Track) obj;
	        return (this.title.equals(track.getTitle())) && this.length == track.getLength();
	    }

	
    
	@Override
    public void play() {
        if (this.getLength() > 0) {
        	System.out.println("Playing Track: " + this.getTitle());
            System.out.println("Track length: " + this.getLength());
        } else {
        	System.out.println("This track has some problems");
        }
    }

	@Override
	public int compareTo(Track o) {
		if(this.getTitle().compareToIgnoreCase(o.getTitle()) > 0) {
			   return 1;
		   }
		return -1;
	}

	 @Override
	    public String toString() {
	        return "Title:  " + this.getTitle() + " | " + "Length: " + this.getLength() + "s";
	    }
	public int getId() {
		return id;
	}

	public static int getnTracks() {
		return nTracks;
	}

	public static void setnTracks(int nTracks) {
		Track.nTracks = nTracks;
	}
	
	

}