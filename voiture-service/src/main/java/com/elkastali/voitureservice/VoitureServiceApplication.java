package com.elkastali.voitureservice;

import com.elkastali.voitureservice.entities.Car;
import com.elkastali.voitureservice.repository.CarRepository;
import com.elkastali.voitureservice.service.CarService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableDiscoveryClient
public class VoitureServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(VoitureServiceApplication.class, args);
    }


    @Bean
    public RestTemplate restTemplate(){
        RestTemplate restTemplate=new RestTemplate();
        SimpleClientHttpRequestFactory requestFactory=new SimpleClientHttpRequestFactory();
        requestFactory.setConnectTimeout(5000);
        requestFactory.setReadTimeout(5000);
        restTemplate.setRequestFactory(requestFactory);
        return restTemplate;
    }


    @Bean
    CommandLineRunner commandLineRunner(CarRepository carRepository){
        return args ->{

            carRepository.save(Car.builder()
                    .marque("Mercedes")
                    .modele("Class A")
                    .matricule("123456")
                    .clientId(1L)
                    .build());
            carRepository.save(Car.builder()
                    .marque("BMW")
                    .modele("x6")
                    .matricule("123456")
                    .clientId(2L)
                    .build());
            carRepository.save(Car.builder()
                    .marque("Mercedes")
                    .modele("AMG")
                    .matricule("123456")
                    .clientId(3L)
                    .build());

        };
    }
}
