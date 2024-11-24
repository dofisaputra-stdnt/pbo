package com.kuliahumb.pbo.pertemuan3;

public class Handphone {

    private String merk;
    private String tipe;
    private int tahunProduksi;
    private int harga;
    private String negaraProduksi;

    public String getMerk() {
        return merk;
    }

    public void setMerk(String merk) {
        this.merk = merk;
    }

    public String getTipe() {
        return tipe;
    }

    public void setTipe(String tipe) {
        this.tipe = tipe;
    }

    public int getTahunProduksi() {
        return tahunProduksi;
    }

    public void setTahunProduksi(int tahunProduksi) {
        this.tahunProduksi = tahunProduksi;
    }

    public int getHarga() {
        return harga;
    }

    public void setHarga(int harga) {
        this.harga = harga;
    }

    public String getNegaraProduksi() {
        return negaraProduksi;
    }

    public void setNegaraProduksi(String negaraProduksi) {
        this.negaraProduksi = negaraProduksi;
    }

    public void tampilkanHandphone() {
        System.out.println("Merk: " + getMerk());
        System.out.println("Tipe: " + getTipe());
        System.out.println("Tahun Produksi: " + getTahunProduksi());
        System.out.println("Harga: " + getHarga());
        System.out.println("Negara Produksi: " + getNegaraProduksi());
    }

    public Handphone(String merk, String tipe, int tahunProduksi, int harga, String negaraProduksi) {
        this.merk = merk;
        this.tipe = tipe;
        this.tahunProduksi = tahunProduksi;
        this.harga = harga;
        this.negaraProduksi = negaraProduksi;
    }

}
