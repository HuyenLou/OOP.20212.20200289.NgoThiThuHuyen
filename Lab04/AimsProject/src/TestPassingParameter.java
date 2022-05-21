
public class TestPassingParameter {

	private static DigitalVideoDisc cinderellaDVD;
	private static DigitalVideoDisc jungleDVD;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DigitalVideoDisc jungleDVD = new DigitalVideoDisc("jungle");
		DigitalVideoDisc cinderellaDVD = new DigitalVideoDisc("cinderella");

		swap(jungleDVD, cinderellaDVD);
		System.out.println("jungle DVD title: " + jungleDVD.getTitle());
		System.out.println("cinderella DVD title: " + cinderellaDVD.getTitle());

		changeTitle(jungleDVD, cinderellaDVD.getTitle());
		System.out.println("jungle DVD title: " + jungleDVD.getTitle());
	}

	public static void swap(Object o1, Object o2) {
		Object tmp = o1;
		o1 = o2;
		o2 = tmp;
	}

	public static void swap3(DigitalVideoDisc d1, DigitalVideoDisc d2) {
		String tmp = d1.getTitle();
		String tmp2 = d2.getTitle();
		d2.setTitle(tmp);
		d1.setTitle(tmp2);

	}

	public static void changeTitle(DigitalVideoDisc dvd, String title) {
		String oldTitle = dvd.getTitle();
		dvd.setTitle(title);
		dvd = new DigitalVideoDisc(oldTitle);
	}

}
