package com.kuliahumb.pbo.pertemuan6;

import javax.swing.*;
import java.awt.*;

public class ExamGUI extends JFrame {

    ExamGUI() {
        initComponent();
        System.out.println("Constructor ExamGUI");
    }

    void initComponent() {
        setSize(300, 500);
        setLayout(new FlowLayout());
        JLabel labelWelcome = new JLabel("Welcome to Exam GUI");
        JButton buttonSubmit = new JButton("Submit");
        add(labelWelcome);
        add(buttonSubmit);
    }

    public static void main(String[] args) {
        ExamGUI examGUI = new ExamGUI();
        examGUI.setVisible(true);
    }

}
