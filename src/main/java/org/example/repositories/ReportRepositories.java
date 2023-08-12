package org.example.repositories;

import org.example.dao.Report;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;
public class ReportRepositories implements BasicRepository<Report, Long> {
    private final Session session;
    private final Transaction transaction;

    public ReportRepositories(Session session, Transaction transaction) {
        this.session = session;
        this.transaction = transaction;
    }
    @Override
    public Report createOrUpdate(Report entity) {
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
    public Report getById(Long id) {
        return session.find(Report.class, id);
    }
    @Override
    public void deleteById(Long id) {
        try {
            Report report = session.find(Report.class, id);
            session.remove(report);
            transaction.commit();
        } catch (Exception e){
            transaction.rollback();
            e.printStackTrace();
        }
    }
    @Override
    public List<Report> getAll() {
        String getAll = "select m from Report m";
        Query<Report> findAll = session.createQuery(getAll, Report.class);
        return  findAll.getResultList();
    }
}
