package com.kuliahumb.pbo.pertemuan4;

import java.util.Date;

public class EmployeeTest {

    public static void main(String[] args) {
        Employee employee = new Employee("John", "Doe", "johndoe@gmail.com", "081234567890", new Date(), 10000000, 10, 1000000);
        System.out.println("Employee ID: " + employee.getEmployeeId());
        System.out.println("First Name: " + employee.getFirstName());
        System.out.println("Last Name: " + employee.getLastName());
        System.out.println("Email: " + employee.getEmail());
        System.out.println("Phone Number: " + employee.getPhoneNumber());
        System.out.println("Hire Date: " + employee.getHireDate());
        System.out.println("Salary: " + employee.getSalary());
        System.out.println("Commission Percentage: " + employee.getCommissionPct());
        System.out.println("Bonus: " + employee.getBonus());

        Department department = new Department("IT");
        System.out.println("\nDepartment ID: " + department.getDepartmentId());
        System.out.println("Department Name: " + department.getDepartmentName());
    }

}
