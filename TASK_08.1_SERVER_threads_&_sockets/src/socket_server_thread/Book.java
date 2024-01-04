package socket_server_thread;

public class Book {
	
	
	
	private String isbn;
	
	private int price;
	
	private String author;
	
	private String title;	
	

	


	public Book(String isbn, int price, String author, String title) {
		super();
		this.isbn = isbn;
		this.price = price;			
		this.author = author;
		this.title = title;
	}


	public String getIsbn() {
		return isbn;
	}


	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}


	public int getPrice() {
		return price;
	}


	public void setPrice(int price) {
		this.price = price;
	}


	public String getAuthor() {
		return author;
	}


	public void setAuthor(String name) {
		this.author = name;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}

	
	
	
	
	

	@Override
	public String toString() {
		return "Book: isbn= " + isbn + ", price= " + price + ", name= " + author + ", title= " + title;
	}
	
	
	
	
	
	
	

}
