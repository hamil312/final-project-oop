package com.example.demo.domain.dto;

import java.time.LocalDateTime;

public class MedicalConsultationDTO {
    private Long id;
    private LocalDateTime date;
    private String diagnosis;
    private String prescription;
    private String observations;
    private Long medicId;
    private String medicName;
    private Long appointmentId;
    private Long patientId;
    private String patientName;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public LocalDateTime getDate() {
        return date;
    }
    public void setDate(LocalDateTime date) {
        this.date = date;
    }
    public String getDiagnosis() {
        return diagnosis;
    }
    public void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
    }
    public String getPrescription() {
        return prescription;
    }
    public void setPrescription(String prescription) {
        this.prescription = prescription;
    }
    public String getObservations() {
        return observations;
    }
    public void setObservations(String observations) {
        this.observations = observations;
    }
    public Long getMedicId() {
        return medicId;
    }
    public void setMedicId(Long medicId) {
        this.medicId = medicId;
    }
    public Long getAppointmentId() {
        return appointmentId;
    }
    public void setAppointmentId(Long appointmentId) {
        this.appointmentId = appointmentId;
    }
    public Long getPatientId() {
        return patientId;
    }
    public void setPatientId(Long patientId) {
        this.patientId = patientId;
    }
    public String getMedicName() {
        return medicName;
    }
    public void setMedicName(String medicName) {
        this.medicName = medicName;
    }
    public String getPatientName() {
        return patientName;
    }
    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    
}
