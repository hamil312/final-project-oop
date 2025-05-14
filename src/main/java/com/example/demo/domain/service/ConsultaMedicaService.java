package com.example.demo.domain.service;

import com.example.demo.domain.dto.DiagnosisDTO;
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

    public MedicalConsultationDTO updateMedicalConsultationById(Long id, MedicalConsultationDTO dto) {
        return consultaMedicaImpl.updateMedicalConsultationById(id, dto);
    }

    public void deleteMedicalConsultationById(Long id) {
        consultaMedicaImpl.deleteMedicalConsultationById(id);
    }

    public MedicalConsultationDTO getMedicalConsultationByAppointmentId(Long id) {
        return consultaMedicaImpl.getMedicalConsultationByAppointmentId(id);
    }
    public List<MedicalConsultationDTO> getMedicalConsultationByPatientId(Long id) {
        return consultaMedicaImpl.getMedicalConsultationByPatientId(id);
    }

    public List<DiagnosisDTO> getMostFrequentDiagnosis() {
        return consultaMedicaImpl.getMostFrequentDiagnosis();
    }

    public List<DiagnosisDTO> getMostFrequentDiagnosisByDate(String iDate, String fDate) {
        return consultaMedicaImpl.getMostFrequentDiagnosisByDate(iDate, fDate);
    }
}
