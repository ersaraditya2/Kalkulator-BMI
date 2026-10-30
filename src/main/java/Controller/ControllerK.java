package Controller;

import Model.kalkulatorBMI;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import java.io.IOException;

public class ControllerK {

    // --- INPUT COMPONENTS ---
    @FXML private TextField txtNama;
    @FXML private ComboBox<String> cbJenisKelamin;
    @FXML private TextField txtTinggi;
    @FXML private TextField txtBerat;
    @FXML private Label lblKeterangan; // Label error di halaman input jika ada

    @FXML
    public void initialize() {
        if (cbJenisKelamin != null) {
            cbJenisKelamin.getItems().addAll("Laki-laki", "Perempuan");
        }
    }

    // --- METHOD KETIKA TOMBOL "HITUNG" DIKLIK ---
    @FXML
    private void handleHitungButton() {
        try {
            String nama = txtNama.getText();
            String jenisKelamin = cbJenisKelamin.getValue();

            // Validasi input kosong
            if (nama == null || nama.trim().isEmpty() || jenisKelamin == null || 
                txtTinggi.getText().isEmpty() || txtBerat.getText().isEmpty()) {
                if (lblKeterangan != null) {
                    lblKeterangan.setText("Semua data harus diisi dengan lengkap!");
                }
                return;
            }

            int tinggi = Integer.parseInt(txtTinggi.getText().trim());
            double berat = Double.parseDouble(txtBerat.getText().trim());

            // 1. Hitung BMI menggunakan Model OOP
            kalkulatorBMI bmi = new kalkulatorBMI(nama, jenisKelamin, berat, tinggi);
            double hasilBMI = bmi.hitungBMI();

            // 2. PINDAH KE HALAMAN OUTPUT (Output-UI.fxml)
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/Output-UI.fxml"));
            Parent root = loader.load();

            // Ambil controller OutputC untuk mengirim data
            OutputC outputController = loader.getController();
            if (outputController != null) {
                outputController.setDataBMI(bmi.getNama(), hasilBMI);
            }

            // Ambil Stage saat ini dari tombol Hitung
            Stage stage = (Stage) txtNama.getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.setTitle("Hasil Kalkulator BMI");
            stage.show();

        } catch (NumberFormatException e) {
            if (lblKeterangan != null) {
                lblKeterangan.setText("Tinggi dan Berat harus berupa angka!");
            }
        } catch (Exception e) {
            // Mencetak error lengkap ke console NetBeans untuk debugging
            e.printStackTrace();
            if (lblKeterangan != null) {
                lblKeterangan.setText("Terjadi kesalahan: " + e.getMessage());
            }
        }
    }
}