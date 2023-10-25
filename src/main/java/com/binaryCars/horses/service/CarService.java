package com.binaryCars.horses.service;

import com.binaryCars.horses.entity.Car;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;


@Service
public interface CarService {

    Page<Car> getCars(Integer pageNumber, Integer pageSize);

    Page<Car> getCars();

    Car getCarById(Long id);

    Car saveCar(Car car);

    Car updateCar(Long id, Car car);

    void deleteCar(Long id);

}
