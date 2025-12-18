package PP2_2025_233040073_B.Modul10.view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author RAFI
 */
public class MahasiswaView extends JFrame {
     // Komponen GUI
    JTextField txtNama, txtNIM, txtJurusan, txtCari;
    JButton btnSimpan, btnEdit, btnHapus, btnClear, btnCari;
    JTable tableMahasiswa;
    DefaultTableModel model;
  
    public MahasiswaView() {
        // Setup Frame
        setTitle("Aplikasi CRUD Mahasiswa JDBC");
        setSize(600, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // 1. Panel Form (Input Data)
        JPanel panelForm = new JPanel(new GridLayout(3, 2, 10, 10));
        panelForm.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        panelForm.add(new JLabel("Nama:"));
        txtNama = new JTextField();
        panelForm.add(txtNama);

        panelForm.add(new JLabel("NIM:"));
        txtNIM = new JTextField();
        panelForm.add(txtNIM);

        panelForm.add(new JLabel("Jurusan:"));
        txtJurusan = new JTextField();
        panelForm.add(txtJurusan);

        // Panel Tombol
        JPanel panelTombol = new JPanel(new FlowLayout());
        btnSimpan = new JButton("Simpan");
        btnEdit = new JButton("Edit");
        btnHapus = new JButton("Hapus");
        btnClear = new JButton("Clear");
        
        panelTombol.add(btnSimpan);
        panelTombol.add(btnEdit);
        panelTombol.add(btnHapus);
        panelTombol.add(btnClear);
        
        JPanel panelCari = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 5));
        panelCari.add(new JLabel("Cari Mahasiswa"));
        txtCari = new JTextField(20);
        btnCari = new JButton("Cari");

        panelCari.add(txtCari);
        panelCari.add(btnCari);
       
        // Gabungkan Panel Form dan Tombol di bagian Atas (NORTH)
        JPanel panelAtas = new JPanel();
        panelAtas.setLayout(new BoxLayout(panelAtas, BoxLayout.Y_AXIS));

        panelAtas.add(panelForm);
        panelAtas.add(panelTombol);
        panelAtas.add(panelCari);

        add(panelAtas, BorderLayout.NORTH);

        // 2. Tabel Data (Menampilkan Data)
        model = new DefaultTableModel();
        model.addColumn("No");
        model.addColumn("Nama");
        model.addColumn("NIM");
        model.addColumn("Jurusan");

        tableMahasiswa = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(tableMahasiswa);
        add(scrollPane, BorderLayout.CENTER);
         }
        public void addSimpanListener(ActionListener listener) {
        btnSimpan.addActionListener(listener);
        }

        public void addEditListener(ActionListener listener) {
            btnEdit.addActionListener(listener);
        }

        public void addHapusListener(ActionListener listener) {
            btnHapus.addActionListener(listener);
        }

        public void addClearListener(ActionListener listener) {
            btnClear.addActionListener(listener);
        }

        public void addCariListener(ActionListener listener) {
            btnCari.addActionListener(listener);
        }

        public void addTableMouseListener(MouseAdapter listener) {
            tableMahasiswa.addMouseListener(listener);
        }
        
        
        public void kosongkanForm() {
        txtNama.setText(null);
        txtNIM.setText(null);
        txtJurusan.setText(null);
    }
    public String getTxtNama() { return txtNama.getText(); }
    public String getTxtNIM() { return txtNIM.getText(); }
    public String getTxtJurusan() { return txtJurusan.getText(); }
    public String getTxtCari() { return txtCari.getText(); }

    public void setTxtNama(String nama) { txtNama.setText(nama); }
    public void setTxtNIM(String nim) { txtNIM.setText(nim); }
    public void setTxtJurusan(String jurusan) { txtJurusan.setText(jurusan); }

   
    public JTable getTable() { return tableMahasiswa; }
    public DefaultTableModel getTableModel()
    { return model; }
}
