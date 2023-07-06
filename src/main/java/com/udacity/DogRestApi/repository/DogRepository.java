package com.udacity.DogRestApi.repository;

import com.udacity.DogRestApi.entity.Dog;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface DogRepository extends CrudRepository<Dog, Long> {
    @Query("SELECT dog.breed FROM Dog dog WHERE dog.id = :id")
    String findBreedById(Long id);

    @Query("SELECT dog.breed FROM Dog dog")
    List<String> findAllBreed();

    @Query("SELECT dog.name FROM Dog dog")
    List<String> findAllName();

}
