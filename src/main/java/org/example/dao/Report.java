package org.example.dao;

import jakarta.persistence.*;

@Entity
@Table (name = "report")
public class Report {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    @Column (name = "id")
    private  Long reportId;
    @Column( name = "description")
    private  String reportDescription;

    @OneToOne()
    @JoinColumn (name = "appointment_id")
    private Appointment appointment;

    public Long getReportId() {
        return reportId;
    }

    public void setReportId(Long reportId) {
        this.reportId = reportId;
    }

    public String getReportDescription() {
        return reportDescription;
    }

    public void setReportDescription(String reportDescription) {
        this.reportDescription = reportDescription;
    }

    public Appointment getAppointment() {
        return appointment;
    }

    public void setAppointment(Appointment appointment) {
        this.appointment = appointment;
    }

    public Report(Long reportId, String reportDescription, Appointment appointment) {
        this.reportId = reportId;
        this.reportDescription = reportDescription;
        this.appointment = appointment;
    }

    @Override
    public String toString() {
        return "Report{" +
                "reportId=" + reportId +
                ", reportDescription='" + reportDescription + '\'' +
                ", appointment=" + appointment +
                '}';
    }
    public  Report () {

    }
}
