package PP2_2025_233040073_B.Modul07;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author RAFI
 */
public class TugasManajemenNilaiSiswaApp extends JFrame {
    private JTextField txtNama;
    private JTextField txtNilai;
    private JComboBox<String> cmbMatkul;
    private JTable tableData;
    private DefaultTableModel tableModel;
    private JTabbedPane tabbedPane;

    public TugasManajemenNilaiSiswaApp() {
        // konfigurasi frame
        setTitle("Aplikasi Manajemen Nilai Siswa");
        setSize(600, 450); 
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); 

        // inisialisasi tabbed pane
        tabbedPane = new JTabbedPane();

        // buat panel form Input
        JPanel panelInput = createInputPanel();
        tabbedPane.addTab("Input Data", panelInput);

        // buat Panel tabel Data
        JPanel panelTabel = createTablePanel();
        tabbedPane.addTab("Daftar Nilai", panelTabel);

        // menambahkan Tabbedpane ke frame
        add(tabbedPane);
    }
    
    private JPanel createInputPanel() {
        JPanel panel = new JPanel(new GridLayout(5, 2, 10, 10)); 
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        // Komponen nama
        panel.add(new JLabel("Nama Siswa:"));
        txtNama = new JTextField();
        panel.add(txtNama);

        // komponen matkul
        panel.add(new JLabel("Mata Pelajaran:"));
        String[] matkul = {"Matematika Dasar", "Bahasa Indonesia",
                           "Algoritma dan Pemrograman I", "Praktikum Pemrograman II"};
        cmbMatkul = new JComboBox<>(matkul);
        panel.add(cmbMatkul);

        // omponen nilai
        panel.add(new JLabel("Nilai (0-100):"));
        txtNilai = new JTextField();
        panel.add(txtNilai);

        // tombol Simpan
        JButton btnSimpan = new JButton("Simpan Data");  
        // tombol reset
        JButton btnReset = new JButton("Reset Input"); 
        
        JPanel buttonPanel = new JPanel(new GridLayout(1, 2, 10, 0));
        
        buttonPanel.add(btnReset); 
        buttonPanel.add(btnSimpan); 
        
        panel.add(buttonPanel); 

        // event handling tombol Simpan
        btnSimpan.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                prosesSimpan();
            }
        });
        
        // Event handling tombol reset
        btnReset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                resetInput();
            }
        });

        return panel;
    }

    private JPanel createTablePanel() {
        JPanel mainPanel = new JPanel(new BorderLayout());

        // Setup model tabel
        String[] kolom = {"Nama Siswa", "Mata Pelajaran", "Nilai", "Grade"};
        tableModel = new DefaultTableModel(kolom, 0);
        tableData = new JTable(tableModel);

        // bungkus tabel dengan scrollPane
        JScrollPane scrollPane = new JScrollPane(tableData);
        mainPanel.add(scrollPane, BorderLayout.CENTER);

        // tambah tombol hapus
        JPanel bottomPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        JButton btnHapus = new JButton("Hapus Data Terpilih");
        bottomPanel.add(btnHapus);
        mainPanel.add(bottomPanel, BorderLayout.SOUTH);
        
        // event eandling tombol Hapus
        btnHapus.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                hapusDataTerpilih();
            }
        });

        return mainPanel;
    }
    

    // Metode mereset inputan
    private void resetInput() {
        txtNama.setText("");
        txtNilai.setText("");
        cmbMatkul.setSelectedIndex(0);
    }
    
    // Metode menghapus data di tab daftar nilai
    private void hapusDataTerpilih() {
        int selectedRow = tableData.getSelectedRow();
        
        if (selectedRow > -1) {
            tableModel.removeRow(selectedRow);
            JOptionPane.showMessageDialog(this, "Data berhasil dihapus!", "Informasi", 
            JOptionPane.INFORMATION_MESSAGE);
        }
    }


    private void prosesSimpan () {
        // ambil data dari input
        String nama = txtNama.getText();
        String matkul = (String) cmbMatkul.getSelectedItem();
        String strNilai = txtNilai.getText();
        int nilai = -1; 


        // Cek apakah nama kosong dan min 3 karakter
        if (nama.trim().isEmpty() || nama.trim().length() < 3) {
            JOptionPane.showMessageDialog(this, "Nama tidak boleh kosong dan min 3 karakter!",
                                          "Error Validasi", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Cek apakah angka dan nilai tidak lebih dari 100
        try {
            nilai = Integer.parseInt(strNilai);
            if (nilai < 0 || nilai > 100) {
                JOptionPane.showMessageDialog(this, "Nilai harus antara 0 - 100!",
                                              "Error Validasi", JOptionPane.WARNING_MESSAGE);
                return;
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Nilai harus berupa angka!",
                                          "Error Validasi", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Logika switch case
        String grade;
        int nilaiPuluhan = nilai / 10; 
        switch (nilaiPuluhan) {
            case 10:
            case 9:
            case 8:
                grade = "A";
                break;
            case 7:
                grade = "AB";
                break;
            case 6:
                grade = "B";
                break;
            case 5:
                grade = "BC";
                break;
            case 4:
                grade = "C";
                break;
            case 3:
                grade = "D";
                break;
            default: 
                grade = "E";
                break;
        }
        

        // masukkan ke Tabel 
        Object[] dataBaris = {nama, matkul, nilai, grade};
        tableModel.addRow(dataBaris);

        // mereset Form
        resetInput();
        
        JOptionPane.showMessageDialog(this, "Data Berhasil Disimpan!");
        tabbedPane.setSelectedIndex(1); 
    }

    // method main
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new TugasManajemenNilaiSiswaApp().setVisible(true);
        });
    }
}