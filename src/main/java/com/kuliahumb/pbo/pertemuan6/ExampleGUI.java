package com.kuliahumb.pbo.pertemuan6;

import javax.swing.*;

public class ExampleGUI extends JFrame {
    private JPanel mainPanel;
    private JTextField inputText;
    private JButton submitButton;
    private JButton clearButton;
    private JLabel resultText;

    ExampleGUI() {
        setContentPane(mainPanel);
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Example GUI");
        System.out.println("Constructor ExampleGUI");
        submitButton.addActionListener(e -> {
            String inputText = ExampleGUI.this.inputText.getText();
            resultText.setText("Result: " + inputText);
        });

        clearButton.addActionListener(e -> {
            inputText.setText("");
            resultText.setText("Result: ");
        });
    }

    public static void main(String[] args) {
        ExampleGUI exampleGUI = new ExampleGUI();
        exampleGUI.setVisible(true);
    }

}
