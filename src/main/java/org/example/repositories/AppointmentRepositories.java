package org.example.repositories;

import org.example.dao.Appointment;
import org.example.dao.Doctor;
import org.example.dao.Report;
import org.example.dao.User;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.time.LocalDateTime;
import java.util.List;
public class AppointmentRepositories implements BasicRepository<Appointment, Long>
{
    private final Session session;
    private final Transaction transaction;
    public AppointmentRepositories(Session session, Transaction transaction) {
        this.session = session;
        this.transaction = transaction;
    }


    @Override
    public Appointment createOrUpdate(Appointment entity) {
        try {
            session.persist(entity);
            transaction.commit();
            return entity;
        } catch (Exception e){
            transaction.rollback();
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void deleteById(Long id) {
        try {
            session.remove(getById(id));
        } catch (Exception e){
            e.printStackTrace();
        }

    }
    @Override
    public List<Appointment> getAll() {
        String getAll = "select appointment from Appointment appointment";
        Query<Appointment> appointmentQueryQuery = session.createQuery(getAll, Appointment.class);
        return appointmentQueryQuery.getResultList();
    }

    @Override
    public Appointment getById(Long id) {
        return session.get(Appointment.class, id);
    }
    public List<Appointment> getAllByDoctorAndAfterNow(Long id){
        String query = "select appointment from Appointment appointment left join fetch " +
                "appointment.doctor doctor where doctor.doctorId = :id and appointment.beginA> :now";
        Query<Appointment> getAllByDoctor = session.createQuery(query, Appointment.class);
        getAllByDoctor.setParameter("id", id);
        getAllByDoctor.setParameter("now", LocalDateTime.now());
        return  getAllByDoctor.getResultList();

    }
}
