package org.example.repositories;

import org.example.dao.Appointment;
import org.example.dao.Doctor;
import org.example.dao.Report;
import org.example.dao.User;

import java.util.List;

public interface BasicRepository<E, I> {
    List<E> getAll();
    E getById(I id);
    E createOrUpdate(E entity);
    void deleteById(I id);

}
