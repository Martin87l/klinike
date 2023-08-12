package org.example.dao;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name="appointment")

public class Appointment {

    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    @Column(name = "appointmentid")
    private  Long appointmentId;
    @Column(name="appointmentpatient_name")
    private String patient_name;
    @Column(name="appointmentnote")
    private String appointmentpatientNote;
    @Column(name="appointmentstatus")
    private String appointmentStatus;
    @Column(name="appointmentbegin_at")
    private LocalDateTime beginAt;
    @Column(name="appointmentends_at")
    private LocalDateTime endsAt;
    @ManyToOne
    @JoinColumn (name = "doctor_id")
    private  Doctor doctor;

    @OneToOne(mappedBy = "appointment")
    private  Report report;

    public Long getAppointmentId() {
        return appointmentId;
    }

    public void setAppointmentId(Long appointmentId) {
        this.appointmentId = appointmentId;
    }

    public String getPatient_name() {
        return patient_name;
    }

    public void setPatient_name(String patient_name) {
        this.patient_name = patient_name;
    }

    public String getAppointmentpatientNote() {
        return appointmentpatientNote;
    }

    public void setAppointmentpatientNote(String appointmentpatientNote) {
        this.appointmentpatientNote = appointmentpatientNote;
    }

    public String getAppointmentStatus() {
        return appointmentStatus;
    }

    public void setAppointmentStatus(String appointmentStatus) {
        this.appointmentStatus = appointmentStatus;
    }

    public LocalDateTime getBeginAt() {
        return beginAt;
    }

    public void setBeginAt(LocalDateTime beginAt) {
        this.beginAt = beginAt;
    }

    public LocalDateTime getEndsAt() {
        return endsAt;
    }

    public void setEndsAt(LocalDateTime endsAt) {
        this.endsAt = endsAt;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public Report getReport() {
        return report;
    }

    public void setReport(Report report) {
        this.report = report;
    }

    public Appointment(Long appointmentId, String patient_name, String appointmentpatientNote, String appointmentStatus, LocalDateTime beginAt, LocalDateTime endsAt, Doctor doctor, Report report) {
        this.appointmentId = appointmentId;
        this.patient_name = patient_name;
        this.appointmentpatientNote = appointmentpatientNote;
        this.appointmentStatus = appointmentStatus;
        this.beginAt = beginAt;
        this.endsAt = endsAt;
        this.doctor = doctor;
        this.report = report;
    }

    @Override
    public String toString() {
        return "Appointment{" +
                "appointmentId=" + appointmentId +
                ", patient_name='" + patient_name + '\'' +
                ", appointmentpatientNote='" + appointmentpatientNote + '\'' +
                ", appointmentStatus='" + appointmentStatus + '\'' +
                ", beginAt=" + beginAt +
                ", endsAt=" + endsAt +
                ", doctor=" + doctor +
                ", report=" + report +
                '}';
    }

    public Appointment (){

    }
}
