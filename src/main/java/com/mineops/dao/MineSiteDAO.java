package com.mineops.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import com.mineops.entity.MineSite;
import com.mineops.util.HibernateUtil;

public class MineSiteDAO {

    public void insert(MineSite mine) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        session.persist(mine);
        tx.commit();
        session.close();
    }

    public void updateStatus(int mineId, String status) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        MineSite mine = session.get(MineSite.class, mineId);
        if (mine != null) {
            mine.setStatus(status);
            session.merge(mine);
        }
        tx.commit();
        session.close();
    }

    public MineSite getById(int mineId) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        MineSite mine = session.get(MineSite.class, mineId);
        session.close();
        return mine;
    }

    public void delete(int mineId) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        MineSite mine = session.get(MineSite.class, mineId);
        if (mine != null) {
            session.remove(mine);
        }
        tx.commit();
        session.close();
    }
}
