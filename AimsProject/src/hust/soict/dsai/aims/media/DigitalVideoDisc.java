package hust.soict.dsai.aims.media;
import java.time.LocalDate;   


public class DigitalVideoDisc extends Media {
	private String director;
	private int length;
	private static int nbDigitalVideoDiscs = 0;
	private static int count = 0;
	private int id ;
	LocalDate dateAdded;
	public DigitalVideoDisc(String title) {
		super(title);
		nbDigitalVideoDiscs++;
		count ++;
		this.id = count;
		this.dateAdded = LocalDate.now();
	}
	
	
	public DigitalVideoDisc(String title, String category, float cost) {
		super(title, category, cost);
		nbDigitalVideoDiscs++;
		count ++;
		this.id = count;
		this.dateAdded = LocalDate.now();
	}

	public DigitalVideoDisc(String title, String category, String director, float cost) {
		super(title, category, cost);
		this.director = director;
		count ++;
		nbDigitalVideoDiscs++;
		this.id = count;
		this.dateAdded = LocalDate.now();
	}

    
	public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
		super(title, category, cost);
		this.director = director;
		this.length = length;
		count ++;
		nbDigitalVideoDiscs++;
		this.id = count;
		this.dateAdded = LocalDate.now();
		
	}
	 public String toString() {
		 return "DVD - " + super.getTitle() + " - " + super.getCategory() + " - " +director + " - " + length + " : " + super.getCost() + "$";
	 }
	 
	 


	public String getDirector() {
		return director;
	}
	public void setDirector(String director) {
		this.director = director;
	}
	public int getLength() {
		return length;
	}
	public void setLength(int length) {
		this.length = length;
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
    	String titleOfDisk = super.getTitle();
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
