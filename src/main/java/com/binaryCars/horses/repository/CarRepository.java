package com.binaryCars.horses.repository;

import com.binaryCars.horses.entity.Car;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.ListPagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarRepository extends ListPagingAndSortingRepository<Car, Long>, CrudRepository<Car, Long> {


    List<Car> findCarByMake(String make);

    List<Car> findCarByMakeOrderByYearAsc(String make);


    Car deleteById(Integer id);

}
