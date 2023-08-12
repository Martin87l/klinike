package org.example.repositories;

import org.example.dao.Appointment;
import org.example.dao.Doctor;
import org.example.dao.Report;
import org.example.dao.User;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class DoctorRepositories implements BasicRepository<Doctor, Long> {
    private final Session session;
    private final Transaction transaction;

    public DoctorRepositories(Session session, Transaction transaction) {
        this.session = session;
        this.transaction = transaction;
    }

    @Override
    public Doctor createOrUpdate(Doctor entity) {
        try {
            session.persist(entity);
            transaction.commit();
            return entity;
        } catch (Exception e) {
            transaction.rollback();
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void deleteById(Long id) {
        try {
            session.remove(getById(id));
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public List<Doctor> getAll() {
        String getAll = "select doctor from Doctor doctor";
        Query<Doctor> getAllDoctors = session.createQuery(getAll, Doctor.class);
        return getAllDoctors.getResultList();
    }

    @Override
    public Doctor getById(Long id) {
        return session.get(Doctor.class, id);
    }

    public Doctor getByUsername(String username) {
        String query = "select u from Doctor u where u.username = ?1";
        Query<Doctor> getByUsername = session.createQuery(query, Doctor.class);
        getByUsername.setParameter(1, username);
        return getByUsername.getSingleResult();
    }

    public List<Doctor> getBySpecialization(String spec) {
        String query = "select d from Doctor d where d.specialization = :spec";
        Query<Doctor> getBySpecialization = session.createQuery(query, Doctor.class);
        getBySpecialization.setParameter("spec", spec);
        return getBySpecialization.getResultList();

    }

}
