package hust.soict.dsai.aims.media;

public class Track  {
	private final int id;
	private static int nTracks = 0;
	private String title;
	private int length;

	public Track() {
		nTracks++;
		this.id = nTracks;
	}

	public Track(String title) {
		this.title = title;
		nTracks++;
		this.id = nTracks;
	}

	public Track(int length) {
		this.length = length;
		nTracks++;
		this.id = nTracks;
	}

	public Track(String title, int length) {
		this.title = title;
		this.length = length;
		nTracks++;
		this.id = nTracks;
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
}