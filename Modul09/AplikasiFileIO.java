package PP2_2025_233040073_B.Modul09;

import javax.swing.*;
import java.awt.*;
import java.io.*;

/**
 * @author RAFI
 */
public class AplikasiFileIO extends JFrame {

    //komponen ui
    private JTextArea textArea;
    private JButton btnOpenText, btnSaveText;
    private JButton btnAddText; //LATIHAN 4
    private JButton btnSaveBinary, btnLoadBinary;
    private JFileChooser fileChooser;

    //konstruktor
    public AplikasiFileIO() {
        super("Tutorial File IO & Exception Handling");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        //Komponen 
        textArea = new JTextArea(); 
        textArea.setFont(new Font("Monospaced", Font.PLAIN, 14));
        fileChooser = new JFileChooser(); 

        //Panel Tombol
        JPanel buttonPanel = new JPanel();
        btnOpenText = new JButton("Buka Text");
        btnSaveText = new JButton("Simpan Text");
        btnAddText = new JButton ("Tambah Text"); // LATIHAN 4
        btnSaveBinary = new JButton("Simpan Config (Binary)");
        btnLoadBinary = new JButton("Muat Config (Binary)");

        buttonPanel.add(btnOpenText);
        buttonPanel.add(btnSaveText);
        buttonPanel.add(btnAddText);
        buttonPanel.add(btnSaveBinary);
        buttonPanel.add(btnLoadBinary);

        //layout
        add(new JScrollPane(textArea), BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);
        
        // Event Handling
        btnSaveText.addActionListener(e -> simpanFileTeks(false));
        btnAddText.addActionListener(e -> simpanFileTeks(true));

        btnSaveBinary.addActionListener(e -> simpanConfigBinary());
        btnLoadBinary.addActionListener(e -> muatConfigBinary());
        
        bacaOtomatis();
    }
    
    private void simpanFileTeks(boolean addtext) {
        String action = addtext ? "Tambahkan" : "Simpan (Timpa)";
        
        if (fileChooser.showSaveDialog(this) == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();

            try (BufferedWriter writer = new BufferedWriter(new FileWriter(file, addtext))) {
                // Jika append, tambahkan baris baru sebelum konten baru
                if (addtext && file.exists()) {
                    writer.newLine(); 
                }
                writer.write(textArea.getText());
                JOptionPane.showMessageDialog(this, "File berhasil di" + (addtext ? "tambahkan" : "simpan") + "!");

            } catch (IOException ex) {
                JOptionPane.showMessageDialog(this, "Gagal menyimpan file: " + ex.getMessage());
            }
        }
    }
    
    //Membaca file teks menggunakan Try-Catch-Finally
    private void bukaFileTeks() {
        if (fileChooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();
            BufferedReader reader = null;

            try {
                //buka stream
                reader = new BufferedReader(new FileReader(file));
                textArea.setText("");

                String line;
                //baca baris
                while ((line = reader.readLine()) != null) {
                    textArea.append(line + "\n");
                }

                JOptionPane.showMessageDialog(this, "File berhasil dimuat!");

            } catch (FileNotFoundException ex) {
                JOptionPane.showMessageDialog(this, "File tidak ditemukan: " + ex.getMessage());
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(this, "Gagal membaca file: " + ex.getMessage());
            } finally {
                
                try {
                    if (reader != null) {
                        reader.close(); 
                    }
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        }
    }

    
     //Menulis file teks menggunakan Try-with-resources
    private void simpanFileTeks() {
        if (fileChooser.showSaveDialog(this) == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();

            try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
                writer.write(textArea.getText());
                JOptionPane.showMessageDialog(this, "File berhasil disimpan!");

            } catch (IOException ex) {
                JOptionPane.showMessageDialog(this, "Gagal menyimpan file: " + ex.getMessage());
            }
        }
    }

    
    //Menulis data integer  ke file biner
    private void simpanConfigBinary() {
        
        try (DataOutputStream dos = new DataOutputStream(new FileOutputStream("config.bin"))) {
            //simpan ukuran font saat ini (Integer)
            int fontSize = textArea.getFont().getSize();
            dos.writeInt(fontSize);

            JOptionPane.showMessageDialog(this, "Ukuran font (" + fontSize + ") disimpan ke config.bin");
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, "Gagal menyimpan binary: " + ex.getMessage());
        }
    }

 
    //Membaca data integerdari file biner menggunakan DataInputStream.
    private void muatConfigBinary() {
        
        try (DataInputStream dis = new DataInputStream(new FileInputStream("config.bin"))) {
            //membaca data Integer
            int fontSize = dis.readInt();

            //terapkan ke aplikasi
            textArea.setFont(new Font("Monospaced", Font.PLAIN, fontSize));
            JOptionPane.showMessageDialog(this, "Font diubah menjadi ukuran: " + fontSize);

        } catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(this, "File config.bin belum dibuat!");
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, "Gagal membaca binary: " + ex.getMessage());
        }
    }
    
     //Membaca otomatis LATIHAN 2
    private void bacaOtomatis() {
        File file = new File("last_notes.txt");
        BufferedReader reader = null;

        try {

            reader = new BufferedReader(new FileReader(file));
            textArea.setText("");

            String line;
            while ((line = reader.readLine()) != null) {
                textArea.append(line + "\n");
            }

        } catch (FileNotFoundException ex) {
            System.out.println("File last_notes.txt belum ditemukan. Aplikasi dimulai dengan area teks kosong.");
        } catch (IOException ex) {

            ex.printStackTrace();
        } finally {

            try {
                if (reader != null) {
                    reader.close();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new AplikasiFileIO().setVisible(true);
        });
    }
}