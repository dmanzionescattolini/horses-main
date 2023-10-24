package com.binaryCars.horses.repository;

import com.binaryCars.horses.entity.Owner;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OwnerRepository  extends CrudRepository<Owner,Long> {
}
