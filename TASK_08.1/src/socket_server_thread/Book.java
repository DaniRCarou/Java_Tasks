package socket_server_thread;

public class Book {
	
	
	
	private String isbn;
	
	private int precio;
	
	private String autor;
	
	private String titulo;	
	

	


	public Book(String isbn, int precio, String autor, String titulo) {
		super();
		this.isbn = isbn;
		this.precio = precio;		
		this.titulo = titulo;
		this.autor = autor;
	}


	public String getIsbn() {
		return isbn;
	}


	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}


	public int getPrecio() {
		return precio;
	}


	public void setPrecio(int precio) {
		this.precio = precio;
	}


	public String getNombre() {
		return autor;
	}


	public void setNombre(String nombre) {
		this.autor = nombre;
	}


	public String getTitulo() {
		return titulo;
	}


	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	
	
	
	
	

	@Override
	public String toString() {
		return "Libro [isbn= " + isbn + ", precio= " + precio + ", nombre= " + autor + ", titulo= " + titulo + "]";
	}
	
	
	
	
	
	
	

}
