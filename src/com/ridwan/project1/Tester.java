package com.ridwan.project1;

public class Tester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		CarDAO dao = new CarDAO();
		
		Car car = new Car();
//		car.carNumber = 500;
//		car.model = "BMW 3 Series";
//		car.type = "Luxury Seden";
//		car.fuelType = "Petrol";
//		car.transmission = "Automatic";
		
		dao.connect();
//		dao.addCar(car);
		
//		dao.delete(200);
		
//		car = dao.getCar(500);
//		System.out.println(car.carNumber + " | "+ car.model +" | "+ car.type +" | "+ car.fuelType +" | "+ car.transmission);

		
		
		car.carNumber = 100;
		car.model = "Hyundai";
		car.type = "Electric SUV";
		car.fuelType = "Electric";
		car.transmission = "Single Speed";
		
		
		
		car = dao.updateCar(car);
		
	}

}
