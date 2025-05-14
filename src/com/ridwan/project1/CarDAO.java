package com.ridwan.project1;

import java.sql.*;

public class CarDAO {

	String url = "jdbc:mysql://localhost:3306/car_inventory_system";
	String username = "root";
	String pass = "Omotosho3664!";
	Connection con = null;
	

		//Connection Method
	public void connect() {
			try {
				
				//Load JDBC Driver
				Class.forName("com.mysql.cj.jdbc.Driver");
				
				//Establishing connection ---> connecting to database
				con = DriverManager.getConnection(url,username,pass);
				
			}catch(Exception ex) {
				System.out.println(ex);
			}
		}
	
	public void addCar(Car c) {
		
		String query = "insert into cars values(?,?,?,?,?)";
		
		PreparedStatement pst;
		try {
			pst = con.prepareStatement(query);
			pst.setInt(1, c.carNumber);
			pst.setString(2, c.model);
			pst.setString(3, c.type);
			pst.setString(4, c.fuelType);
			pst.setString(5, c.transmission);
			pst.executeUpdate();
		} catch (Exception e) {
			// TODO Auto-generatede.printStackTrace();
			System.out.println(e);
		}
		
		
	}
	
	public Car getCar(int carNumber) {
		
		try {
			String query = "select * from cars where carNumber="+carNumber;
			
			
			Car car = new Car();
			car.carNumber = carNumber;
			
			
			Statement st = con.createStatement();
			
			//Execute query
			ResultSet rs = st.executeQuery(query);
			
			//Move pointer to first row
			rs.next();
			
			
			//Process query
			int number = rs.getInt(1);
			String model = rs.getString(2);
			String type = rs.getString(3);
			String fuelType = rs.getString(4);
			String transmission = rs.getString(5);
			
			car.carNumber = number;
			car.model = model;
			car.type = type;
			car.fuelType = fuelType;
			car.transmission = transmission;
			
			
			return car;
			
		}catch(Exception ex) {
			System.out.println(ex);
		}
		
		return null;
	}
	
	public void delete(int id) {
		
		String query = "delete from cars where carNumber = ?";
		
		try {
			PreparedStatement pst = con.prepareStatement(query);
			pst.setInt(1, id);
			
			int rowsAffected = pst.executeUpdate();
			
			if(rowsAffected > 0) {
				System.out.println("Car deleted successfully");
			}else {
				System.out.println("No car found with the row id");
			}
		}catch(Exception ex) {
			System.out.println(ex);
		}
		
	}
	
	public Car updateCar(Car car) {
		String query = "update cars set model=?, type=?, fuelType=?, transmission=? where carNumber=?";
		
		try {
			
			PreparedStatement pst = con.prepareStatement(query);
			pst.setInt(1, car.carNumber);
			pst.setString(2, car.model);
			pst.setString(3, car.type);
			pst.setString(4, car.fuelType);
			pst.setString(5, car.transmission);
			
			
			int rowsAffected = pst.executeUpdate();
			
			if(rowsAffected > 0) {
				System.out.println("Car updated successfully");
			}else {
				System.out.println("No car found with the given ID");
			}
			
			return car;
		}catch(Exception ex) {
			System.out.println(ex);
		}
		return null;
	}
}


