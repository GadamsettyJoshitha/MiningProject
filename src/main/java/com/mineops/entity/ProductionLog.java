package com.mineops.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import java.util.Date;

@Entity
public class ProductionLog {

    @Id
    private int prodId;
    private int mineId;
    private int shiftId;
    private Date logDate;
    private double tonnes;
    private double grade;

    public int getProdId() { return prodId; }
    public void setProdId(int prodId) { this.prodId = prodId; }
    public int getMineId() { return mineId; }
    public void setMineId(int mineId) { this.mineId = mineId; }
    public int getShiftId() { return shiftId; }
    public void setShiftId(int shiftId) { this.shiftId = shiftId; }
    public Date getLogDate() { return logDate; }
    public void setLogDate(Date logDate) { this.logDate = logDate; }
    public double getTonnes() { return tonnes; }
    public void setTonnes(double tonnes) { this.tonnes = tonnes; }
    public double getGrade() { return grade; }
    public void setGrade(double grade) { this.grade = grade; }
}
