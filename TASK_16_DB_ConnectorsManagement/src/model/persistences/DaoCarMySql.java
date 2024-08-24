package model.persistences;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.entity.Car;
import model.persistence.interfaces.DaoCar;

public class DaoCarMySql implements DaoCar{
	
	
	
	
	
	private Connection con;
	
	
	
	
	
	
	
	
	public boolean openConnection() {
		
		String url = "jdbc:mysql://localhost:3306/bbdd";
		String user = "root";
		String password = "";
		
		try {
			
			con = DriverManager.getConnection(url, user, password);
			
		} catch (SQLException e) {
			
			e.printStackTrace();
			
			return false;
		}		
		
		return true;
		
	}
	
	
	
	
	
	
	public boolean closeConnection(){
		
		try {
			
			con.close();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
			
			return false;
			
		}
		
		return true;
		
	}
	
	
	
	

	@Override
	public boolean register(Car c) {

		if(!openConnection()){
			return false;
		}
		boolean register = true;
		
		
		String query = "insert into cars (ID,PLATE,BRAND,MODEL,COLOR) "
				+ " values(?,?,?,?,?)";
		
		
		try {


			PreparedStatement ps = con.prepareStatement(query);
			ps.setInt(1, c.getId());
			ps.setString(2, c.getPlate());
			ps.setString(3, c.getBrand());
			ps.setString(4, c.getModel());
			ps.setString(5, c.getColor());
			
			
			int affectedRowsNumber = ps.executeUpdate();
			
			if(affectedRowsNumber == 0) {
				
				register = false;
				
			}
			
		} catch (SQLException e) {
			
			System.out.println("Create -> Error inserting: " + c);			
			
			register = false;
			
			e.printStackTrace();
			
		} finally{
			
			closeConnection();
			
		}
		
		return register;
	}
	
	
	
	
	
	
	@Override
	public boolean delete(int id) {
		
		if(!openConnection()){
			return false;
		}
		
		boolean deleted = true;
		
		String query = "delete from cars where id = ?";
		
		try {
			
			PreparedStatement ps = con.prepareStatement(query);
			
			
			
			ps.setInt(1, id);
			
			int affectedRowsNumber = ps.executeUpdate();
			
			if(affectedRowsNumber == 0)
				
				deleted = false;
			
		} catch (SQLException e) {
			
			System.out.println("delete -> It couldn't be deleted" + " the id " + id);
			
			e.printStackTrace();
			
		} finally {
			
			closeConnection();
			
		}
		
		return deleted; 
		
	}
	
	
	
	
	
	
	@Override
	public boolean update(Car c) {
		
		if(!openConnection()){
			
			return false;
			
		}
		boolean modified = true;
		
		String query = "update cars set PLATE=?, BRAND=?, MODEL=?, " + "COLOR=? WHERE ID=?";
		
		try {
			
			PreparedStatement ps = con.prepareStatement(query);
			
			ps.setString(1, c.getPlate());
			
			ps.setString(2, c.getBrand());
			
			ps.setString(3, c.getModel());
			
			ps.setString(4, c.getColor());
			
			ps.setInt(5, c.getId());
			
			int affectedRowsNumber = ps.executeUpdate();
			
			if(affectedRowsNumber == 0)
				
				modified = false;
			
			else
				
				modified = true;
			
		} catch (SQLException e) {
			
			// TODO Auto-generated catch block
			System.out.println("update -> error by modifying the" + " car " + c);
			
			modified = false;
			
			e.printStackTrace();
			
		} finally{
			
			closeConnection();
			
		}
		
		return modified;
		
	}
	
	
	
	
	
	
	@Override
	public Car read(int id) {
		
		if(!openConnection()){
			
			return null;
			
		}		
		
		Car car = null;
		
		String query = "select ID,PLATE,BRAND,MODEL,COLOR from cars " + "where id = ?";
	
		try {
			
			PreparedStatement ps = con.prepareStatement(query);
			
			ps.setInt(1, id);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()){
				
				car = new Car();
				
				car.setId(rs.getInt(1));
				
				car.setPlate(rs.getString(2));
				car.setBrand(rs.getString(3));
				car.setModel(rs.getString(4));
				car.setColor(rs.getString(5));				
				
				
			}
			
		} catch (SQLException e) {
			
			System.out.println("read -> Error retrieving the " + "car with id " + id);
			
			e.printStackTrace();
			
		} finally {
			
			closeConnection();
			
		}
		
		
		return car;
	}

	

	

	@Override
	public List<Car> list() {
		
		if(!openConnection()){
			
			return null;
			
		}		
		
		List<Car> carList = new ArrayList<>();
		
		String query = "select ID,PLATE,BRAND,MODEL,COLOR from cars";
		
		try {
			
			PreparedStatement ps = con.prepareStatement(query);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()){
				
				Car car = new Car();
				
				car.setId(rs.getInt(1));
				
				car.setPlate(rs.getString(2));
				
				car.setBrand(rs.getString(3));
				
				car.setModel(rs.getString(4));
				
				car.setColor(rs.getString(5));
				
				carList.add(car);
				
			}
			
		} catch (SQLException e) {
			
			System.out.println("listar -> error al obtener las " + "personas");
			
			e.printStackTrace();
			
		} finally {
			
			closeConnection();
			
		}		
		
		return carList;
		
	}






	

}
