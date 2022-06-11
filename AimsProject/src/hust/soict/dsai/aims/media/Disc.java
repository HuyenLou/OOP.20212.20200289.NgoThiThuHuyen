package hust.soict.dsai.aims.media;

public class Disc extends Media {
	private int length;
	private String director;
	private static int nDiscs = 0;
    private static int count = 0;
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
		count++;
		this.setId(count);
	}

	public Disc(String title) {
		super(title);
		nDiscs++;
		count++;
		this.setId(count);
	}

	public Disc(String title, float cost) {
		super(title, cost);
		nDiscs++;
		count++;
		this.setId(count);
	}

	public Disc(String title, String category, float cost) {
		super(title, category, cost);
		nDiscs++;
		count++;
		this.setId(count);
	}

	public Disc(String title, String category, String director, int length, float cost) {
		super(title, category, cost);
		this.length = length;
		this.director = director;
		nDiscs++;
		count++;
		this.setId(count);
	}
    @Override
    public String toString() {
        StringBuilder info = new StringBuilder(super.toString());
        if (this.getDirector() != null) {
            info.append("Director:  ").append(this.getDirector()).append("\n");
        }
        if (this.getLength() != 0) {
            info.append("Length:  ").append(this.getLength()).append("\n");
        }
        return info.toString();
    }
}