package com.kuliahumb.pbo.pertemuan5.latihan;

import java.util.Scanner;

public class ContohNextLine {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Masukkan kalimat: ");
        String kalimat = scanner.nextLine();

        String[] kata = kalimat.split(" ");

        System.out.println("Kata kata dalam kalimat:");
        for (String k : kata) {
            System.out.println(k);
        }

        scanner.close();
    }

}
