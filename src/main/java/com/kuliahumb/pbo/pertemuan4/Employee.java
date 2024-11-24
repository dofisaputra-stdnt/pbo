package com.kuliahumb.pbo.pertemuan4;

import java.util.Date;
import java.util.UUID;

public class Employee extends Person {

    private UUID employeeId = UUID.randomUUID();
    private String phoneNumber;
    private Date hireDate;
    private int salary;
    private int commissionPct;
    private int bonus;

    public Employee(String firstName, String lastName, String email, String phoneNumber, Date hireDate, int salary, int commissionPct, int bonus) {
        super(firstName, lastName, email);
        this.phoneNumber = phoneNumber;
        this.hireDate = hireDate;
        this.salary = salary;
        this.commissionPct = commissionPct;
        this.bonus = bonus;
    }

    public UUID getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(UUID employeeId) {
        this.employeeId = employeeId;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Date getHireDate() {
        return hireDate;
    }

    public void setHireDate(Date hireDate) {
        this.hireDate = hireDate;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public int getCommissionPct() {
        return commissionPct;
    }

    public void setCommissionPct(int commissionPct) {
        this.commissionPct = commissionPct;
    }

    public int getBonus() {
        return bonus;
    }

    public void setBonus(int bonus) {
        this.bonus = bonus;
    }

}
