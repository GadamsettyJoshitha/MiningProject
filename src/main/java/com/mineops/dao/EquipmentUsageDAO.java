package com.mineops.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import com.mineops.entity.EquipmentUsage;
import com.mineops.util.HibernateUtil;

public class EquipmentUsageDAO {

    public void insert(EquipmentUsage u) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        session.persist(u);
        tx.commit();
        session.close();
    }

    public EquipmentUsage getById(int usageId) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        EquipmentUsage u = session.get(EquipmentUsage.class, usageId);
        session.close();
        return u;
    }

    public void delete(int usageId) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        EquipmentUsage u = session.get(EquipmentUsage.class, usageId);
        if (u != null) {
            session.remove(u);
        }
        tx.commit();
        session.close();
    }
}
