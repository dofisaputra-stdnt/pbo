package com.kuliahumb.pbo.pertemuan5.latihan;

import java.util.Scanner;

public class ScannerTest {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Masukan nama anda: ");
        String nama = scanner.nextLine();
        System.out.print("Masukan usia anda: ");
        int usia = scanner.nextInt();
        System.out.print("Masukan tinggi anda (dalam cm): ");
        double tinggi = scanner.nextDouble();

        System.out.println("Nama: " + nama);
        System.out.println("Usia: " + usia);
        System.out.println("Tinggi: " + tinggi + " cm");

        scanner.close();
    }

}
