package com.example.demo.infraestructure.mapper;

import com.example.demo.domain.dto.MedicalConsultationDTO;
import com.example.demo.infraestructure.entity.ConsultaMedica;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-05-22T18:20:52-0500",
    comments = "version: 1.6.3, compiler: javac, environment: Java 18.0.2.1 (Oracle Corporation)"
)
@Component
public class ConsultaMapperImpl implements ConsultaMapper {

    @Override
    public MedicalConsultationDTO toMedicalConsultationDTO(ConsultaMedica consultaMedica) {
        if ( consultaMedica == null ) {
            return null;
        }

        MedicalConsultationDTO medicalConsultationDTO = new MedicalConsultationDTO();

        medicalConsultationDTO.setId( consultaMedica.getId() );
        medicalConsultationDTO.setDate( consultaMedica.getFecha() );
        medicalConsultationDTO.setDiagnosis( consultaMedica.getDiagnostico() );
        medicalConsultationDTO.setPrescription( consultaMedica.getPrescripcion() );
        medicalConsultationDTO.setObservations( consultaMedica.getObservaciones() );
        medicalConsultationDTO.setMedicId( consultaMedica.getMedicoId() );
        medicalConsultationDTO.setAppointmentId( consultaMedica.getCitaId() );
        medicalConsultationDTO.setPatientId( consultaMedica.getPacienteId() );
        medicalConsultationDTO.setMedicName( consultaMedica.getMedicoNombre() );
        medicalConsultationDTO.setPatientName( consultaMedica.getPacienteNombre() );

        return medicalConsultationDTO;
    }

    @Override
    public List<MedicalConsultationDTO> toMedicalConsultationsDTO(List<ConsultaMedica> consultasMedicas) {
        if ( consultasMedicas == null ) {
            return null;
        }

        List<MedicalConsultationDTO> list = new ArrayList<MedicalConsultationDTO>( consultasMedicas.size() );
        for ( ConsultaMedica consultaMedica : consultasMedicas ) {
            list.add( toMedicalConsultationDTO( consultaMedica ) );
        }

        return list;
    }

    @Override
    public ConsultaMedica toConsultaMedica(MedicalConsultationDTO medicalConsultationDTO) {
        if ( medicalConsultationDTO == null ) {
            return null;
        }

        ConsultaMedica consultaMedica = new ConsultaMedica();

        consultaMedica.setId( medicalConsultationDTO.getId() );
        consultaMedica.setFecha( medicalConsultationDTO.getDate() );
        consultaMedica.setDiagnostico( medicalConsultationDTO.getDiagnosis() );
        consultaMedica.setPrescripcion( medicalConsultationDTO.getPrescription() );
        consultaMedica.setObservaciones( medicalConsultationDTO.getObservations() );
        consultaMedica.setMedicoId( medicalConsultationDTO.getMedicId() );
        consultaMedica.setCitaId( medicalConsultationDTO.getAppointmentId() );
        consultaMedica.setPacienteId( medicalConsultationDTO.getPatientId() );
        consultaMedica.setMedicoNombre( medicalConsultationDTO.getMedicName() );
        consultaMedica.setPacienteNombre( medicalConsultationDTO.getPatientName() );

        return consultaMedica;
    }

    @Override
    public List<ConsultaMedica> toConsultasMedicas(List<MedicalConsultationDTO> medicalConsultationsDTO) {
        if ( medicalConsultationsDTO == null ) {
            return null;
        }

        List<ConsultaMedica> list = new ArrayList<ConsultaMedica>( medicalConsultationsDTO.size() );
        for ( MedicalConsultationDTO medicalConsultationDTO : medicalConsultationsDTO ) {
            list.add( toConsultaMedica( medicalConsultationDTO ) );
        }

        return list;
    }
}
