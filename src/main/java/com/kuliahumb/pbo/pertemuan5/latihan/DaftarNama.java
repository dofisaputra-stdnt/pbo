package com.kuliahumb.pbo.pertemuan5.latihan;

import java.util.ArrayList;
import java.util.Scanner;

public class DaftarNama {

    public static void main(String[] args) {
        ArrayList<String> daftarNama = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        boolean kondisi = true;
        while (kondisi) {
            System.out.println("Menu:");
            System.out.println("1. Tambah Nama");
            System.out.println("2. Tampilkan Nama");
            System.out.println("3. Keluar");

            System.out.print("Pilih menu: ");
            int pilihan = scanner.nextInt();
            scanner.nextLine();

            switch (pilihan) {
                case 1:
                    System.out.print("Masukkan nama: ");
                    String nama = scanner.nextLine();
                    daftarNama.add(nama);
                    System.out.println("Added 1");
                    break;
                case 2:
                    System.out.println("Daftar Nama:");
                    for (String n : daftarNama) {
                        System.out.println(daftarNama.indexOf(n) + 1 + ". " + n);
                    }
                    break;
                case 3:
                    System.out.println("Keluar program");
                    scanner.close();
                    return;
                default:
                    System.out.println("Menu tidak tersedia");
                    break;
            }
        }
    }

}
