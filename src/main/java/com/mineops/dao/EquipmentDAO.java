package com.mineops.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import com.mineops.entity.Equipment;
import com.mineops.util.HibernateUtil;

public class EquipmentDAO {

    public void insert(Equipment e) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        session.persist(e);
        tx.commit();
        session.close();
    }

    public void transfer(int equipmentId, int newMineId) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        Equipment e = session.get(Equipment.class, equipmentId);
        if (e != null) {
            e.setMineId(newMineId);
            session.merge(e);
        }
        tx.commit();
        session.close();
    }

    public Equipment getById(int equipmentId) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Equipment e = session.get(Equipment.class, equipmentId);
        session.close();
        return e;
    }

    public void delete(int equipmentId) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        Equipment e = session.get(Equipment.class, equipmentId);
        if (e != null) {
            session.remove(e);
        }
        tx.commit();
        session.close();
    }
}
