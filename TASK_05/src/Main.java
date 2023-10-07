import com.itt.bookshop.Author;
import com.itt.bookshop.Book;

public class Main {

	public static void main(String[] args) {
		
		
		
		Author author1 = new Author("Jose", "Nacido en Santiago, escribió dos libros");
		
		Book book1 = new Book("La castaña", "Comedia", author1);
		
		
		
		System.out.println(book1);
		
		
		book1.getAuthor().setBiography("Criado en la Coruña, ha empezado dibujando.");
		
		
		System.out.println(book1.getAuthor().toString());
		System.out.println(book1.getAuthor()); // it´s the same
		
		
		System.out.println(author1);	
		
		
		book1.setGenre("drama");		
		System.out.println(book1);
		
		
		
		
		
		
		
		
		
		
		

	}

}
