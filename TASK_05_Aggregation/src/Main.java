import com.itt.bookshop.Author;
import com.itt.bookshop.Book;

public class Main {

	public static void main(String[] args) {
		
		
		
		Author author1 = new Author("Jose", "Nacido en Santiago, escribi� dos libros");
		
		Book book1 = new Book("La casta�a", "Comedia", author1);
		
		
		
		System.out.println(book1);
		
		
		book1.getAuthor().setBiography("Criado en la Coru�a, ha empezado dibujando.");
		
		
		System.out.println(book1.getAuthor().toString());
		System.out.println(book1.getAuthor()); // it�s the same
		
		
		System.out.println(author1);	
		
		
		book1.setGenre("drama");		
		System.out.println(book1);
		
		
		
		
		
		
		
		
		
		
		

	}

}
