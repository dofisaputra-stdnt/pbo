package com.kuliahumb.pbo.pertemuan5.tugas;

import javax.swing.*;
import java.util.ArrayList;

/**
 * Nama : Dofi Saputra
 * NIM  : 41522110006
 */

public class Main {

//    public static void main(String[] args) {
//        Dosen dosen1 = new Dosen("Mohamad Yusuf, M.C.S", "M0020", "Pemrograman Beorientasi Objek dengan Java");
//        MataKuliah matkul1 = new MataKuliah("Pemrograman Berorientasi Objek dengan Java", "CS101", dosen1);
//
//        Mahasiswa mahasiswa1 = new Mahasiswa("Dofi Saputra", "41522110006", "Teknik Informatika");
//        Mahasiswa mahasiswa2 = new Mahasiswa("Dodi Saputra", "12345678910", "Teknik Informatika");
//
//        matkul1.addMahasiswa(mahasiswa1);
//        matkul1.addMahasiswa(mahasiswa2);
//
//        matkul1.printInfo();
//    }

    public static void main(String[] args) {
        ArrayList<Dosen> daftarDosen = new ArrayList<>();
        ArrayList<MataKuliah> daftarMataKuliah = new ArrayList<>();

        // initialize data
        Dosen dosen1 = new Dosen("Mohamad Yusuf, M.C.S", "M0020", "Pemrograman Beorientasi Objek dengan Java");
        daftarDosen.add(dosen1);

        MataKuliah matkul1 = new MataKuliah("Pemrograman Berorientasi Objek dengan Java", "CS101", dosen1);
        Mahasiswa mahasiswa1 = new Mahasiswa("Dofi Saputra", "41522110006", "Teknik Informatika");
        matkul1.addMahasiswa(mahasiswa1);
        daftarMataKuliah.add(matkul1);

        while (true) {
            String menu = """
                1. Tambah Mahasiswa kedalam Mata Kuliah
                2. Tambah Dosen
                3. Tambah Mata Kuliah
                4. Tampilkan Data
                5. Keluar
                """;

            String pilihan = JOptionPane.showInputDialog(null, menu, "Menu", JOptionPane.QUESTION_MESSAGE);
            try {
                int pil = Integer.parseInt(pilihan);
                switch (pil) {
                    case 1:
                        JTextField idMhs = new JTextField();
                        JTextField nameMhs = new JTextField();
                        JTextField majorMhs = new JTextField();
                        JTextField codeMatkulMhs = new JTextField();

                        Object[] inputMhs = {
                                "ID:", idMhs,
                                "Name:", nameMhs,
                                "Major:", majorMhs,
                                "Code Mata Kuliah:", codeMatkulMhs
                        };

                        int optionMhs = JOptionPane.showConfirmDialog(null, inputMhs, "Tambah Mahasiswa", JOptionPane.OK_CANCEL_OPTION);
                        if (optionMhs == JOptionPane.OK_OPTION) {
                            MataKuliah mataKuliah = daftarMataKuliah.stream().filter(m -> m.getKode().equals(codeMatkulMhs.getText())).findFirst().orElse(null);
                            if (mataKuliah != null) {
                                Mahasiswa mahasiswa = new Mahasiswa(nameMhs.getText(), idMhs.getText(), majorMhs.getText());
                                mataKuliah.addMahasiswa(mahasiswa);
                                JOptionPane.showMessageDialog(null, "Mahasiswa berhasil ditambahkan", "Success", JOptionPane.INFORMATION_MESSAGE);
                            } else {
                                JOptionPane.showMessageDialog(null, "Mata kuliah tidak ditemukan", "Error", JOptionPane.ERROR_MESSAGE);
                            }
                        }
                        break;
                    case 2:
                        JTextField idDosen = new JTextField();
                        JTextField nameDosen = new JTextField();
                        JTextField courseDosen = new JTextField();

                        Object[] inputDosen = {
                                "ID:", idDosen,
                                "Name:", nameDosen,
                                "Course:", courseDosen
                        };

                        int optionDosen = JOptionPane.showConfirmDialog(null, inputDosen, "Tambah Dosen", JOptionPane.OK_CANCEL_OPTION);
                        if (optionDosen == JOptionPane.OK_OPTION) {
                            Dosen dosen = new Dosen(nameDosen.getText(), idDosen.getText(), courseDosen.getText());
                            daftarDosen.add(dosen);
                            JOptionPane.showMessageDialog(null, "Dosen berhasil ditambahkan", "Success", JOptionPane.INFORMATION_MESSAGE);
                        }
                        break;
                    case 3:
                        JTextField codeMatkul = new JTextField();
                        JTextField nameMatkul = new JTextField();
                        JTextField dosenMatkul = new JTextField();

                        Object[] inputMatkul = {
                                "Code:", codeMatkul,
                                "Name:", nameMatkul,
                                "Dosen:", dosenMatkul
                        };

                        int optionMatkul = JOptionPane.showConfirmDialog(null, inputMatkul, "Tambah Mata Kuliah", JOptionPane.OK_CANCEL_OPTION);
                        if (optionMatkul == JOptionPane.OK_OPTION) {
                            Dosen dosen = daftarDosen.stream().filter(d -> d.getId().equals(dosenMatkul.getText())).findFirst().orElse(null);
                            if (dosen != null) {
                                MataKuliah mataKuliah = new MataKuliah(nameMatkul.getText(), codeMatkul.getText(), dosen);
                                daftarMataKuliah.add(mataKuliah);
                                JOptionPane.showMessageDialog(null, "Mata kuliah berhasil ditambahkan", "Success", JOptionPane.INFORMATION_MESSAGE);
                            } else {
                                JOptionPane.showMessageDialog(null, "Dosen tidak ditemukan", "Error", JOptionPane.ERROR_MESSAGE);
                            }
                        }
                        break;
                    case 4:
                        StringBuilder sb = new StringBuilder();
                        for (MataKuliah m : daftarMataKuliah) {
                            sb.append("Mata Kuliah: ").append(m.getNama()).append(" (").append(m.getKode()).append(")\n");
                            sb.append("Dosen: ").append(m.getDosen().getName()).append(" (").append(m.getDosen().getId()).append(")\n");
                            sb.append("Daftar Mahasiswa:\n");
                            for (Mahasiswa mahasiswa : m.getMahasiswaList()) {
                                sb.append("- ").append(mahasiswa.getName()).append(" (").append(mahasiswa.getId()).append("), Jurusan: ").append(mahasiswa.getMajor()).append("\n");
                            }
                            sb.append("\n");
                        }
                        JOptionPane.showMessageDialog(null, sb.toString(), "Data", JOptionPane.INFORMATION_MESSAGE);
                        break;
                    case 5:
                        JOptionPane.showMessageDialog(null, "Keluar program", "Exit", JOptionPane.INFORMATION_MESSAGE);
                        return;
                    default:
                        break;
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Input harus berupa angka", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

}
