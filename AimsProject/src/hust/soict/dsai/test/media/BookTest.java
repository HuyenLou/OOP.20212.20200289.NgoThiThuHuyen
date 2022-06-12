package hust.soict.dsai.test.media;

import java.util.ArrayList;
import java.util.List;

import hust.soict.dsai.aims.media.Book;

public class BookTest {

	public static void main(String[] args) {
		List<String> authors = new ArrayList<String>();
		String content = "hello, hello world. hello world java";
		authors.add("JK");
		Book book = new Book("Harry Potter", "Fiction", 12.78f, authors, content);
		System.out.println(book.getContent());

		book.processContent();

		System.out.println("list of tokens of content: " + book.getContentTokens());
		System.out.println("Frequency of words: " + book.getWordFrequency());

		System.out.println(book.toString());

	}

}
