package hust.soict.dsai.aims.media;

import java.util.ArrayList;
import java.util.List;

public class Book extends Media {
	private int id;
	private static int nbBooks = 0;
	private List<String> authors = new ArrayList<String>();

	public Book() {
		// TODO Auto-generated constructor stub
	}

	public void addAuthor(String author) {
		if (this.authors.contains(author) == true) {
			System.out.println("This author has been already exist");
		} else {
			this.authors.add(author);
			System.out.println("This author has been added");
		}
	}

	public void addAuthor(String author, String... list_Author) {
		this.addAuthor(author);
		for (String author_ : list_Author) {
			this.addAuthor(author_);
		}
	}

	public void removeAuthor(String author) {
		if (!this.authors.contains(author)) {
			System.out.println("This author is not present");
		} else {
			this.authors.remove(author);
			System.out.println("This author has been removed");
		}
	}

	public void removeAuthor(String author, String... listAuthor) {
		this.removeAuthor(author);
		for (String author_ : listAuthor) {
			this.removeAuthor(author_);
		}
	}

	@Override
	public String toString() {
		StringBuilder info = new StringBuilder(super.toString());
		if (this.authors.size() != 0) {
			info.append("Authors: " + "\n");
			for (String author : this.authors) {
				info.append("Author: ").append(author).append("\n");
			}
		}
		return info.toString();
	}

}
