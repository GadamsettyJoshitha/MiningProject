package com.mineops.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import com.mineops.entity.ShiftLog;
import com.mineops.util.HibernateUtil;

public class ShiftLogDAO {

    public void insert(ShiftLog s) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        session.persist(s);
        tx.commit();
        session.close();
    }

    public ShiftLog getById(int shiftId) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        ShiftLog s = session.get(ShiftLog.class, shiftId);
        session.close();
        return s;
    }

    public void delete(int shiftId) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        ShiftLog s = session.get(ShiftLog.class, shiftId);
        if (s != null) {
            session.remove(s);
        }
        tx.commit();
        session.close();
    }
}
