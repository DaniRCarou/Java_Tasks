package main;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import model.entity.Author;
import model.entity.Book;
import model.entity.Bookstore;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class ObjectToXML {

	public static void main(String[] args) {


		JAXBContext context;
		
		
		try {
						
			context = JAXBContext.newInstance(Author.class);
						
		} catch (JAXBException e) {
			System.out.println("Error by creating the context");
			System.out.println(e.getMessage());
			e.printStackTrace();
			return;
		}
		
		
		
		
		// It is used for serialization, to convert objects into XML format.
		Marshaller m;
		
		
		try {
			
			m = context.createMarshaller();
			
			 
			// this property is used to read the result better
			// To send the information, it is better to do it without this property. Without spaces, Tabs......they are information too
			m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
				
			
			
			List<Bookstore> bookstores = new ArrayList<Bookstore>();
			
			// Bookstore1
			
			Bookstore bs1 = new Bookstore();
			bs1.setName("Rolland business");
			bs1.setOwner("John Doe");
			bookstores.add(bs1);
				
			
			 
			
			// Bookstore2
			
			Bookstore bs2 = new Bookstore();
			bs2.setName("Balaidos");
			bs2.setOwner("María del Rocío");		
			bookstores.add(bs2);
			
			
			
			
			List<Book> library = new ArrayList<>();
			// Book 1
			Book b1 = new Book();
			b1.setId(1);
			b1.setTitle("Holy wassa");
			b1.setPrice(10.2);	
			b1.setBookstores(bookstores);
			library.add(b1);	
			
			// Book 2
			Book b2 = new Book();	
			b2.setId(2);
			b2.setTitle("The way you are");
			b2.setPrice(15);
			library.add(b2);
					
			// Book 3
			Book b3 = new Book();
			b3.setId(3);
			b3.setTitle("I want you");
			b3.setPrice(18);
			library.add(b3);
			
			// Book 4
			Book b4 = new Book();
			b4.setId(4);
			b4.setTitle("It always remind me of you");
			b4.setPrice(3.8);
			library.add(b4);
			
			
			
							
			
			
			Author a = new Author(1, "Homer", "Simpson", null, library);
			
			a.setBirthday(2, 11, 1983);
			
		
		
			
			// The object is converted to XML and printed on the screen.
			m.marshal(a, System.out);
			m.marshal(b1, System.out);
			// A file can also be created.
			m.marshal(a, new File("homer.xml"));
			m.marshal(b1, new File("bookstores_book1.xml"));
			
			
			
			
		} catch (JAXBException e) {
			System.out.println("Error convirtiendo el objeto a formato XML");
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
