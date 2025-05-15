package com.example.demo.infraestructure.entity;

import java.time.LocalDateTime;

import jakarta.persistence.*;

@Entity
@Table(name = "consultas_medicas")
public class ConsultaMedica {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    private LocalDateTime fecha;
    private String diagnostico;
    private String prescripcion;
    private String observaciones;
    private Long medicoId;
    private String medicoNombre;
    private Long citaId;
    private Long pacienteId;
    private String pacienteNombre;

    public ConsultaMedica() {
    }

    public ConsultaMedica(LocalDateTime fecha, String diagnostico, String prescripcion, String observaciones, Long medicoId, Long citaId, Long pacienteId, String pacienteNombre, String medicoNombre) {
        this.fecha = fecha;
        this.diagnostico = diagnostico;
        this.prescripcion = prescripcion;
        this.observaciones = observaciones;
        this.medicoId = medicoId;
        this.medicoNombre = medicoNombre;
        this.citaId = citaId;
        this.pacienteId = pacienteId;
        this.pacienteNombre = pacienteNombre;
    }

    public Long getPacienteId() {
        return pacienteId;
    }

    public void setPacienteId(Long pacienteId) {
        this.pacienteId = pacienteId;
    }
    
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public LocalDateTime getFecha() {
        return fecha;
    }
    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }
    public String getDiagnostico() {
        return diagnostico;
    }
    public void setDiagnostico(String diagnostico) {
        this.diagnostico = diagnostico;
    }
    public String getPrescripcion() {
        return prescripcion;
    }
    public void setPrescripcion(String prescripcion) {
        this.prescripcion = prescripcion;
    }
    public String getObservaciones() {
        return observaciones;
    }
    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }
    public Long getMedicoId() {
        return medicoId;
    }
    public void setMedicoId(Long medicoId) {
        this.medicoId = medicoId;
    }
    public Long getCitaId() {
        return citaId;
    }
    public void setCitaId(Long citaId) {
        this.citaId = citaId;
    }

    public String getMedicoNombre() {
        return medicoNombre;
    }

    public void setMedicoNombre(String medicoNombre) {
        this.medicoNombre = medicoNombre;
    }

    public String getPacienteNombre() {
        return pacienteNombre;
    }

    public void setPacienteNombre(String pacienteNombre) {
        this.pacienteNombre = pacienteNombre;
    }

    
}
