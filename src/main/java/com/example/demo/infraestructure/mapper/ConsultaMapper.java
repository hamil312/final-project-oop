package com.example.demo.infraestructure.mapper;

import java.util.List;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import com.example.demo.domain.dto.MedicalConsultationDTO;
import com.example.demo.infraestructure.entity.ConsultaMedica;

@Mapper(componentModel = "spring")
public interface ConsultaMapper {
    
    @Mappings({
        @Mapping(source = "id", target = "id"),
        @Mapping(source = "fecha", target = "date"),
        @Mapping(source = "diagnostico", target = "diagnosis"),
        @Mapping(source = "prescripcion", target = "prescription"),
        @Mapping(source = "observaciones", target ="observations"),
        @Mapping(source = "medicoId", target = "medicId"),
        @Mapping(source = "citaId", target = "appointmentId"),
        @Mapping(source = "pacienteId", target = "patientId"),
        @Mapping(source = "medicoNombre", target = "medicName"),
        @Mapping(source = "pacienteNombre", target = "patientName")
    })
    MedicalConsultationDTO toMedicalConsultationDTO(ConsultaMedica consultaMedica);
    List<MedicalConsultationDTO> toMedicalConsultationsDTO(List<ConsultaMedica> consultasMedicas);

    @InheritInverseConfiguration
    ConsultaMedica toConsultaMedica(MedicalConsultationDTO medicalConsultationDTO);
    List<ConsultaMedica> toConsultasMedicas(List<MedicalConsultationDTO> medicalConsultationsDTO);
}
