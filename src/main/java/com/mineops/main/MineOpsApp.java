package com.mineops.main;

import org.hibernate.Session;
import org.hibernate.Transaction;
import java.util.Date;

import com.mineops.entity.*;
import com.mineops.util.HibernateUtil;

public class MineOpsApp {

    public static void main(String[] args) {

        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();

        MineSite m1 = new MineSite();
        m1.setMineId(1);
        m1.setName("Alpha Mine");
        m1.setLocation("Odisha");
        m1.setStatus("ACTIVE");
        session.persist(m1);

        Equipment e1 = new Equipment();
        e1.setEquipmentId(101);
        e1.setMineId(1);
        e1.setName("Drill");
        e1.setType("Machine");
        e1.setStatus("WORKING");
        session.persist(e1);

        Worker w1 = new Worker();
        w1.setWorkerId(201);
        w1.setMineId(1);
        w1.setName("Ramesh");
        w1.setRole("Supervisor");
        w1.setPhone("9876543210");
        session.persist(w1);

        ShiftLog s1 = new ShiftLog();
        s1.setShiftId(301);
        s1.setMineId(1);
        s1.setShiftDate(new Date());
        s1.setShiftType("DAY");
        s1.setSupervisorId(201);
        session.persist(s1);

        ProductionLog p1 = new ProductionLog();
        p1.setProdId(401);
        p1.setMineId(1);
        p1.setShiftId(301);
        p1.setLogDate(new Date());
        p1.setTonnes(1200);
        p1.setGrade(85);
        session.persist(p1);

        EquipmentUsage u1 = new EquipmentUsage();
        u1.setUsageId(501);
        u1.setMineId(1);
        u1.setEquipmentId(101);
        u1.setUsageDate(new Date());
        u1.setRunningHours(8);
        u1.setBreakdown("N");
        u1.setDowntimeHours(0);
        session.persist(u1);

        SafetyIncident si1 = new SafetyIncident();
        si1.setIncidentId(601);
        si1.setMineId(1);
        si1.setEquipmentId(101);
        si1.setWorkerId(201);
        si1.setIncidentDate(new Date());
        si1.setType("Minor Injury");
        si1.setSeverity(2);
        si1.setCost(5000);
        si1.setStatus("OPEN");
        session.persist(si1);

        si1.setStatus("CLOSED");
        session.merge(si1);

        tx.commit();
        session.close();
        HibernateUtil.shutdown();
    }
}
