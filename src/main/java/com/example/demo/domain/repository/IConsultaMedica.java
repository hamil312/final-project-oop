package com.example.demo.domain.repository;

import com.example.demo.domain.dto.MedicalConsultationDTO;

import java.util.List;

public interface IConsultaMedica {
    public List<MedicalConsultationDTO> getAllMedicalConsultations();
    public MedicalConsultationDTO getMedicalConsultationById(Long id);
    public MedicalConsultationDTO saveMedicalConsultation(MedicalConsultationDTO dto);
    public MedicalConsultationDTO getMedicalConsultationByAppointmentId(Long id);
    public MedicalConsultationDTO getMedicalConsultationByPatientId(Long id);

}
