package com.elkastali.voitureservice.service;

import com.elkastali.voitureservice.entities.Car;
import com.elkastali.voitureservice.entities.Client;
import com.elkastali.voitureservice.model.CarResponse;
import com.elkastali.voitureservice.repository.CarRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CarService {

    private final CarRepository carRepository;
    private final String URL = "http://gateway-service:8888/CLIENT-SERVICE/clients";
    private final RestTemplate restTemplate;

    public List<CarResponse> findAll(){
        List<Car>cars=carRepository.findAll();

        ResponseEntity<Client[]>response=restTemplate.getForEntity(this.URL,Client[].class);
        Client[] clients=response.getBody();
        return cars.stream().map((Car car)-> mapToCarResponse(car,clients)).toList();
    }

    public CarResponse findById(Long id){
        Car car=carRepository.findById(id).orElseThrow(()->new RuntimeException("Car not found"));
        Client client=restTemplate.getForObject(this.URL+"/"+car.getClientId(),Client.class);
        return CarResponse.builder()
                .id(car.getId())
                .marque(car.getMarque())
                .modele(car.getModele())
                .matricule(car.getMatricule())
                .client(client)
                .build();
    }











    private CarResponse mapToCarResponse(Car car,Client[] clients ){
        Client foundClient= Arrays.stream(clients)
                .filter(client -> client.getId().equals(car.getClientId()))
                .findFirst()
                .orElse(null);
        return CarResponse.builder()
                .id(car.getId())
                .marque(car.getMarque())
                .modele(car.getModele())
                .matricule(car.getMatricule())
                .client(foundClient)
                .build();
    }
}
