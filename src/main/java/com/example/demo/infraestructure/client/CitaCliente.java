package com.example.demo.infraestructure.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.demo.domain.dto.CitaDTO;

@FeignClient(name = "appointment-client", url = "https://citaspoo-production.up.railway.app")
public interface CitaCliente {

    @GetMapping("/citas/{id}")
    CitaDTO getAppointmentById(@PathVariable("id") Long id);
}