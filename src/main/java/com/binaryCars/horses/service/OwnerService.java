package com.binaryCars.horses.service;


import com.binaryCars.horses.entity.Owner;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

@Service
public interface OwnerService {
    Owner getById(Long id);

    Page<Owner> getAllOwners();

    Owner addOwner(Owner owner);


    void deleteOwner(Long id);

    Page<Owner> getAllOwners(int i, int i1);

    Owner updateOwner(Owner owner, Integer id);
}
