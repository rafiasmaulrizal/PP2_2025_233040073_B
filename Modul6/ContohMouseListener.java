package PP2_2025_233040073_B.Modul6;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author RAFI
 */
public class ContohMouseListener {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Contoh MouseListener");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 600);

        // 1. Buat komponen (Event Source)
        JPanel panel = new JPanel();
        panel.setBackground(Color.PINK);
        panel.setPreferredSize(new Dimension(200, 200));

        // 2. Buat Event Listener (menggunakan MouseAdapter)
        MouseAdapter adapter = new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                // Saat mouse masuk, ubah warna beba
                panel.setBackground(Color.CYAN);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                // Saat mouse keluar, kembalikan warna
                panel.setBackground(Color.PINK);
            }

            @Override
            public void mouseClicked(MouseEvent e) {
                // Saat diklik, tampilkan koordinat klik
                System.out.println("Mouse diklik di: x=" + e.getX() + ", y=" + e.getY());
            }
        };

        // 3. Daftarkan listener ke source
        panel.addMouseListener(adapter);

        frame.add(panel);
        frame.setVisible(true);
    }
}
