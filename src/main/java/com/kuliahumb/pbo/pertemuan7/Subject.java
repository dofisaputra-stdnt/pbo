package com.kuliahumb.pbo.pertemuan7;

public class Subject {

    private String subjectCode;
    private String subjectName;
    private int sks;

    public Subject(String subjectCode, String subjectName, int sks) {
        this.subjectCode = subjectCode;
        this.subjectName = subjectName;
        this.sks = sks;
    }

    public String getSubjectCode() {
        return subjectCode;
    }

    public void setSubjectCode(String subjectCode) {
        this.subjectCode = subjectCode;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public int getSks() {
        return sks;
    }

    public void setSks(int sks) {
        this.sks = sks;
    }

}
