package com.elkastali.voitureservice.controller;


import com.elkastali.voitureservice.model.CarResponse;
import com.elkastali.voitureservice.service.CarService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/voitures")
@RequiredArgsConstructor
public class ClientController {

    private final CarService carService;

    @GetMapping
    public List<CarResponse> findAll(){
        return carService.findAll();
    }
    @GetMapping("/{id}")
    public CarResponse findById(@PathVariable Long id)throws Exception{
        return carService.findById(id);
    }
}
