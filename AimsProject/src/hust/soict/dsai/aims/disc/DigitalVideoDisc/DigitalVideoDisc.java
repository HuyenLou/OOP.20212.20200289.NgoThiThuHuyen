package hust.soict.dsai.aims.disc.DigitalVideoDisc;
import java.time.LocalDate;   

public class DigitalVideoDisc {
	private String title;
	private String category;
	private String director;
	private int length;
	private float cost;
	private static int nbDigitalVideoDiscs = 0;
	private static int count = 0;
	private int id ;
	LocalDate dateAdded;
	public DigitalVideoDisc(String title) {
		super();
		this.title = title;
		count ++;
		this.id = count;
		this.dateAdded = LocalDate.now();
	}
	
	
	public DigitalVideoDisc(String title, String category, float cost) {
		super();
		this.title = title;
		this.category = category;
		this.cost = cost;
		count ++;
		this.id = count;
		this.dateAdded = LocalDate.now();
	}

	public DigitalVideoDisc(String title, String category, String director, float cost) {
		super();
		this.title = title;
		this.category = category;
		this.director = director;
		this.cost = cost;
		count ++;
		this.id = count;
		this.dateAdded = LocalDate.now();
	}

    
	public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
		super();
		this.title = title;
		this.category = category;
		this.director = director;
		this.length = length;
		this.cost = cost;
		count ++;
		this.id = count;
		this.dateAdded = LocalDate.now();
		
	}
	 public String toString() {
		 return "DVD - " + title + " - " + category + " - " +director + " - " + length + " : " + cost + "$";
	 }


	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDirector() {
		return director;
	}
	public void setDirector(String director) {
		this.director = director;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public int getLength() {
		return length;
	}
	public void setLength(int length) {
		this.length = length;
	}
	public float getCost() {
		return cost;
	}
	public void setCost(float cost) {
		this.cost = cost;
	}
	public int getId() {
		return id;
	}

	public LocalDate getDate() {
		return dateAdded;
	}

    public boolean isMatch(String title) {
    	int match = 0;
    	title = title.toLowerCase();
    	String[] tokens = title.split(" ");
    	String titleOfDisk = this.title;
    	titleOfDisk = titleOfDisk.toLowerCase();
    	for(int i = 0; i < tokens.length; i++) {
    		if(titleOfDisk.contains(tokens[i]) == true) {
    			match++;
    		}
    	}
    	if(match == 0) {
    		return false;
    		
    	}
		return true;
    	
    }
}
