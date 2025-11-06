package PP2_2025_233040073_B.Modul6;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class KonverterSuhu {
    public static void main(String[] args) {
        // membuat frame utama
        JFrame frame = new JFrame("Konverter Suhu C ke F");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(350, 180);

        // mengatur layout GridLayout
        frame.setLayout(new GridLayout(3, 2, 10, 10));

        // membuat komponen
        JLabel labelCelcius = new JLabel("Celcius:");
        JTextField inputCelcius = new JTextField();
        JLabel labelFahrenheit = new JLabel("Fahrenheit:");
        JLabel hasilFahrenheit = new JLabel("");
        JButton tombolKonversi = new JButton("Konversi");

        tombolKonversi.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String teks = inputCelcius.getText();
                    double celcius = Double.parseDouble(teks);
                    double fahrenheit = (celcius * 9.0 / 5.0) + 32.0;

                    hasilFahrenheit.setText(String.format("%.2f °F", fahrenheit));

                } catch (NumberFormatException ex) {
                    
                    JOptionPane.showMessageDialog(frame,
                            "Input tidak valid! Masukkan angka untuk Celcius.",
                            "Error", JOptionPane.ERROR_MESSAGE);
                    hasilFahrenheit.setText("ERROR");
                }
            }
        });

        frame.add(labelCelcius);
        frame.add(inputCelcius);
        frame.add(labelFahrenheit);
        frame.add(hasilFahrenheit);
        frame.add(new JLabel(""));
        frame.add(tombolKonversi);

        frame.setVisible(true);
    }
}
