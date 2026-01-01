package com.mineops.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import com.mineops.entity.ProductionLog;
import com.mineops.util.HibernateUtil;

public class ProductionLogDAO {

    public void insert(ProductionLog p) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        session.persist(p);
        tx.commit();
        session.close();
    }

    public ProductionLog getById(int prodId) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        ProductionLog p = session.get(ProductionLog.class, prodId);
        session.close();
        return p;
    }

    public void delete(int prodId) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        ProductionLog p = session.get(ProductionLog.class, prodId);
        if (p != null) {
            session.remove(p);
        }
        tx.commit();
        session.close();
    }
}
