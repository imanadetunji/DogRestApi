package com.udacity.DogRestApi.repository;

import com.udacity.DogRestApi.entity.Dog;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface DogRepository extends CrudRepository<Dog, Long> {
    @Query("SELECT dog.id, dog.breed from Dog dog where dog.id=:id")
    public String findBreedById(Long id);

    @Query("SELECT dog.id, dog.breed from Dog dog")
    List<String> findAllBreed();

    @Query("SELECT dog.id, dog.name from Dog dog")
    List<String> findAllName();
}
