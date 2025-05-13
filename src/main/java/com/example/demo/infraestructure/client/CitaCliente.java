package com.example.demo.infraestructure.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.demo.domain.dto.AppointmentDTO;

@FeignClient(name = "appointment-client", url = "http://localhost:8090")
public interface CitaCliente {

    @GetMapping("/appointments/{id}")
    AppointmentDTO getAppointmentById(@PathVariable("id") Long id);
}