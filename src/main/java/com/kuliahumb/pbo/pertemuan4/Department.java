package com.kuliahumb.pbo.pertemuan4;

import java.util.UUID;

public class Department {

    private UUID departmentId = UUID.randomUUID();
    private String departmentName;

    public Department(String departmentName) {
        this.departmentName = departmentName;
    }

    public UUID getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(UUID departmentId) {
        this.departmentId = departmentId;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

}
