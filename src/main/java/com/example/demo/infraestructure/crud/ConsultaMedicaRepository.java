package com.example.demo.infraestructure.crud;

import com.example.demo.infraestructure.entity.ConsultaMedica;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConsultaMedicaRepository extends JpaRepository<ConsultaMedica, Long> {
    ConsultaMedica findByCitaId(Long citaId);
    List<ConsultaMedica> findByPacienteId(Long pacienteId);
}
