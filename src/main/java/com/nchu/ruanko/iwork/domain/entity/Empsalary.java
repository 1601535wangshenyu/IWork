package com.nchu.ruanko.iwork.domain.entity;

public class Empsalary {
    private String empsalaryUid;
    private User user;
    private Salary salary;

    public String getEmpsalaryUid() {
        return empsalaryUid;
    }

    public void setEmpsalaryUid(String empsalaryUid) {
        this.empsalaryUid = empsalaryUid;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Salary getSalary() {
        return salary;
    }

    public void setSalary(Salary salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Empsalary{" +
                "empsalaryUid='" + empsalaryUid + '\'' +
                ", user=" + user +
                ", salary=" + salary +
                '}';
    }
}
