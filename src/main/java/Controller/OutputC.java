package Controller;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextField;

public class OutputC {

    @FXML private TextField txtNamaHasil;
    @FXML private Label lblKeterangan;
    @FXML private ProgressBar bmiProgressBar;
    @FXML private Label lblAngkaBMI;

    public void setDataBMI(String nama, double hasilBMI) {
        if (txtNamaHasil != null) {
            txtNamaHasil.setText(nama);
        }
        if (lblAngkaBMI != null) {
            lblAngkaBMI.setText(String.format("%.1f", hasilBMI));
        }
        aturKategoriDanWarna(hasilBMI);
        if (bmiProgressBar != null) {
            bmiProgressBar.setProgress(hitungProgress(hasilBMI));
        }
    }

    private void aturKategoriDanWarna(double bmi) {
        if (lblKeterangan == null || bmiProgressBar == null) return;

        if (bmi < 18.5) {
            lblKeterangan.setText("Underweight (Kurus)");
            bmiProgressBar.setStyle("-fx-accent: #3498db;");
        } else if (bmi < 25.0) {
            lblKeterangan.setText("Normal (Ideal)");
            bmiProgressBar.setStyle("-fx-accent: #2ecc71;");
        } else if (bmi < 30.0) {
            lblKeterangan.setText("Overweight (Gemuk)");
            bmiProgressBar.setStyle("-fx-accent: #f1c40f;");
        } else {
            lblKeterangan.setText("Obesitas");
            bmiProgressBar.setStyle("-fx-accent: #e74c3c;");
        }
    }

    private double hitungProgress(double bmi) {
        if (bmi <= 10) return 0.0;
        if (bmi >= 40) return 1.0;
        return (bmi - 10) / (40 - 10);
    }
}