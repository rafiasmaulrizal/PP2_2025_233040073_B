package PP2_2025_233040073_B.Modul08.controller;

import PP2_2025_233040073_B.Modul08.model.PersegiPanjangModel;
import PP2_2025_233040073_B.Modul08.view.PersegiPanjangView;
import PP2_2025_233040073_B.Modul08.controller.PersegiPanjangController;

public class Main {
    public static void main(String[] args) {

        PersegiPanjangModel model = new PersegiPanjangModel();
        PersegiPanjangView view = new PersegiPanjangView();
        PersegiPanjangController controller = new PersegiPanjangController(model, view);

        view.setVisible(true);
    }
}

