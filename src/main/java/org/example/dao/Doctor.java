package org.example.dao;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name= "doctor")

public class Doctor {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    @Column(name = "doctor_id")
    private  Long doctorId;
    @Column( name = "username")
    private  String userName;
    @Column( name = "name")
    private  String name;
    @Column( name = "specialization")
    private  String specialization;
    @OneToMany(mappedBy = "doctor")
    private List<Appointment> appointments;

    public Long getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(Long doctorId) {
        this.doctorId = doctorId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public List<Appointment> getAppointments() {
        return appointments;
    }

    public void setAppointments(List<Appointment> appointments) {
        this.appointments = appointments;
    }

    public Doctor(Long doctorId, String userName, String name, String specialization, List<Appointment> appointments) {
        this.doctorId = doctorId;
        this.userName = userName;
        this.name = name;
        this.specialization = specialization;
        this.appointments = appointments;
    }

    @Override
    public String toString() {
        return "Doctor{" +
                "doctorId=" + doctorId +
                ", userName='" + userName + '\'' +
                ", name='" + name + '\'' +
                ", specialization='" + specialization + '\'' +
                ", appointments=" + appointments +
                '}';
    }
    public Doctor () {

    }
}
