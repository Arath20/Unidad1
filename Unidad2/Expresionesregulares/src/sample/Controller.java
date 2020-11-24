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
        ListaEjer.getItems().addAll("Ejercicio 1", "Ejercicio 2", "Validacion Grupo",
                "Palabra Guion", "No comenzar con db", "Terminar con count","Pancho Villa",
                "MAC ADDRESS", "Mayuscula-Minuscula","Numero Binario", "Operacion 1 digito",
                "No Control","CURP", "Precio", "Tarjeta de Credito", "HTML", "Color Hexadecimal", "URL",
                "Query SQL","Secuencia If","Salto de linea","URL YouTube");
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
                 expresion="^(ISC)-([1-9])[A|B]$";
                 break;
             }
             case 3: {
                 expresion="([A-Za-z]{1,})[_]([A-Za-z]{1,})";
                 break;
             }
             case 4: {
                 expresion="([^db])[A-Za-z]{1,}";
                 break;
             }
             case 5: {
                 expresion="^(SUMA)-([1-9]{1,})(count$)";
                 break;
             }
             case 6: {
                 expresion="([A-Za-z]{1,})[\\s]([A-Za-z]{1,})";
                 break;
             }
             case 7: {
                 expresion="([A-Z0-9]{1,})-([0-9]{1,})-([A-Z0-9]{1,})-([A-Z]{1,})-([0-9A-Z]{1,})-([0-9]{1,})";
                 break;
             }
             case 8: {
                 expresion="(^[A-Z]{1,}+[a-z]{1,}$)";
                 break;
             }
             case 9: {
                 expresion="[0-1]{1,8}";
                 break;
             }
             case 10: {
                 expresion="([1-9]{1,})[+]([1-9]{1,})";
                 break;
             }
             case 11: {
                 expresion = "(^[0-9]{2})+[A-Z]{1,}+[0-9]{1,}";
                 break;
             }
             case 12: {
                 expresion="\"^[A-Z]{1}[AEIOU]{1}[A-Z]{2}[0-9]{2}(0[1-9]|1[0-2])(0[1-9]|1[0-9]|20-9|3[0-3])" +
                           "[HM]{1}(AS|BC|BS|CC|CS|CH|CL|CM|DF|DG|GT|GR|HG|JC|MC|MN|MS|NT|NL|OC|PL|QT|QR|SP|SL|SR|TC|TS|TL|VZ|YN|ZS|NE)" +
                           "[B-DF-HJ-NP-TV-Z]{3}[0-9A-Z]{1}[0-9]{1}$";
                 break;
             }
             case 13: {
                 expresion = "^(\\$)([0-9]{1,})[\\.]([0]{1,})(mxn$)";//Precio
                 break;
             }
             case 14: {
                 expresion="^3[47][0-9]{1,}$"; //Tarjeta
                 break;
             }
             case 15: {
                 expresion="^(<p>)([A-Za-z]{1,})(</p>)$"; //HTML
                 break;
             }
             case 16: {
                 expresion=""; //PENDIENTE COLOR HEXADECIMAL (CON ESTE SI NO SUPE NI QUE SHOW )
                 break;
             }
             case 17: {
                 expresion="^(http://)([\\w]{1,})[\\.]([a-z0-9]{1,})(.com)$"; //URL
                 break;
             }
             case 18: {
                 expresion=""; // PENDIENTE SQL
                 break;
             }
             case 19: {
                 expresion=""; // PENDIENTE IF
                 break;
             }
             case 20: {
                 expresion="^([A-Za-z0-9]{1,})[\n]([A-Za-z0-9]{1,})"; //FRASE SALTO DE LINEA
                 break;
             }
             case 21: {
                 expresion = "^(http://)(www.)(Youtube.com/watch=)([A-Za-z0-9]{1,})"; //URL YOUTUBE
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


