package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Controller {
    @FXML
    TextField txtTexto;
    @FXML
    ListView ListaEjer;
    @FXML
    Label lblResultado;

    @FXML
    protected void initialize() {
        ListaEjer.getItems().addAll("Ejercicio 1", "Ejercicio 2", "Validacion password");
    }
        public void procesar (ActionEvent event){
            int seleccion = ListaEjer.getSelectionModel().getSelectedIndex();
            String texto = txtTexto.getText();
            String expresion="";
         switch (seleccion){
             case 0:{
               expresion="^[^_][^p]([a-zA-Z0-9]{3,})[q]$";

                 break;
             }
             case 1: {
                 expresion="[\\+]([a-zA-Z])+";
                 break;
             }
             case 2: {
                 expresion="^-([A-Za-z0-9]{6,})";
                 break;
             }
         }
            Pattern patron = Pattern.compile(expresion);
            Matcher matchar = patron.matcher(texto);
            if(matchar.matches()) {
                lblResultado.setText("SI CUMPLE");
            }else{
                lblResultado.setText("NO CUMPLE");
            }
        }
    }


