public class Cart {
    public static final int MAX_NUMBERS_ORDERED = 20;
	private DigitalVideoDisc itemsOrdered[] = 
			new DigitalVideoDisc[MAX_NUMBERS_ORDERED];
	private int qtyOrdered;
    public void addDigitalVideoDisc(DigitalVideoDisc disc){
        if (qtyOrdered  == MAX_NUMBERS_ORDERED) {
            System.out.println("The cart is almost full");	
        }
        else{
            itemsOrdered[qtyOrdered] = disc;
            qtyOrdered++;
            System.out.println("The disc has been added");
        }
    } 
    public void removeDigitalVideoDisc(DigitalVideoDisc disc){
        int total = 0;
        DigitalVideoDisc[] Orders_Left = new DigitalVideoDisc[MAX_NUMBERS_ORDERED];
        for( int i = 0; i < qtyOrdered; i++){
            if (itemsOrdered[i].getTitle() != disc.getTitle()){
                Orders_Left[total] = disc;
                total ++;
                     
            }
            else{
                System.out.println("The disc " + itemsOrdered[i].getTitle() + " has been erased" );
                qtyOrdered -= 1;
            }
            System.arraycopy(Orders_Left, 0, itemsOrdered, 0, qtyOrdered);
            System.out.println("number of discs remaining : " + qtyOrdered);
        }
    }
    public float totalCost(){
        float totalCost = 0;
        for(int i = 0; i < qtyOrdered; i++){
            totalCost += itemsOrdered[i].getCost();
        }
        return totalCost;
    }
    public void addDigitalVideoDisc(DigitalVideoDisc [] dvdList){
        int first_qtyOrderd = qtyOrdered;
        if (qtyOrdered  == MAX_NUMBERS_ORDERED) {
            System.out.println("The cart is almost full");	
        }
        else if( first_qtyOrderd + dvdList.length <= MAX_NUMBERS_ORDERED){
            for(int i = first_qtyOrderd; i < first_qtyOrderd + dvdList.length; i++){
                itemsOrdered[i] = dvdList[i - first_qtyOrderd];
                qtyOrdered ++;
            }
        }
        else{
            for(int i = qtyOrdered; i < MAX_NUMBERS_ORDERED; i++){
                itemsOrdered[i] = dvdList[i - qtyOrdered];
            }
        qtyOrdered = MAX_NUMBERS_ORDERED;    
        }

    }
    public void addDigitalVideoDisc(DigitalVideoDisc dvd1,DigitalVideoDisc dvd2){
        int first_qtyOrderd = qtyOrdered;
        if (qtyOrdered  == MAX_NUMBERS_ORDERED) {
            System.out.println("The cart is almost full");	
        }
        else if( first_qtyOrderd + 2 <= MAX_NUMBERS_ORDERED){
          itemsOrdered[first_qtyOrderd] = dvd1;
          itemsOrdered[first_qtyOrderd + 1] = dvd2;
          qtyOrdered += 2;
        }
        else{
            itemsOrdered[qtyOrdered] = dvd1;
            qtyOrdered = MAX_NUMBERS_ORDERED;    
        }
    }
}
 