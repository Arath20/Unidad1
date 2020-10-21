package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class Controller {
    @FXML
    TextArea txtReceta, txtIngredientes, txtPreparacion, txtPreguntas;
    @FXML
    Label lblLineas;

    @FXML
    protected void initialize(){
        try {
            File f = new File("./src/sample/Receta.txt");
            BufferedReader br = new BufferedReader((new FileReader(f)));
            String texto = "";
            while ((texto = br.readLine()) != null) {
                txtReceta.appendText("\n" + texto);
            }
        } catch (Exception e) {
            txtReceta.setText(e.getMessage());
        }
    }

    public void procesar(ActionEvent event) {
        String[] arregloLineas = txtReceta.getText().split("\n");
        lblLineas.setText("Lineas:" + arregloLineas.length);

    }

    //public void mostrar (ActionEvent event){
    //String texto = txtReceta.getText();
    //case0:{
    //char res=texto.charAt(2);
    //txtIngredientes.setText(res+"");

    //}

    }
          //public void casos () {
          //txtIngredientes.clear();
          //txtPreparacion.clear();
          //txtPreguntas.clear();
          //}

