package com.example.demo.infraestructure.repositories;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.demo.infraestructure.client.CitaCliente;
import com.example.demo.infraestructure.crud.ConsultaMedicaRepository;
import com.example.demo.infraestructure.entity.ConsultaMedica;
import com.example.demo.infraestructure.mapper.ConsultaMapper;
import com.example.demo.domain.dto.AppointmentDTO;
import com.example.demo.domain.dto.DiagnosisDTO;
import com.example.demo.domain.dto.MedicalConsultationDTO;
import com.example.demo.domain.repository.IConsultaMedica;

@Repository
public class ConsultaMedicaImpl implements IConsultaMedica {
    @Autowired
    private ConsultaMedicaRepository consultaRepository;

    @Autowired
    private ConsultaMapper consultaMapper;

    @Autowired
    private CitaCliente appointmentClient;

    @Override
    public List<MedicalConsultationDTO> getAllMedicalConsultations() {
        List<ConsultaMedica> consultas = consultaRepository.findAll();
        return consultaMapper.toMedicalConsultationsDTO(consultas);
    }

    @Override
    public MedicalConsultationDTO getMedicalConsultationById(Long id){
        ConsultaMedica consultaMedica = consultaRepository.findById(id).get();
        return consultaMapper.toMedicalConsultationDTO(consultaMedica);
    }

    @Override
    public MedicalConsultationDTO saveMedicalConsultation(MedicalConsultationDTO dto) {
        AppointmentDTO appointment = appointmentClient.getAppointmentById(dto.getAppointmentId());
        if(consultaRepository.findByCitaId(appointment.getId()) != null){
            throw new RuntimeException("La cita ya tiene una consulta médica asociada");
        }

        dto.setDate(appointment.getDate());
        dto.setMedicId(appointment.getMedicId());
        dto.setPatientId(appointment.getPatientId());

        ConsultaMedica consultaMedica = consultaMapper.toConsultaMedica(dto);
        return consultaMapper.toMedicalConsultationDTO(consultaRepository.save(consultaMedica));
    }

    @Override
    public MedicalConsultationDTO updateMedicalConsultationById(Long id, MedicalConsultationDTO consultationDTO) {
        ConsultaMedica consultaMedica =  consultaRepository.findById(id).orElseThrow(() -> new RuntimeException("ConsultaMedica no encontrado"));
        ConsultaMedica ConsultaMedicaUpdate = consultaMapper.toConsultaMedica(consultationDTO);
        consultaMedica.setFecha(ConsultaMedicaUpdate.getFecha());
        consultaMedica.setDiagnostico(ConsultaMedicaUpdate.getDiagnostico());
        consultaMedica.setPrescripcion(ConsultaMedicaUpdate.getPrescripcion());
        consultaMedica.setMedicoId(ConsultaMedicaUpdate.getMedicoId());
        consultaMedica.setCitaId(ConsultaMedicaUpdate.getCitaId());
        consultaMedica.setPacienteId(ConsultaMedicaUpdate.getPacienteId());
        return consultaMapper.toMedicalConsultationDTO(consultaRepository.save(consultaMedica));
    }

    @Override
    public void deleteMedicalConsultationById(Long id) {
        consultaRepository.deleteById(id);
    }

    @Override
    public MedicalConsultationDTO getMedicalConsultationByAppointmentId(Long id){
        ConsultaMedica consultaMedica = consultaRepository.findByCitaId(id);
        return consultaMapper.toMedicalConsultationDTO(consultaMedica);
    }

    @Override
    public List<MedicalConsultationDTO> getMedicalConsultationByPatientId(Long id){
        List<ConsultaMedica> consultaMedica = consultaRepository.findByPacienteId(id);
        return consultaMapper.toMedicalConsultationsDTO(consultaMedica);
    }

    @Override
    public List<DiagnosisDTO> getMostFrequentDiagnosis() {
        List<ConsultaMedica> consultas = consultaRepository.findAll();

        Map<String, Integer> diagnosisCountMap = new HashMap<>();

        for (ConsultaMedica consulta : consultas) {
            String diagnosis = consulta.getDiagnostico();
            if (diagnosis != null && !diagnosis.isEmpty()) {
                diagnosisCountMap.put(diagnosis, diagnosisCountMap.getOrDefault(diagnosis, 0) + 1);
            }
        }

        int maxCount = diagnosisCountMap.values().stream()
            .max(Integer::compareTo)
            .orElse(0);

        List<DiagnosisDTO> mostFrequentDiagnosis = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : diagnosisCountMap.entrySet()) {
            if (entry.getValue() == maxCount) {
                DiagnosisDTO dto = new DiagnosisDTO();
                dto.setDiagnosis(entry.getKey());
                dto.setAmount(entry.getValue());
                mostFrequentDiagnosis.add(dto);
            }
        }

        return mostFrequentDiagnosis;
    }

    @Override
    public List<DiagnosisDTO> getMostFrequentDiagnosisByDate(String iDate, String fDate) {
        List<ConsultaMedica> unfilteredConsultas = consultaRepository.findAll();
        List<ConsultaMedica> consultas = new ArrayList<ConsultaMedica>();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        for(ConsultaMedica unConsulta: unfilteredConsultas){
            LocalDate cDate = LocalDate.parse(unConsulta.getFecha().substring(0, 10), formatter);
            LocalDate sDate = LocalDate.parse(iDate, formatter);
            LocalDate eDate = LocalDate.parse(fDate, formatter);
            if(cDate.isAfter(sDate.minusDays(1)) && cDate.isBefore(eDate.plusDays(1))){
                consultas.add(unConsulta);
            }
        }
        
        Map<String, Integer> diagnosisCountMap = new HashMap<>();

        for (ConsultaMedica consulta : consultas) {
            String diagnosis = consulta.getDiagnostico();
            if (diagnosis != null && !diagnosis.isEmpty()) {
                diagnosisCountMap.put(diagnosis, diagnosisCountMap.getOrDefault(diagnosis, 0) + 1);
            }
        }

        int maxCount = diagnosisCountMap.values().stream()
            .max(Integer::compareTo)
            .orElse(0);

        List<DiagnosisDTO> mostFrequentDiagnosis = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : diagnosisCountMap.entrySet()) {
            if (entry.getValue() == maxCount) {
                DiagnosisDTO dto = new DiagnosisDTO();
                dto.setDiagnosis(entry.getKey());
                dto.setAmount(entry.getValue());
                mostFrequentDiagnosis.add(dto);
            }
        }

        return mostFrequentDiagnosis;
    }
}
