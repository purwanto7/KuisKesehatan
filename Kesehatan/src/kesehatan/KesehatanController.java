/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kesehatan;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Kandos
 */
public class KesehatanController implements Initializable {

    @FXML
    private Label label;
    @FXML
    private JFXTextField nama;
    @FXML
    private JFXTextField tinggi;
    @FXML
    private JFXTextField beratbadan;
    @FXML
    private RadioButton laki;
    @FXML
    private RadioButton perempuan;
    @FXML
    private JFXButton btnproses;
    @FXML
    private JFXButton btnreset;
    @FXML
    private TextField beratideal;
    @FXML
    private TextArea tekarea1;
    @FXML
    private TextArea tekarea2;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void proses(ActionEvent event) {
        String Nama = nama.getText();
        String Tinggi = tinggi.getText();
        String Beratbadan = beratbadan.getText();

        int berat = Integer.parseInt(beratbadan.getText());
        int ting = Integer.parseInt(tinggi.getText());
        int ideal = 0;
        String analisa = "";
        String saran = "";
        String pilihan = "";
        if (laki.isSelected()) {
            pilihan = "Laki-laki";
            ideal = ting - 105;
        } else if (perempuan.isSelected()) {
            pilihan = "Perempuan";
            ideal = ting - 110;
        }
        beratideal.setText("" + ideal);
        if (ideal == berat) {
            tekarea1.setText("Nama : " + Nama
                    + "\nTinggi : " + Tinggi
                    + "\nBerat Badan : " + Beratbadan
                    + "\nJenis Kelamin : " + pilihan
                    + "\nAnalisa :Ideal");
            tekarea2.setText("Hidup anda sehat");
        } else if (ideal > berat) {
            tekarea1.setText("Nama : " + Nama
                    + "\nTinggi : " + Tinggi
                    + "\nBerat Badan : " + Beratbadan
                    + "\nJenis Kelamin : " + pilihan
                    + "\nAnalisa : UnderWeight");

            tekarea2.setText("Tingkatkan asupan makan anda, jaga kesehatan hidup anda");
        } else if (ideal < berat) {
            tekarea1.setText("Nama : " + Nama
                    + "\nTinggi : " + Tinggi
                    + "\nBerat Badan : " + Beratbadan
                    + "\nJenis Kelamin : " + pilihan
                    + "\nAnalisa : OverWeight");

            tekarea2.setText("Kurangi asupan makan anda, jaga kesehatan hidup anda");
        }

    }

    @FXML
    private void reset(ActionEvent event) {
        nama.setText("");
        tinggi.setText("");
        beratbadan.setText("");
        laki.setSelected(false);
        perempuan.setSelected(false);
        beratideal.setText("");
        tekarea1.setText("");
        tekarea2.setText("");
    }

}
