package com.mineops.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import com.mineops.entity.SafetyIncident;
import com.mineops.util.HibernateUtil;

public class SafetyIncidentDAO {

    public void insert(SafetyIncident s) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        session.persist(s);
        tx.commit();
        session.close();
    }

    public void closeIncident(int incidentId) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        SafetyIncident s = session.get(SafetyIncident.class, incidentId);
        if (s != null) {
            s.setStatus("CLOSED");
            session.merge(s);
        }
        tx.commit();
        session.close();
    }

    public SafetyIncident getById(int incidentId) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        SafetyIncident s = session.get(SafetyIncident.class, incidentId);
        session.close();
        return s;
    }

    public void delete(int incidentId) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        SafetyIncident s = session.get(SafetyIncident.class, incidentId);
        if (s != null) {
            session.remove(s);
        }
        tx.commit();
        session.close();
    }
}
