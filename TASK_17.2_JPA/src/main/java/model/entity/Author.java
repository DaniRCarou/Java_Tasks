package model.entity;



import java.util.Calendar;
import java.util.Date;
import java.util.List;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlElementWrapper;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;






// This tag is mandatory and is used to set the name of the root node.
@XmlRootElement(name="author")

// This tag is optional and is used to ensure that the tags appear in a specific order.
// This establishes a presentation order.
@XmlType(propOrder = {
		"idAuthor",
	    "name",
	    "surname",
	    "birthday",
	    "library"
	})
public class Author {
	
	
	
	
	private int idAuthor;		
	private String name;	
	private String surname;
	private Date birthday; 
	private List<Book> library;
	
	
	
	
	public Author() {
		super();
	}	
	
	
	
	
	
	
	public Author(int idAuthor, String name, String surname, Date birthday, List<Book> library) {
		super();
		this.idAuthor = idAuthor;
		this.name = name;
		this.surname = surname;
		this.birthday = birthday;
		this.library = library;
	}






	// This tag is optional and is used to indicate that this attribute will be an attribute in XML. It must be specified in its getter method.
	// It is indicated that this idAuthor should not be serialized as an element, but rather it should be serialized as an attribute.
	// Additionally, it is required that the name of this attribute be 'id'.
	@XmlAttribute(name = "id")	
	public int getIdAuthor() {
		return idAuthor;
	}


	public void setIdAuthor(int id) {
		this.idAuthor = id;
	}

	
	
	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}

	// This tag is optional and is used to modify certain properties, in this case, the name of the element. Always placed above the getter.
	@XmlElement(name="surnames")
	public String getSurname() {
		return surname;
	}


	public void setSurname(String surname) {
		this.surname = surname;
	}

	@XmlElement
	public Date getBirthday() {
		return birthday;
	}

	
	public void setBirthday(int day, int month, int year) {
		
	
		Calendar calendar = Calendar.getInstance();
		
	
		calendar.set(year, month - 1, day);
		
	
		this.birthday = calendar.getTime();
		
	}



	public void setLibrary(List<Book> books) {
		this.library = books;
	}

	
	@XmlElement(name = "copy")
	@XmlElementWrapper(name = "copies")
	public List<Book> getlibrary() {
		return library;
	}
	

	@Override
	public String toString() {
		return "Author: idAuthor=" + idAuthor + "\nname=" + name + "\nsurname=" + surname + "\nbirthday=" + birthday + "\nbooks="
				+ library + "";
	}











		
	

}
