package com.example.demo.domain.dto;

public class AppointmentDTO {
    private Long id;
    private String date;
    private Long patientId;
    private Long medicId;
    
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getDate() {
        return date;
    }
    public void setDate(String date) {
        this.date = date;
    }
    public Long getPatientId() {
        return patientId;
    }
    public void setPatientId(Long patientId) {
        this.patientId = patientId;
    }
    public Long getMedicId() {
        return medicId;
    }
    public void setMedicId(Long medicId) {
        this.medicId = medicId;
    }

    
}