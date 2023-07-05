package com.udacity.DogRestApi.web;

import com.udacity.DogRestApi.entity.Dog;
import com.udacity.DogRestApi.service.DogService;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@ApiResponses(value = {
        @ApiResponse(code=400, message= "This is a bad request, please follow the API documentation for the proper request format."),
        @ApiResponse(code=401, message = "Due to security constraints, your access request cannot be authorized."),
        @ApiResponse(code = 500, message = "The service is down. Please make sure that the Dog microservice is running.")
})
public class DogController {
    private DogService dogService;

    @Autowired
    public void setDogService(DogService dogService) {
        this.dogService = dogService;
    }

    @GetMapping("/dogs")
    public ResponseEntity<List<Dog>> getAllDogs() {
        List<Dog> list = dogService.retrieveDogs();
        return new ResponseEntity<List<Dog>>(list, HttpStatus.OK);
    }

    @GetMapping("/dogs/breed")
    public ResponseEntity<List<String>> getDogBreed() {
        List<String> dogBreeds = dogService.retrieveDogBreed();
        return new ResponseEntity<List<String>>(dogBreeds, HttpStatus.OK);
    }

    @GetMapping("/{id}/breed")
    public ResponseEntity<String> getDogBreedById(@PathVariable Long id) {
        String dogBreed = dogService.retrieveDogBreedById(id);
        return new ResponseEntity<String>(dogBreed, HttpStatus.OK);
    }

    @GetMapping("/dogs/name")
    public ResponseEntity<List<String>> getDogNames() {
        List<String> dogNames = dogService.retrieveDogNames();
        return new ResponseEntity<List<String>>(dogNames, HttpStatus.OK);
    }
}
