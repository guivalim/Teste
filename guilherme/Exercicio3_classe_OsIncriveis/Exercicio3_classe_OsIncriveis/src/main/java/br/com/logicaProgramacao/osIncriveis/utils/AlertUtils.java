package br.com.logicaProgramacao.osIncriveis.utils;

import javafx.scene.control.Alert;

public class AlertUtils {

    // Alerta de aviso genérico
    public static void mostrarAlerta(String titulo, String mensagem) {
        Alert alerta = new Alert(Alert.AlertType.WARNING);
        alerta.setTitle(titulo);
        alerta.setHeaderText(null);
        alerta.setContentText(mensagem);
        alerta.showAndWait();
    }

}
