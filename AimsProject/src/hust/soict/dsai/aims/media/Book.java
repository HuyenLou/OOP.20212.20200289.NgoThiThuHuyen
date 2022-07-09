package hust.soict.dsai.aims.media;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Book extends Media {
	private int id;
	private static int count = 0;
	private static int nbBooks = 0;
	private List<String> authors = new ArrayList<String>();
	private String content;

	private String key = "";
	private Integer value;

	private List<String> contentTokens = new ArrayList<String>();

	private Map<String, Integer> wordFrequency = new TreeMap<String, Integer>();

	public void setContent(String content) {
		this.content = content;
	}

	public String getContent() {
		return this.content;
	}

	public void processContent() {
		
		this.content = this.content.replace(",", "");
		this.content = this.content.replace(".", "");
		

		String[] tokens = this.content.split(" ");
		{
			for (String token : tokens) {
				this.contentTokens.add(token);
			}
		}
		Collections.sort(this.contentTokens);

		for (int k = 0; k < this.contentTokens.size(); k++) {
			key = this.contentTokens.get(k);
			if (this.wordFrequency.containsKey(key)) {
				value = this.wordFrequency.get(key);
				this.wordFrequency.remove(key);
				this.wordFrequency.put(key, value + 1);
			} else {
				this.wordFrequency.put(key, 1);
			}
		}

	}

	public List<String> getContentTokens() {
		return this.contentTokens;
	}

	public Map<String, Integer> getWordFrequency() {
		return this.wordFrequency;
	}

	public Book() {
		super();
		nbBooks++;
		count++;
		this.setId(count);
	}

	public Book(String title) {
		super(title);
		nbBooks++;
		count++;
		this.setId(count);
	}

	public Book(String title, float cost) {
		super(title, cost);
		nbBooks++;
		count++;
		this.setId(count);
	}

	public Book(String title, String category, float cost) {
		super(title, category, cost);
		nbBooks++;
		count++;
		this.setId(count);
	}
	

	public Book(String title, String category, float cost, List<String> authors) {
		super(title, category, cost);
		this.authors = authors;
		nbBooks++;
		count++;
		this.setId(count);
	}

	public Book(String title, String category, float cost, List<String> authors, String content) {
		super(title, category, cost);
		this.authors = authors;
		this.content = content;
		nbBooks++;
		count++;
		this.setId(count);
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
			info.append("The authors:  " + "\n");
			for (String author : this.authors) {
				info.append("Author:  ").append(author).append("\n");
			}
		}
		if (this.contentTokens.size() != 0) {
			info.append("content length: " + contentTokens.size()  + "\n");
			info.append("token list: ");
			for (String token : this.contentTokens) {
				info.append(token).append(", ");
			}
			info.append("\n").append("Frequency of words in the content: ").append("\n");
			for (Map.Entry<String, Integer> entry : wordFrequency.entrySet()) {
				info.append(entry.getKey()).append(" - ").append(entry.getValue()).append("\n");
			}
		}

		return info.toString();
	}

}
