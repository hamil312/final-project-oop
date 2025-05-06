package com.example.demo.infraestructure.repositories;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.demo.infraestructure.crud.ConsultaMedicaRepository;
import com.example.demo.infraestructure.entity.ConsultaMedica;
import com.example.demo.infraestructure.mapper.ConsultaMapper;
import com.example.demo.domain.dto.MedicalConsultationDTO;
import com.example.demo.domain.repository.IConsultaMedica;

@Repository
public class ConsultaMedicaImpl implements IConsultaMedica {
    @Autowired
    private ConsultaMedicaRepository consultaRepository;

    @Autowired
    private ConsultaMapper consultaMapper;

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
    public MedicalConsultationDTO saveMedicalConsultation(MedicalConsultationDTO dto){
        ConsultaMedica consultaMedica = consultaMapper.toConsultaMedica(dto);
        return consultaMapper.toMedicalConsultationDTO(consultaRepository.save(consultaMedica));
    }

    @Override
    public MedicalConsultationDTO getMedicalConsultationByAppointmentId(Long id){
        ConsultaMedica consultaMedica = consultaRepository.findByCitaId(id);
        return consultaMapper.toMedicalConsultationDTO(consultaMedica);
    }

    @Override
    public MedicalConsultationDTO getMedicalConsultationByPatientId(Long id){
        ConsultaMedica consultaMedica = consultaRepository.findByPacienteId(id);
        return consultaMapper.toMedicalConsultationDTO(consultaMedica);
    }
}
