package com.kuliahumb.pbo.pertemuan3;

public class Vehicle {

    private String warna;
    private String jenis;
    private int tahunProduksi;
    private int kecepatan;
    private String diProduksi;

    public void setWarna(String warna) {
        this.warna = warna;
    }

    public void setJenis(String jenis) {
        this.jenis = jenis;
    }

    public void setTahunProduksi(int tahunProduksi) {
        this.tahunProduksi = tahunProduksi;
    }

    public void setKecepatan(int kecepatan) {
        this.kecepatan = kecepatan;
    }

    public void setDiProduksi(String diProduksi) {
        this.diProduksi = diProduksi;
    }

    public String getWarna() {
        return warna;
    }

    public String getJenis() {
        return jenis;
    }

    public int getTahunProduksi() {
        return tahunProduksi;
    }

    public int getKecepatan() {
        return kecepatan;
    }

    public String getDiProduksi() {
        return diProduksi;
    }

    public void tampilkanMobil() {
        System.out.println("Warna: " + warna);
        System.out.println("Jenis: " + jenis);
        System.out.println("Tahun Produksi: " + tahunProduksi);
        System.out.println("Kecepatan: " + kecepatan);
        System.out.println("Di Produksi: " + diProduksi);
    }

}
