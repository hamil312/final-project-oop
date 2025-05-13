package com.example.demo.infraestructure.repositories;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.demo.infraestructure.client.CitaCliente;
import com.example.demo.infraestructure.crud.ConsultaMedicaRepository;
import com.example.demo.infraestructure.entity.ConsultaMedica;
import com.example.demo.infraestructure.mapper.ConsultaMapper;
import com.example.demo.domain.dto.AppointmentDTO;
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
}
