package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class Controller {
    @FXML
    TextField txtFase;
    @FXML
    Label lblResultado;
    @FXML
    ComboBox comboBox;

    @FXML
    protected void initialize() {
        comboBox.getItems().addAll("Chart At", "Ends With", "CompareTo",
                "EqualsIgnoreCase", "IndexOf", "LastIndexOf",
                "Replace", "ReplaceFirst", "Split", "Startswith",
                "Substring");
    }

    public void evento(ActionEvent event) {
        String texto = txtFase.getText();
        switch (comboBox.getSelectionModel().getSelectedIndex()) {
            case 0: {
                char res = texto.charAt(2);
                lblResultado.setText(res + "");
                break;
            }
            case 1: {
                boolean res = texto.endsWith("ota");
                lblResultado.setText(res + "");
                break;
            }
            case 2: {
                int res = texto.compareTo("Jalapa");
                lblResultado.setText(res + "");
                break;
            }
            case 3: {
                boolean res = texto.equalsIgnoreCase("PERRO");
                lblResultado.setText(res + "");
                break;
            }
            case 4: {
                int res = texto.indexOf("gatitos 4 patas");
                lblResultado.setText(res + "");
                break;
            }
            case 5: {
                int res = texto.lastIndexOf("videos graciosos");
                lblResultado.setText(res + "");
                break;

            }
            case 6: {
                String res = texto.replace("30", "90");
                lblResultado.setText(res + "");
                break;
            }
            case 7: {
                String res = texto.replaceFirst("75", "100");
                lblResultado.setText(res + "");
                break;

            }
            case 9: {
                boolean res = texto.startsWith("kk");
                lblResultado.setText(res + "");
                break;
            }
            }
        }
    }

