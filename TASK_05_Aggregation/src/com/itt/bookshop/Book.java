package com.itt.bookshop;

public class Book {
	
	
	
	private String title;
	
	private String genre;
	
	private Author author;	



	public Book() {
		super();
	}



	public Book(String title, String genre, Author author) {
		super();
		this.title = title;
		this.genre = genre;
		this.author = author;
	}



	public String getTitle() {
		return title;
	}



	public void setTitle(String title) {
		this.title = title;
	}



	public String getGenre() {
		return genre;
	}



	public void setGenre(String genre) {
		this.genre = genre;
	}



	public Author getAuthor() {
		return author;
	}



	public void setAuthor(Author author) {
		this.author = author;
	}



	@Override
	public String toString() {
		return "Book [title=" + title + ", genre=" + genre + ", author=" + author + "]";
	}






	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
