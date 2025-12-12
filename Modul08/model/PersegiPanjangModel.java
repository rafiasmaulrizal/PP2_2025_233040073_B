package PP2_2025_233040073_B.Modul08.model;

import java.awt.GridLayout;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author RAFI
 */
public class PersegiPanjangModel {
    private double panjang;
    private double lebar;
    private double luas;
    private double keliling;
    
    //menghitung luas
    public void hitungLuas(){
        this.luas = this.panjang * this.lebar;
    }
    
    //menghitung keliling tambahin untuk latihan 2
    public void hitungKeliling() {
        this.keliling = 2 * (this.panjang + this.lebar);
    }
    
    //setter getter
    public void setPanjang(double panjang) {
        this.panjang = panjang;
    }
    
    public void setLebar(double lebar){
        this.lebar = lebar;
    }
    
    public double getLuas(){
        return luas;
    }

    public double getKeliling() {
        return keliling;
    }  
}
