package com.binaryCars.horses.service;

import com.binaryCars.horses.entity.Owner;
import com.binaryCars.horses.exceptions.ResourceNotFoundException;
import com.binaryCars.horses.repository.OwnerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class OwnerServiceImpl implements OwnerService {

    @Autowired
    OwnerRepository ownerRepository;

    @Override
    public Owner getById(Long id) {
        return ownerRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No owner with id " + id + " found"));
    }

    @Override
    public Page<Owner> getAllOwners() {
        Sort sort = Sort.by(new Sort.Order(Sort.Direction.ASC, "lastName"));
        Pageable pageable = PageRequest.of(0, 5, Sort.unsorted());
        return ownerRepository.findAll(pageable);
    }

    @Override
    public Owner addOwner(Owner owner) {

        owner.setOwnerId(null);
        return ownerRepository.save(owner);
    }


    @Override
    public void deleteOwner(Long id) {


        ownerRepository.deleteById(id);
    }

    @Override
    public Page<Owner> getAllOwners(int i, int i1) {
        return ownerRepository.findAll(PageRequest.of(i, i1, Sort.unsorted()));
    }

    @Override
    public Owner updateOwner(Owner owner, Integer id) {
        assert ownerRepository.existsById(Long.valueOf(id));
        owner.setOwnerId(Long.valueOf(id));
        ownerRepository.save(owner);
        return ownerRepository.findById(Long.valueOf(id)).orElseThrow(() -> new ResourceNotFoundException("No owner record with id of " + id));
    }
}
