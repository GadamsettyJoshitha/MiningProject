package com.mineops.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import com.mineops.entity.Worker;
import com.mineops.util.HibernateUtil;

public class WorkerDAO {

    public void insert(Worker w) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        session.persist(w);
        tx.commit();
        session.close();
    }

    public Worker getById(int workerId) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Worker w = session.get(Worker.class, workerId);
        session.close();
        return w;
    }

    public void delete(int workerId) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        Worker w = session.get(Worker.class, workerId);
        if (w != null) {
            session.remove(w);
        }
        tx.commit();
        session.close();
    }
}
