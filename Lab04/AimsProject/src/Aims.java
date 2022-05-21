public class Aims {
    public static void main(String[] args){
        Cart anOrder = new Cart();

        DigitalVideoDisc dvd1 = new DigitalVideoDisc(
            "The Lion King", "Animation", "Roger Aller", 87, 19.95f);
        anOrder.addDigitalVideoDisc(dvd1);
        
        DigitalVideoDisc dvd2 = new DigitalVideoDisc(
            "Star Wars", "Science Fiction", "George Lucas", 87, 24.95f);
        anOrder.addDigitalVideoDisc(dvd2);

        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin", "Animation", 18.99f);
        anOrder.addDigitalVideoDisc(dvd3);

        System.out.println("Total cost is :");
        System.out.println(anOrder.totalCost());
        
        System.out.println("id :" + dvd1.getId());
        System.out.println("id :" + dvd2.getId());
        
        System.out.println("Date :" + dvd1.getDate());
        System.out.println("Date :" + dvd2.getDate());

        
        }

    }
