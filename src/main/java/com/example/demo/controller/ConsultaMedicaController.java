package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.domain.dto.DiagnosisDTO;
import com.example.demo.domain.dto.MedicalConsultationDTO;
import com.example.demo.domain.service.ConsultaMedicaService;

@RestController
@RequestMapping("/consulta")
public class ConsultaMedicaController {
    
    @Autowired
    private ConsultaMedicaService consultaService;

    @GetMapping
    public List<MedicalConsultationDTO> getAllMedicalConsultationDTOs(){
        return consultaService.getAllMedicalConsultations();
    }

    @GetMapping("/{id}")
    public MedicalConsultationDTO getMedicalConsultationById(@PathVariable long id){
        return consultaService.getMedicalConsultationById(id);
    }

    @PostMapping
    public MedicalConsultationDTO createMedicalConsultation(@RequestBody MedicalConsultationDTO MedicalConsultationDTO){
        return consultaService.saveMedicalConsultation(MedicalConsultationDTO);
    }

    @PutMapping("/{id}")
    public MedicalConsultationDTO updateMedicalConsultation(@PathVariable("id") Long id, @RequestBody MedicalConsultationDTO MedicalConsultationDTO){
        return consultaService.updateMedicalConsultationById(id, MedicalConsultationDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteMedicalConsultationById(@PathVariable long id){
        consultaService.deleteMedicalConsultationById(id);
    }

    @GetMapping("/cita/{id}")
    public MedicalConsultationDTO getMedicalConsultationByAppointmentId(@PathVariable long id){
        return consultaService.getMedicalConsultationByAppointmentId(id);
    }

    @GetMapping("/paciente/{id}")
    public List<MedicalConsultationDTO> getMedicalConsultationByPatientId(@PathVariable long id){
        return consultaService.getMedicalConsultationByPatientId(id);
    }

    @GetMapping("/diagnostico-frecuente")
    public List<DiagnosisDTO> getMostFrequentDiagnosis(){
        return consultaService.getMostFrequentDiagnosis();
    }

    @GetMapping("/diagnostico-frecuente-fecha")
    public List<DiagnosisDTO> getMostFrequentDiagnosisByDate(@RequestParam("fechaInicio") String iDate, @RequestParam("fechaFin") String fDate){
        return consultaService.getMostFrequentDiagnosisByDate(iDate, fDate);
    }
}
