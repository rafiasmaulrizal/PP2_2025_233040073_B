package PP2_2025_233040073_B.Modul6;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author RAFI
 */
public class KalkulatorSederhana {
    public static void main(String[] args) {
        // 1. Setup Frame
        JFrame frame = new JFrame("Kalkulator Sederhana");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 400);

        // Frame menggunakan BorderLayout secara default

        // 2. Buat Layar (NORTH)
        JTextField layar = new JTextField("0");
        layar.setEditable(false); // Layar tidak bisa diedit langsung
        frame.add(layar, BorderLayout.NORTH);

        // 3. Buat Panel Tombol (CENTER)
        JPanel panelTombol = new JPanel();
        // Gunakan GridLayout 4 baris x 4 kolom untuk 16 tombol
        panelTombol.setLayout(new GridLayout(4, 4, 5, 5)); // 5px gap horizontal dan vertikal

        // Definisi Teks untuk 16 Tombol
        panelTombol.add(new JButton("7"));
        panelTombol.add(new JButton("8"));
        panelTombol.add(new JButton("9"));
        
        panelTombol.add(new JButton("/"));
        panelTombol.add(new JButton("4"));
        panelTombol.add(new JButton("5"));
        
        panelTombol.add(new JButton("6"));
        panelTombol.add(new JButton("*"));
        panelTombol.add(new JButton("1"));
        
        panelTombol.add(new JButton("2"));
        panelTombol.add(new JButton("3"));
        panelTombol.add(new JButton("-"));
        
        panelTombol.add(new JButton("0"));
        panelTombol.add(new JButton("."));
        panelTombol.add(new JButton("="));
        panelTombol.add(new JButton("+"));

        // 4. Tambahkan panel tombol ke frame
        frame.add(panelTombol, BorderLayout.CENTER);

        // 5. Tampilkan Frame
        frame.setVisible(true);
    }
}
