
package com.mikalai.spring.service;

import java.util.List;

import com.mikalai.spring.domain.Car;




public interface CarService {

	public List<Car> findAll();
	
	public Car save(Car car);
	
	public void updateCarAgeJob();
	
}
