package com.binaryCars.horses.repository;

import com.binaryCars.horses.entity.Car;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CarRepository extends CrudRepository<Car,Long> {

    List<Car> findCarByMake(String make);
    List<Car> findCarByMakeOrderByYearAsc(String make);

    List<Car> findAll();

}
