
package com.mikalai.spring.repository;

import org.springframework.data.repository.CrudRepository;

import com.mikalai.spring.domain.Car;




public interface CarRepository extends CrudRepository<Car, Long> {

}
