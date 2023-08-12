package org.example.config;

import org.example.dao.Appointment;
import org.example.dao.Doctor;
import org.example.dao.Report;
import org.example.dao.User;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class HibernateUtils {
    private  static SessionFactory sessionFactory;
    public static SessionFactory getSessionFactory(){
        if(sessionFactory == null){
            Configuration configuration = new Configuration();
            ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                    .applySettings(configuration.getProperties()).build();
            configuration.addAnnotatedClass(Appointment.class);
            configuration.addAnnotatedClass(Doctor.class);
            configuration.addAnnotatedClass(Report.class);
            configuration.addAnnotatedClass(User.class);

            sessionFactory = configuration.buildSessionFactory(serviceRegistry);
        }
        return sessionFactory;
    }
}
