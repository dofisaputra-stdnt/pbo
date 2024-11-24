package com.kuliahumb.pbo.pertemuan5.tugas;

public class Dosen extends Person {

    private String subject;

    public Dosen(String name, String id, String subject) {
        super(name, id);
        this.subject = subject;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

}
