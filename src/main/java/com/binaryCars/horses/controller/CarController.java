package com.binaryCars.horses.controller;

import com.binaryCars.horses.entity.Car;
import com.binaryCars.horses.service.CarService;
import com.binaryCars.horses.service.CarServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController("/")
public class CarController {



    @Autowired
    CarService carService;
    @GetMapping("/cars")
    public ResponseEntity<List<Car>> getCars(){
        return new ResponseEntity<>(carService.getCars(), HttpStatus.OK);
    }

    @GetMapping("/cars/:id")
    public ResponseEntity<Car> getCarById(@PathVariable("id") Long id){
        return new ResponseEntity<>(carService.getCarById(id),HttpStatus.OK);
    }
}
