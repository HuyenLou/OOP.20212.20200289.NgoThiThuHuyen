package hust.soict.dsai.aims.media;

import java.util.Comparator;

public class Media implements Comparable<Media> {
	private int id;
	private String title;
	private String category;
	private float cost;		
	public static final Comparator<Media> COMPARE_BY_TITLE_COST = new MediaComparatorByTitleCost();
    public static final Comparator<Media> COMPARE_BY_COST_TITLE = new MediaComparatorByCostTitle();
    
	public Media() {
		// TODO Auto-generated constructor stub
	}
    public Media(String title) {
        this.title = title;
    }

    public Media(String title, float cost) {
        this.title = title;
        this.cost = cost;
    }

    public Media(String title, String category, float cost) {
        this.title = title;
        this.category = category;
        this.cost = cost;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public float getCost() {
        return cost;
    }

    public void setCost(float cost) {
        this.cost = cost;
    }
    
    public boolean equals(Object obj){
        if(obj == this){
            return true;
        }
        if (!(obj instanceof Media)){
            return false;
        }
        Media media;
        media = (Media) obj;
        return this.title.equals(media.getTitle());
    }
  
    	
  
    

    @Override
    public String toString (){
        System.out.println("-----------------------------");
        StringBuilder info = new StringBuilder("");
        if (this.getTitle() != null) {
            info.append("Title: ").append(this.getTitle()).append("\n");
        }
        if (this.getCategory() != null) {
            info.append("Category: ").append(this.getCategory()).append("\n");
        }
        if (this.getCost() != 0) {
            info.append("Cost: ").append(this.getCost()).append("$").append("\n");
        }
        return info.toString();
    }
	@Override
	public int compareTo(Media o) {
		  if(this.getTitle().compareToIgnoreCase(o.getTitle()) > 0) {
			   return 1;
		   }
		   else if (this.getTitle().compareToIgnoreCase(o.getTitle()) == 0) {
			   if(this.getCategory().compareToIgnoreCase(o.getCategory()) >0){
				   return 1;  
			   }
			   else {
				   return -1;
			   }
		   }
		   return -1;
	}
    
	

}
