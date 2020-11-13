package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.VBox;


public class Controller {
    @FXML
    VBox vBox;
    @FXML
    TextField txtMensaje;

    public void enter (KeyCode event){
        if(event.getCode()== KeyCode.ENTER){

            //IMPORTANTE LEER
            //Profe el getCode me marca error y no me aparece en las opciones
            //No sé a que se deba, pero el programa quiero pensar que está correcto y corre porque seguí los pasos del video :)

            Label label=new Label("Usuario dice: "txtMensaje.getText());
            vBox.getChildren().add(label);

            String respuesta= chatBot(txtMensaje.getText().toLowerCase());
            Label label2=new Label(respuesta);
            vBox.getChildren().add(label2);

        }

    }
    boolean pidioPieza=false;
    public String chatBot(String mensaje){
        String respuesta="ChatBot dice: Podrías repetir la pregunta?";
        if(mensaje.contains("hola")){
            respuesta="ChatBot dice: Muy bien y Usted? en qué lepuedo ayudar?";
        }else if (mensaje.contains("pieza")){
            respuesta="ChatBot dice: Escriba la marca, modelo y cual pieza necesita";
            pidioPieza=true;
        }else if (pidioPieza){
            String[] datos=mensaje.split("");
            String modelo=datos[1];
            int indice1= mensaje.indexOf(modelo)+modelo.length();
            int indice2 = mensaje.length();
            String pieza=mensaje.substring(indice1, indice2);
            respuesta="ChatBot dice: La pieza"+pieza+"del auto "+datos[0]+""+datos[1]+"Si tenemos la pieza en exitencia";
            pidioPieza=false;
        }
                return respuesta;

    }
}
