package org.example.repositories;

import org.example.dao.Appointment;
import org.example.dao.Doctor;
import org.example.dao.Report;
import org.example.dao.User;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class UserRepositories implements BasicRepository<User, Long>{
    private final Session session;
    private final Transaction transaction;

    public UserRepositories(Session session, Transaction transaction) {
        this.session = session;
        this.transaction = transaction;
    }

    @Override
    public User createOrUpdate(User entity) {
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
    public User getById(Long id) {
        return session.find(User.class, id);
    }

    @Override
    public void deleteById(Long id) {
        try {
            User user = session.find(User.class, id);
            session.remove(user);
            transaction.commit();
        } catch (Exception e){
            transaction.rollback();
            e.printStackTrace();
        }
    }

    @Override
    public List<User> getAll() {
        String getAll = "select m from User m";
        Query<User> findAll = session.createQuery(getAll, User.class);
        return  findAll.getResultList();
    }

    public User getByUsername(String username){
        String query = "select u from User u where u.username = ?1";
        Query<User> getByUsername = session.createQuery(query, User.class);
        getByUsername.setParameter(1, username);
        return getByUsername.getSingleResult();
    }
}
