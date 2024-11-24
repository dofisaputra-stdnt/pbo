package com.kuliahumb.pbo.pertemuan5.tugas;

public class Mahasiswa extends Person {

    private String major;

    public Mahasiswa(String name, String id, String major) {
        super(name, id);
        this.major = major;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

}
