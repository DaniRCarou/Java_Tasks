package com.itt.bookshop;

public class Author {
	
	
	
	
	private String name;
	
	private String biography;
	
	

	public Author() {
		super();
	}



	public Author(String name, String biography) {
		super();
		this.name = name;
		this.biography = biography;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public String getBiography() {
		return biography;
	}



	public void setBiography(String biography) {
		this.biography = biography;
	}



	@Override
	public String toString() {
		return "Author [name=" + name + ", biography=" + biography + "]";
	}




	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
