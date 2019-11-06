package com.nchu.ruanko.iwork.domain.entity;

import java.sql.Timestamp;

public class Salary {
    private String salaryUid;
    private int basicSalary;
    private int bonus;
    private int lunchSalary;
    private int trafficSalary;
    private int allSalary;
    private int pensionBase;
    private float pensionPer;
    private Timestamp createDate;
    private int medicalBase;
    private float medialPer;
    private int accumulationFundBase;
    private float accumulationFundPer;
    private String name;

    public String getSalaryUid() {
        return salaryUid;
    }

    public void setSalaryUid(String salaryUid) {
        this.salaryUid = salaryUid;
    }

    public int getBasicSalary() {
        return basicSalary;
    }

    public void setBasicSalary(int basicSalary) {
        this.basicSalary = basicSalary;
    }

    public int getBonus() {
        return bonus;
    }

    public void setBonus(int bonus) {
        this.bonus = bonus;
    }

    public int getLunchSalary() {
        return lunchSalary;
    }

    public void setLunchSalary(int lunchSalary) {
        this.lunchSalary = lunchSalary;
    }

    public int getTrafficSalary() {
        return trafficSalary;
    }

    public void setTrafficSalary(int trafficSalary) {
        this.trafficSalary = trafficSalary;
    }

    public int getAllSalary() {
        return allSalary;
    }

    public void setAllSalary(int allSalary) {
        this.allSalary = allSalary;
    }

    public int getPensionBase() {
        return pensionBase;
    }

    public void setPensionBase(int pensionBase) {
        this.pensionBase = pensionBase;
    }

    public float getPensionPer() {
        return pensionPer;
    }

    public void setPensionPer(float pensionPer) {
        this.pensionPer = pensionPer;
    }

    public Timestamp getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Timestamp createDate) {
        this.createDate = createDate;
    }

    public int getMedicalBase() {
        return medicalBase;
    }

    public void setMedicalBase(int medicalBase) {
        this.medicalBase = medicalBase;
    }

    public float getMedialPer() {
        return medialPer;
    }

    public void setMedialPer(float medialPer) {
        this.medialPer = medialPer;
    }

    public int getAccumulationFundBase() {
        return accumulationFundBase;
    }

    public void setAccumulationFundBase(int accumulationFundBase) {
        this.accumulationFundBase = accumulationFundBase;
    }

    public float getAccumulationFundPer() {
        return accumulationFundPer;
    }

    public void setAccumulationFundPer(float accumulationFundPer) {
        this.accumulationFundPer = accumulationFundPer;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Salary{" +
                "salaryUid='" + salaryUid + '\'' +
                ", basicSalary=" + basicSalary +
                ", bonus=" + bonus +
                ", lunchSalary=" + lunchSalary +
                ", trafficSalary=" + trafficSalary +
                ", allSalary=" + allSalary +
                ", pensionBase=" + pensionBase +
                ", pensionPer=" + pensionPer +
                ", createDate=" + createDate +
                ", medicalBase=" + medicalBase +
                ", medialPer=" + medialPer +
                ", accumulationFundBase=" + accumulationFundBase +
                ", accumulationFundPer=" + accumulationFundPer +
                ", name='" + name + '\'' +
                '}';
    }
}
