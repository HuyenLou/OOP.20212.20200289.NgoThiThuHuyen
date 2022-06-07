package hust.soict.dsai.aims.media;

public class Track implements Playable  {
	private final int id;
	private static int nTracks = 0;
	private static int count = 0;
	private String title;
	private int length;

	public Track() {
		nTracks++;
		count++;
		this.id = count++;
	}

	public Track(String title) {
		this.title = title;
		nTracks++;
		count++;
		this.id = count;
	}

	public Track(int length) {
		this.length = length;
		nTracks++;
		count++;
		this.id = count;
	}

	public Track(String title, int length) {
		this.title = title;
		this.length = length;
		nTracks++;
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
	
	 public String toString() {
	        return "Title: " + this.getTitle() + " - " + "Length: " + this.getLength();
	    }
	
    // Override method play()
    public void play() {
        if (this.getLength() > 0) {
        	System.out.println("Playing Track: " + this.getTitle());
            System.out.println("Track length: " + this.getLength());
        } else {
        	System.out.println("This track has some problems");
        }
    }

}