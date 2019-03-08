package sample.Eventos;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.TextField;

import java.awt.event.WindowEvent;

public class EventosCalculadora implements EventHandler {

    String valor;
    TextField txtOperacion;

    public EventosCalculadora(String valor, TextField txtOp){
        this.valor = valor;
        txtOperacion = txtOp;
    }

    @Override
    public void handle(Event event) {
        switch (valor){
            case "0":
            case "1":
            case "2":
            case "3":
            case "4":
            case "5":
            case "6":
            case "7":
            case "8":
            case "9": txtOperacion.appendText(valor);
                break;
            case "+":
            case "-":
            case "*":
            case "/":
                break;
        }
    }
}
