package com.elkastali.clientservice;

import com.elkastali.clientservice.entities.Client;
import com.elkastali.clientservice.repository.ClientRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableDiscoveryClient
public class ClientServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(ClientServiceApplication.class, args);
    }


    @Bean
    CommandLineRunner commandLineRunner(ClientRepository clientRepository){
        return args -> {
clientRepository.save(Client.builder()
                    .nom("Elkastali1")
                    .age(22F)
                    .build());

            clientRepository.save(Client.builder()
                    .nom("Elkastali2")
                    .age(22F)
                    .build());
            clientRepository.save(Client.builder()
                    .nom("Elkastali3")
                    .age(22F)
                    .build());

        };
    }
}
