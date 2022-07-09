package hust.soict.dsai.aims.screen.manager;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JFrame;

import hust.soict.dsai.aims.exception.PlayerException;
import hust.soict.dsai.aims.media.Book;
import hust.soict.dsai.aims.media.CompactDisc;
import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.store.Store.Store;

public class StoreManagerScreen extends JFrame {
	
    private Store store;
    public Store getStore() {
        return store;
    }

    public void setStore(Store store) {
        this.store = store;
    } 
    
    JPanel createNorth() {
    	 JPanel north = new JPanel();
    	 north.setLayout(new BoxLayout(north, BoxLayout.Y_AXIS));
    	 north.add(createMenuBar());
    	 north.add(createHeader());
    	 return north;
    }
    
    JMenuBar createMenuBar() {
    	JMenu menu = new JMenu("Options");
    	
    	menu.add(new JMenuItem("View store"));

    	
    	JMenu smUpdateStore = new JMenu("Update store");
    	JMenuItem addBook = new JMenuItem("Add Book");
        addBook.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                AddBookToStoreScreen addBookScreen = new AddBookToStoreScreen(store);
                addBookScreen.setVisible(true);
            }
        });
        smUpdateStore.add(addBook);
    	
        JMenuItem addCD = new JMenuItem("Add CD");
        addCD.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                AddCompactDiscToStore addCDScreen = new AddCompactDiscToStore(store);
                addCDScreen.setVisible(true);
            }
        });
        smUpdateStore.add(addCD);
        
        JMenuItem addDVD = new JMenuItem("Add DVD");
        addDVD.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                AddDigitalVideoDiscToStore addDVDScreen = new AddDigitalVideoDiscToStore(store);
                addDVDScreen.setVisible(true);
            }
        });
        smUpdateStore.add(addDVD);
        
    	menu.add(smUpdateStore);
    	
    	JMenuBar menuBar = new JMenuBar();
    	menuBar.setLayout(new FlowLayout(FlowLayout.LEFT));
    	menuBar.add(menu);
    	
    	
    	
    	return menuBar;
    }
    
    JPanel createHeader() {
    	JPanel header = new JPanel();
    	header.setLayout(new BoxLayout(header, BoxLayout.X_AXIS));
    	
    	JLabel title = new JLabel("AIMS");
    	title.setFont(new Font(title.getFont().getName(), Font.PLAIN, 50));
    	title.setForeground(Color.CYAN);
    	
    	header.add(Box.createRigidArea(new Dimension(10,10)));
    	header.add(title);
    	header.add(title);
    	header.add(Box.createHorizontalGlue());
    	header.add(Box.createRigidArea(new Dimension(10, 10)));
    	
    	return header;
    }
    
    JPanel createCenter() throws PlayerException {
    	
    	JPanel center = new JPanel();
    	center.setLayout(new GridLayout(3, 3, 2, 2));
    	
    	ArrayList<Media> mediaInStore = store.getItemsInStore();
    	for(int i=0; i<mediaInStore.size(); i++) {
    		MediaStore cell = new MediaStore(mediaInStore.get(i));
    		center.add(cell);
    	}
    	
    	return center;
    	
    }
    public StoreManagerScreen(Store store) throws PlayerException {
    	this.store = store;
    	
    	Container cp = getContentPane();
    	cp.setLayout(new BorderLayout());
    	cp.add(createNorth(), BorderLayout.NORTH);
    	cp.add(createCenter(), BorderLayout.CENTER);
    	
    	setTitle("Store");
    	setSize(1024, 768);
    	setLocationRelativeTo(null);
    	setVisible(true);
    }
    

    public static void main(String[] args) throws PlayerException {
    	Store store = new Store();

    	CompactDisc cd = new CompactDisc("Star Wars", "Science Fiction", "George Lucas", "thm", 24.95f);
 		store.addMedia(cd);

 		DigitalVideoDisc dvd = new DigitalVideoDisc("The Lion King", "Animation", "Roger Aller", 87, 19.95f);
        store.addMedia(dvd);
		



		
    	new StoreManagerScreen(store);
    }
    
}
