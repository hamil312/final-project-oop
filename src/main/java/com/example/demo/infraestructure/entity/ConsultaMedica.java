package com.example.demo.infraestructure.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "consultas_medicas")
public class ConsultaMedica {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    private String fecha;
    private String diagnostico;
    private String prescripcion;
    private String observaciones;
    private Long medicoId;
    private Long citaId;
    private Long pacienteId;

    public ConsultaMedica() {
    }

    public ConsultaMedica(String fecha, String diagnostico, String prescripcion, String observaciones, Long medicoId, Long citaId, Long pacienteId) {
        this.fecha = fecha;
        this.diagnostico = diagnostico;
        this.prescripcion = prescripcion;
        this.observaciones = observaciones;
        this.medicoId = medicoId;
        this.citaId = citaId;
        this.pacienteId = pacienteId;
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
    public String getFecha() {
        return fecha;
    }
    public void setFecha(String fecha) {
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
    public Long getmedicoId() {
        return medicoId;
    }
    public void setmedicoId(Long medicoId) {
        this.medicoId = medicoId;
    }
    public Long getCitaId() {
        return citaId;
    }
    public void setCitaId(Long citaId) {
        this.citaId = citaId;
    }

    

}
