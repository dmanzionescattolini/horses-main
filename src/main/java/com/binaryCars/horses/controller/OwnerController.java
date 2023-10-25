package com.binaryCars.horses.controller;


import com.binaryCars.horses.entity.Owner;
import com.binaryCars.horses.service.OwnerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/owners")
@RestController
public class OwnerController {
    @Autowired
    OwnerServiceImpl ownerService;

    @GetMapping({"", "/"})
    public ResponseEntity<Page<Owner>> getAllOwners() {
        return new ResponseEntity<Page<Owner>>(ownerService.getAllOwners(0, 5), HttpStatus.OK);
    }

    @GetMapping({"/?page={number}&size={size}", "/?page={number}&size={size}/"})
    public ResponseEntity<Page<Owner>> getAllOwners(@PathVariable("number") Integer number, @PathVariable("size") Integer size) {
        return ResponseEntity.ok(ownerService.getAllOwners(number, size));
    }

    @PutMapping({"/{id}", "/{id}/"})
    public ResponseEntity<Owner> updateOwner(@PathVariable("id") Integer id, @RequestBody Owner owner) {
        return new ResponseEntity<Owner>(ownerService.updateOwner(owner, id), HttpStatus.ACCEPTED);
    }

    @GetMapping({"/{id}", "/{id}/"})
    public ResponseEntity<Owner> getOwnerById(@PathVariable("id") Integer id) {
        return new ResponseEntity<Owner>(ownerService.getById(Long.valueOf(id)), HttpStatus.OK);
    }

    @DeleteMapping({"/{id}", "/{id}/"})
    public void deleteOwner(@PathVariable("id") Integer id) {
        ownerService.deleteOwner(Long.valueOf(id));
    }

    @PostMapping({"/", ""})
    public ResponseEntity<Owner> addOwner(@RequestBody Owner owner) {
      return  new ResponseEntity<Owner>(ownerService.addOwner(owner), HttpStatus.CREATED);
    }
}
