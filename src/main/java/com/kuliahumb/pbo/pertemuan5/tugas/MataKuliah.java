package com.kuliahumb.pbo.pertemuan5.tugas;

import java.util.ArrayList;

public class MataKuliah {

    private String nama;
    private String kode;
    private Dosen dosen;
    private ArrayList<Mahasiswa> mahasiswaList;

    public MataKuliah(String nama, String kode, Dosen dosen) {
        this.nama = nama;
        this.kode = kode;
        this.dosen = dosen;
        this.mahasiswaList = new ArrayList<>();
    }

    public void addMahasiswa(Mahasiswa mahasiswa) {
        mahasiswaList.add(mahasiswa);
    }

    public void printInfo() {
        System.out.println("Mata Kuliah: " + nama + " (" + kode + ")");
        System.out.println("Dosen: " + dosen.getName() + " (" + dosen.getId() + ")");
        System.out.println("Daftar Mahasiswa:");
        for (Mahasiswa m : mahasiswaList) {
            System.out.println("- " + m.getName() + " (" + m.getId() + "), Jurusan: " + m.getMajor());
        }
    }

    public String getKode() {
        return kode;
    }

    public void setKode(String kode) {
        this.kode = kode;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public Dosen getDosen() {
        return dosen;
    }

    public void setDosen(Dosen dosen) {
        this.dosen = dosen;
    }

    public ArrayList<Mahasiswa> getMahasiswaList() {
        return mahasiswaList;
    }

    public void setMahasiswaList(ArrayList<Mahasiswa> mahasiswaList) {
        this.mahasiswaList = mahasiswaList;
    }

}
