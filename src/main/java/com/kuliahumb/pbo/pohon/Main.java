package com.kuliahumb.pbo.pohon;

class Mobil {
    String warna;
    String jenis;
    int tahunProduksi;
    int kecepatan;
    String diProduksi;

    public void tampilkanMobil() {
        System.out.println("Warna: " + warna);
        System.out.println("Jenis: " + jenis);
        System.out.println("Tahun Produksi: " + tahunProduksi);
        System.out.println("Kecepatan: " + kecepatan);
        System.out.println("Di Produksi: " + diProduksi);
    }
}

class Pohon {
    String jenis;
    int tinggi;
    int umur;
    double diameter;
    String daun;
    String habitat;
    boolean berbuah;
    boolean berbunga;

    public Pohon() {
    }

    public Pohon(String jenis) {
        this.jenis = jenis;
    }

    public Pohon(String jenis, int tinggi) {
        this.jenis = jenis;
        this.tinggi = tinggi;
    }

    public Pohon(String jenis, int tinggi, int umur) {
        this.jenis = jenis;
        this.tinggi = tinggi;
        this.umur = umur;
    }

    public Pohon(String jenis, int tinggi, int umur, double diameter) {
        this.jenis = jenis;
        this.tinggi = tinggi;
        this.umur = umur;
        this.diameter = diameter;
    }

    public Pohon(String jenis, int tinggi, int umur, double diameter, String daun) {
        this.jenis = jenis;
        this.tinggi = tinggi;
        this.umur = umur;
        this.diameter = diameter;
        this.daun = daun;
    }

    public Pohon(String jenis, int tinggi, int umur, double diameter, String daun, String habitat) {
        this.jenis = jenis;
        this.tinggi = tinggi;
        this.umur = umur;
        this.diameter = diameter;
        this.daun = daun;
        this.habitat = habitat;
    }

    public Pohon(String jenis, int tinggi, int umur, double diameter, String daun, String habitat, boolean berbuah) {
        this.jenis = jenis;
        this.tinggi = tinggi;
        this.umur = umur;
        this.diameter = diameter;
        this.daun = daun;
        this.habitat = habitat;
        this.berbuah = berbuah;
    }

    public Pohon(String jenis, int tinggi, int umur, double diameter, String daun, String habitat, boolean berbuah, boolean berbunga) {
        this.jenis = jenis;
        this.tinggi = tinggi;
        this.umur = umur;
        this.diameter = diameter;
        this.daun = daun;
        this.habitat = habitat;
        this.berbuah = berbuah;
        this.berbunga = berbunga;
    }

    public void tampilkanPohon() {
        System.out.println("Jenis: " + jenis);
        System.out.println("Tinggi: " + tinggi + " meter");
        System.out.println("Umur: " + umur + " tahun");
        System.out.println("Diameter: " + diameter + " meter");
        System.out.println("Daun: " + daun);
        System.out.println("Habitat: " + habitat);
        System.out.println("Berbuah: " + (berbuah ? "Ya" : "Tidak"));
        System.out.println("Berbunga: " + (berbunga ? "Ya": "Tidak") + "\n");
    }

}

public class Main {
    public static void main(String[] args) {
        Pohon pohon1 = new Pohon("Mangga", 10, 5, 0.5, "Hijau", "Tropis", true, true);
        pohon1.tampilkanPohon();

        Pohon pohon2 = new Pohon("Jambu", 8, 3, 0.3, "Hijau", "Tropis", true, true);
        pohon2.tampilkanPohon();

        Pohon pohon3 = new Pohon("Jeruk", 7, 2, 0.2, "Hijau", "Tropis", true, true);
        pohon3.tampilkanPohon();
    }
}