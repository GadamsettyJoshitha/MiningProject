package com.mineops.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import java.util.Date;

@Entity
public class EquipmentUsage {

    @Id
    private int usageId;
    private int mineId;
    private int equipmentId;
    private Date usageDate;
    private double runningHours;
    private String breakdown;
    private double downtimeHours;

    public int getUsageId() { return usageId; }
    public void setUsageId(int usageId) { this.usageId = usageId; }
    public int getMineId() { return mineId; }
    public void setMineId(int mineId) { this.mineId = mineId; }
    public int getEquipmentId() { return equipmentId; }
    public void setEquipmentId(int equipmentId) { this.equipmentId = equipmentId; }
    public Date getUsageDate() { return usageDate; }
    public void setUsageDate(Date usageDate) { this.usageDate = usageDate; }
    public double getRunningHours() { return runningHours; }
    public void setRunningHours(double runningHours) { this.runningHours = runningHours; }
    public String getBreakdown() { return breakdown; }
    public void setBreakdown(String breakdown) { this.breakdown = breakdown; }
    public double getDowntimeHours() { return downtimeHours; }
    public void setDowntimeHours(double downtimeHours) { this.downtimeHours = downtimeHours; }
}
