package PP2_2025_233040073_B.Modul10;

import PP2_2025_233040073_B.Modul10.controller.MahasiswaController;
import PP2_2025_233040073_B.Modul10.model.MahasiswaModel;
import PP2_2025_233040073_B.Modul10.view.MahasiswaView;

import javax.swing.SwingUtilities;

public class MainApp {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            MahasiswaView view = new MahasiswaView();
            MahasiswaModel model = new MahasiswaModel(view.getTableModel());
            new MahasiswaController(model, view);            
            view.setVisible(true);
        });
    }
}
