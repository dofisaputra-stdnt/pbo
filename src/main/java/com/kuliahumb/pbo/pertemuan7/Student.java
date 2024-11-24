package com.kuliahumb.pbo.pertemuan7;

public class Student {

    private String nim;
    private String name;
    private String major;
    private Integer dob;

    public Student(String nim, String name, String major, Integer dob) {
        this.nim = nim;
        this.name = name;
        this.major = major;
        this.dob = dob;
    }

    public String getNim() {
        return nim;
    }

    public void setNim(String nim) {
        this.nim = nim;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public Integer getDob() {
        return dob;
    }

    public void setDob(Integer dob) {
        this.dob = dob;
    }

}
