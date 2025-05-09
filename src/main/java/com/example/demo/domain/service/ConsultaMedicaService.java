package com.example.demo.domain.service;

import com.example.demo.domain.dto.MedicalConsultationDTO;
import com.example.demo.infraestructure.repositories.ConsultaMedicaImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ConsultaMedicaService {

    @Autowired
    ConsultaMedicaImpl consultaMedicaImpl;

    public List<MedicalConsultationDTO> getAllMedicalConsultations() {
        return consultaMedicaImpl.getAllMedicalConsultations();
    }
    public MedicalConsultationDTO getMedicalConsultationById(Long id) {
        return consultaMedicaImpl.getMedicalConsultationById(id);
    }
    public MedicalConsultationDTO saveMedicalConsultation(MedicalConsultationDTO dto) {
        return consultaMedicaImpl.saveMedicalConsultation(dto);
    }
    public MedicalConsultationDTO getMedicalConsultationByAppointmentId(Long id) {
        return consultaMedicaImpl.getMedicalConsultationByAppointmentId(id);
    }
    public MedicalConsultationDTO getMedicalConsultationByPatientId(Long id) {
        return consultaMedicaImpl.getMedicalConsultationByPatientId(id);
    }
}
