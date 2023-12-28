package com.elkastali.voitureservice.entities;


import lombok.*;

@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
@ToString
@Builder
public class Client {

    private Long id;
    private String nom;
    private Float age;
}
