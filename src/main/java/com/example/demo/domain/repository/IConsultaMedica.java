package com.example.demo.domain.repository;

import com.example.demo.domain.dto.DiagnosisDTO;
import com.example.demo.domain.dto.MedicalConsultationDTO;

import java.util.List;

public interface IConsultaMedica {
    public List<MedicalConsultationDTO> getAllMedicalConsultations();
    public MedicalConsultationDTO getMedicalConsultationById(Long id);
    public MedicalConsultationDTO saveMedicalConsultation(MedicalConsultationDTO dto);
    public MedicalConsultationDTO updateMedicalConsultationById(Long id, MedicalConsultationDTO dto);
    public void deleteMedicalConsultationById(Long id);
    public MedicalConsultationDTO getMedicalConsultationByAppointmentId(Long id);
    public List<MedicalConsultationDTO> getMedicalConsultationByPatientId(Long id);
    public List<DiagnosisDTO> getMostFrequentDiagnosis();
    public List<DiagnosisDTO> getMostFrequentDiagnosisByDate(String iDate, String fDate);
}
