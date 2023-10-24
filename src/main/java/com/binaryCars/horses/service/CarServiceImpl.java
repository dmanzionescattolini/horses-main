package com.binaryCars.horses.service;

import com.binaryCars.horses.entity.Car;
import com.binaryCars.horses.exceptions.ResourceNotFoundException;
import com.binaryCars.horses.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CarServiceImpl implements CarService{

    @Autowired
    CarRepository carRepository;
    @Override
    public List<Car> getCars() {
        return carRepository.findAll();
    }

    @Override
    public Car getCarById(Long id) {
        return carRepository.findById(id).orElseThrow(()->new ResourceNotFoundException(id));
    }
}
