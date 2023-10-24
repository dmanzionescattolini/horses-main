package com.binaryCars.horses.service;

import com.binaryCars.horses.entity.Car;
import com.binaryCars.horses.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public interface CarService {

    List<Car> getCars();

    Car getCarById(Long id);
}
