package com.binaryCars.horses.service;

import com.binaryCars.horses.entity.Car;
import com.binaryCars.horses.exceptions.ResourceNotFoundException;
import com.binaryCars.horses.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CarServiceImpl implements CarService {

    @Autowired
    CarRepository carRepository;

    @Override
    public Page<Car> getCars(Integer pageNumber, Integer pageSize) {

        return carRepository.findAll(PageRequest.of(pageNumber, pageSize, Sort.unsorted()));
    }

    @Override
    public Page<Car> getCars() {
        return getCars(0, 5);
    }

    @Override
    public Car getCarById(Long id) {
        return carRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No car found with id " + id + " found"));
    }

    @Override
    public Car saveCar(Car car) {
        return carRepository.save(car);
    }

    @Override
    public Car updateCar(Long id, Car car) {
        Optional<Car> existingCar = carRepository.findById(id);

        car.setId(id);
        return carRepository.save(car);


    }

    @Override
    public void deleteCar(Long id) {
        carRepository.deleteById(id);

    }
}
