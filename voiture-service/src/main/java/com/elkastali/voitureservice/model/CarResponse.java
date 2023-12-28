package com.elkastali.voitureservice.model;

import com.elkastali.voitureservice.entities.Client;
import lombok.*;

@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
@Builder
public class CarResponse {
    private Long id;
    private String marque;
    private String modele;
    private String matricule;
    private Client client;
}
