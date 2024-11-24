package com.kuliahumb.pbo.pertemuan7;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;
import java.util.List;

public class ModulPerkuliahan extends JFrame {

    private JTextField txNIM;
    private JTextField txNama;
    private JRadioButton sistemInformasiRadioButton;
    private JRadioButton teknikInformatikaRadioButton;
    private JSpinner spinnerDob;
    private JTextField txKodeMatkul;
    private JTextField txMatkul;
    private JTextField txSKS;
    private JPanel mainPanel;
    private JTable tableModel;
    private JButton NEWSTUDENTButton;
    private JButton NEWSUBJECTButton;
    private JButton VIEWDATAButton;
    private JButton EXITButton;
    private JScrollPane tableScrollPane;

    private List<Student> students = new ArrayList<>();
    private List<Subject> subjects = new ArrayList<>();

    ModulPerkuliahan() {
        setContentPane(mainPanel);
        setTitle("Modul Perkuliahan");
//        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        System.out.println("Constructor ModulPerkuliahan");

        students.add(new Student("41522110006", "Dofi Saputra", "Teknik Informatika", 14));
        subjects.add(new Subject("1001", " PEMROGRAMAN BERORIENTASI OBJEK (PBO) ", 3));

        disableFormStudent();
        disableFormSubject();

        NEWSTUDENTButton.addActionListener(e -> {
            if (NEWSTUDENTButton.getText().equalsIgnoreCase("NEW STUDENT")) {
                NEWSTUDENTButton.setText("SAVE STUDENT");
                enableFormStudent();
                return;
            }

            String nim = txNIM.getText();
            String name = txNama.getText();
            String major = sistemInformasiRadioButton.isSelected() ? "Sistem Informasi" : teknikInformatikaRadioButton.isSelected() ? "Teknik Informatika" : "";

            if (nim.isEmpty() || name.isEmpty() || major.isEmpty()) {
                JOptionPane.showMessageDialog(null, "NIM, Nama, dan Jurusan harus diisi!");
                return;
            }

            if (students.stream().anyMatch(student -> student.getNim().equalsIgnoreCase(nim))) {
                JOptionPane.showMessageDialog(null, "NIM sudah ada!");
                return;
            }

            Student student = new Student(nim, name, major, spinnerDob.getValue().hashCode());
            students.add(student);
            System.out.println("New Student: " + student.getName());
            refreshTableStudent();
            disableFormStudent();
        });

        NEWSUBJECTButton.addActionListener(e -> {
            if (NEWSUBJECTButton.getText().equalsIgnoreCase("NEW SUBJECT")) {
                NEWSUBJECTButton.setText("SAVE SUBJECT");
                enableFormSubject();
                return;
            }

            String subjectCode = txKodeMatkul.getText();
            String subjectName = txMatkul.getText();
            int sks = txSKS.getText().isEmpty() ? 0 : Integer.parseInt(txSKS.getText());

            if (subjectCode.isEmpty() || subjectName.isEmpty() || sks == 0) {
                JOptionPane.showMessageDialog(null, "Kode Matkul, Mata Kuliah, dan SKS harus diisi!");
                return;
            }

            if (subjects.stream().anyMatch(subject -> subject.getSubjectCode().equalsIgnoreCase(subjectCode))) {
                JOptionPane.showMessageDialog(null, "Kode Matkul sudah ada!");
                return;
            }

            Subject subject = new Subject(subjectCode, subjectName, sks);
            subjects.add(subject);
            System.out.println("New Subject: " + subject.getSubjectName());
            refreshTableSubject();
            disableFormStudent();
        });

        VIEWDATAButton.addActionListener(e -> {
            System.out.println("View Data");
            disableFormStudent();
            disableFormSubject();

            String[] options = {"Student", "Subject"};
            int option = JOptionPane.showOptionDialog(null, "View Data", "View Data", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
            if (option == 0) {
                refreshTableStudent();
            } else if (option == 1) {
                refreshTableSubject();
            }
        });

        EXITButton.addActionListener(e -> {
            System.exit(0);
        });
    }

    private void refreshTableStudent() {
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("NIM");
        model.addColumn("Nama");
        model.addColumn("Jurusan");
        model.addColumn("Tanggal Lahir");
        for (Student student : students) {
            model.addRow(new Object[]{student.getNim(), student.getName(), student.getMajor(), student.getDob()});
        }
        tableModel.setModel(model);
        tableScrollPane.setViewportView(tableModel);
    }

    private void refreshTableSubject() {
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Kode Matkul");
        model.addColumn("Mata Kuliah");
        model.addColumn("SKS");
        for (Subject subject : subjects) {
            model.addRow(new Object[]{subject.getSubjectCode(), subject.getSubjectName(), subject.getSks()});
        }
        tableModel.setModel(model);
        tableScrollPane.setViewportView(tableModel);
    }

    private void disableFormStudent() {
        NEWSTUDENTButton.setText("NEW STUDENT");
        txNIM.setText("");
        txNama.setText("");
        sistemInformasiRadioButton.setSelected(false);
        teknikInformatikaRadioButton.setSelected(false);
        spinnerDob.setValue(0);
        txNIM.setEnabled(false);
        txNama.setEnabled(false);
        sistemInformasiRadioButton.setEnabled(false);
        teknikInformatikaRadioButton.setEnabled(false);
        spinnerDob.setEnabled(false);
    }

    private void enableFormStudent() {
        txNIM.setEnabled(true);
        txNIM.requestFocus();
        txNama.setEnabled(true);
        sistemInformasiRadioButton.setEnabled(true);
        teknikInformatikaRadioButton.setEnabled(true);
        spinnerDob.setEnabled(true);
        disableFormSubject();
    }

    private void disableFormSubject() {
        NEWSUBJECTButton.setText("NEW SUBJECT");
        txKodeMatkul.setText("");
        txMatkul.setText("");
        txSKS.setText("");
        txKodeMatkul.setEnabled(false);
        txMatkul.setEnabled(false);
        txSKS.setEnabled(false);
    }

    private void enableFormSubject() {
        txKodeMatkul.setEnabled(true);
        txKodeMatkul.requestFocus();
        txMatkul.setEnabled(true);
        txSKS.setEnabled(true);
        disableFormStudent();
    }

    public static void main(String[] args) {
        ModulPerkuliahan modulPerkuliahan = new ModulPerkuliahan();
        modulPerkuliahan.pack();
        modulPerkuliahan.setVisible(true);
        modulPerkuliahan.setExtendedState(JFrame.MAXIMIZED_BOTH);
    }

}
