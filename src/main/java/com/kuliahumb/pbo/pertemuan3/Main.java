package com.kuliahumb.pbo.pertemuan3;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
//        Vehicle mobil = new Vehicle();
//        Scanner scanner = new Scanner(System.in);
//        System.out.println("Enter the vehicle");
//        System.out.print("Masukkan warna mobil: ");
//        mobil.setWarna(scanner.nextLine());
//        System.out.print("Masukkan jenis mobil: ");
//        mobil.setJenis(scanner.nextLine());
//        System.out.print("Masukkan tahun produksi mobil: ");
//        mobil.setTahunProduksi(scanner.nextInt());
//        System.out.print("Masukkan kecepatan mobil: ");
//        mobil.setKecepatan(scanner.nextInt());
//        scanner.nextLine();
//        System.out.print("Masukkan negara produksi mobil: ");
//        mobil.setDiProduksi(scanner.nextLine());

//        mobil.setWarna("Merah");
//        mobil.setJenis("Sedan");
//        mobil.setTahunProduksi(2020);
//        mobil.setKecepatan(100);
//        mobil.setDiProduksi("Jepang");
//        mobil.tampilkanMobil();

//        System.out.println("Warna: " + mobil.getWarna());
//        System.out.println("Jenis: " + mobil.getJenis());
//        System.out.println("Tahun Produksi: " + mobil.getTahunProduksi());
//        System.out.println("Kecepatan: " + mobil.getKecepatan());
//        System.out.println("Di Produksi: " + mobil.getDiProduksi());
//
//        scanner.close();

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the handphone");
        System.out.print("Masukkan merk handphone: ");
        String merk = scanner.nextLine();
        System.out.print("Masukkan tipe handphone: ");
        String tipe = scanner.nextLine();
        System.out.print("Masukkan tahun produksi handphone: ");
        int tahunProduksi = scanner.nextInt();
        System.out.print("Masukkan harga handphone: ");
        int harga = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Masukkan negara produksi handphone: ");
        String negaraProduksi = scanner.nextLine();

        Handphone handphone = new Handphone(merk, tipe, tahunProduksi, harga, negaraProduksi);
        handphone.tampilkanHandphone();
    }

}
