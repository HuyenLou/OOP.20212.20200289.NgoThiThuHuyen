package hust.soict.dsai.aims.media;

public class Disc extends Media {
	private int length;
	private String director;
	private static int nDiscs = 0;

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	public Disc() {
		super();
		nDiscs++;
		this.setId(nDiscs);
	}

	public Disc(String title) {
		super(title);
		nDiscs++;
		this.setId(nDiscs);
	}

	public Disc(String title, float cost) {
		super(title, cost);
		nDiscs++;
		this.setId(nDiscs);
	}

	public Disc(String title, String category, float cost) {
		super(title, category, cost);
		nDiscs++;
		this.setId(nDiscs);
	}

	public Disc(String title, String category, String director, int length, float cost) {
		super(title, category, cost);
		this.length = length;
		this.director = director;
		nDiscs++;
		this.setId(nDiscs);
	}
}