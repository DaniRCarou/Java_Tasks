package example;




// JAVADOC

// There are three things that can be documented: The class, attributes and methods. 
// Javadoc comments must always be placed before what we want to comment on, before the class, before the attributes and before the methods
// It is possible to use HTML code
// It is recommended to write JavaDoc comments during writing the code, not at the end.






// 1. It WILL BE COMMENTED WHAT THE CLASS IS, WHAT IT DOES 

/** 
 * <h2>This is an Employee class, it is used to create and reading employees from a database</h2>
 * It looks for JavaDoc information in <a href="https://google.es">Google</a>
 * @author Daniel
 * @version 1.0  
 * 
 * To see other classes of this Package in Javadoc, is possible to create a link to the class:
 * @see ExampleLink 
 * 
 */





public class Employee {
	
	
	
	
	
    // 2. It WILL BE COMMENTED WHAT EVERY ATTRIBUTE IS
	
	/** 
	 * Employee name attribute
	*/	
	public String name;
	
	/** 
	 * Employee surname attribute
	*/	
	public String surname;
	
	/** 
	 * gross salary received per month, attribute
	*/
	public double salary;
	

	
   
	
	
	// 3. It WILL BE COMMENTED WHAT EVERY METHOD DO, PARAMETERS THAT RECEIVES AND VALUES THAT RETURNS
	
	
	
	
	// it must be written a method description
	// It is necessary to write the @param annotation for each of parameters
	// After @param goes the name of the parameter and the parameter description
	
	/** 
	 * Constructor with three parameters, 
	 * which creates objects of type employee, with first name, last name and salary
	 *
	 * @param name
	 * @param surname
	 * @param salary
	 */
	public Employee(String name, String surname, double salary) {
		super();
		this.name = name;
		this.surname = surname;
		this.salary = salary;
	}
	
	
	
	
	// @see parameter allows to make links to other class from the same packet or from the Java API
	
	/** 
	 * Increase the employee salary depending of the quantity
	 * @see Employee
	 * @param increase
	 */
	public void raiseSalary(double increase) {
		
		salary = salary + increase;
		
	}
	
	
	// @return necesary, with a description
	
	/**	
	 * it checks that the name is not empty
	 * @return
	 * <ul>
	 * <li>true: the name is not an empty string</li>
	 * <li>false: the name is empty </li>
	 * </ul>
	 */
	public boolean check() {
		
		if(name.equals("")) {
			
			return false;
			
		}
		
		return true;
		
	}
	
	
	
	
	
	// At the end, it has to be generated the html file
	
	/*
	 * 1. Menu -> Project -> Generate Javadoc
	 * 
	 * 2. New window -> Select types for which Javadoc will be generated: example
	 * 3. Public
	 * 4. It will be saved in a doc folder
	 * 5. finish
	 * 
	 * 6. New window -> Document title: My Javadoc example
	 * 7. the next, it is possible to deactivate annotations we don´t need
	 * 
	 * 8. Style sheet: it has to be introduced our CSS style sheet
	 */
	
	
	
	// In the project is created a doc folder. To show it:
	
	/*
	 * 1. Right click on the project doc folder	-> show in -> System explorer
	 * 2. Explorer is opened and double click on doc folder
	 * 4. It has to be started with the index. Double click on index.html
	 * 5. New window -> click on employee
	 */
	
	

}
