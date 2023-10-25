package com.binaryCars.horses.controller;

import com.binaryCars.horses.entity.Car;
import com.binaryCars.horses.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/cars")
@RestController
public class CarController {


    @Autowired
    CarService carService;

    @GetMapping({"/?page={number}&size={pageSize}", "?page={number}&size={size}"})
    public ResponseEntity<Page<Car>> getCars(@PathVariable("number") Integer number, @PathVariable("size") Integer size) {
        return new ResponseEntity<>(carService.getCars(number, size), HttpStatus.OK);
    }

    @GetMapping({"/", ""})
    public ResponseEntity<Page<Car>> getCars() {
        return new ResponseEntity<>(carService.getCars(), HttpStatus.OK);
    }

    @GetMapping({"/{id}", "/{id}/"})
    public ResponseEntity<Car> getCarById(@PathVariable Long id) {
        return new ResponseEntity<>(carService.getCarById(id), HttpStatus.OK);
    }

    @PostMapping({"/", ""})
    public ResponseEntity<Car> saveCar(@RequestBody Car car) {
        return new ResponseEntity<Car>(carService.saveCar(car), HttpStatus.CREATED);
    }

    @PutMapping({"/{id}", "/{id}/"})
    public ResponseEntity<Car> updateCar(@PathVariable("id") Long id,
                                         @RequestBody Car car) {

        return ResponseEntity.ok(carService.updateCar(id, car));
    }

    @DeleteMapping({"/{id}","/{id}/"})
    public void deleteCar(@PathVariable("id") Integer id){
        carService.deleteCar(id.longValue());
    }
}
