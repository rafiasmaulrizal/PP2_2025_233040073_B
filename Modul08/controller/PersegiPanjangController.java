package PP2_2025_233040073_B.Modul08.controller;

import PP2_2025_233040073_B.Modul08.model.PersegiPanjangModel;
import PP2_2025_233040073_B.Modul08.view.PersegiPanjangView;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent; 

/**
 *
 * @author RAFI
 */

public class PersegiPanjangController {
    private  PersegiPanjangModel model;
    private  PersegiPanjangView view;

   
    public PersegiPanjangController(PersegiPanjangModel model, PersegiPanjangView view) {
        this.model = model;
        this.view = view;

        this.view.addHitungLuasListener(new HitungLuasListener());
        this.view.addHitungKelilingListener(new HitungKelilingListener());
        this.view.addResetListener(new ResetListener());
    }

    class HitungLuasListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                double p = view.getPanjang();
                double l = view.getLebar();

                model.setPanjang(p);
                model.setLebar(l);

                model.hitungLuas();
                view.setHasil("Luas: " + model.getLuas());

            } catch (NumberFormatException ex) {
                view.tampilkanPesanError("Masukkan angka yang valid!");
            }
        }
    }

    class HitungKelilingListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                double p = view.getPanjang();
                double l = view.getLebar();

                model.setPanjang(p);
                model.setLebar(l);

                model.hitungKeliling();
                view.setHasil("Keliling: " + model.getKeliling());

            } catch (NumberFormatException ex) {
                view.tampilkanPesanError("Masukkan angka yang valid!");
            }
        }
    }

    class ResetListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            view.resetForm();
        }
    }
}

   
