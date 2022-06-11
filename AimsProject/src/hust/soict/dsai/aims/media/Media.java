package hust.soict.dsai.aims.media;

public class Media {
	private int id;
	private String title;
	private String category;
	private float cost;			
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
    
    public boolean equals(Object o) {
    	  if (o == this) {
              return true;
          }
          if (!(o instanceof Media)) {
              return false;
          }
          
          Media c = (Media) o;
          
          // Compare the data members and return accordingly
          return Double.compare(id, c.id) == 0;
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
    
	

}
