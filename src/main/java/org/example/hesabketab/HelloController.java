package org.example.hesabketab;

import io.github.palexdev.materialfx.controls.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class HelloController {
    public BorderPane mainBorderPane;
    public MFXButton mfxLoginBtn;
    public MFXTextField textField;
    public MFXPasswordField passwordField;

    public void LoginClicked(ActionEvent mouseEvent) throws IOException {
        if (textField.getText().equals("") && passwordField.getText().equals("")) {
            Stage window = (Stage) (mainBorderPane.getScene().getWindow());
            window.setScene(new Scene(FXMLLoader.load(Objects.requireNonNull(HelloApplication.class.getResource("Dashboard.fxml")))));
        }
    }
    public void initialize() {

//        FadeTransition fadeIn = new FadeTransition(Duration.millis(300) , LoginBtn);
//        fadeIn.setToValue(0.7);
//        FadeTransition fadeOut = new FadeTransition(Duration.millis(300) , LoginBtn);
//        fadeOut.setToValue(1);
//
//        LoginBtn.setOnMouseEntered(e->{
//            fadeIn.play();
//        });
//        LoginBtn.setOnMouseExited(e->{
//            fadeOut.play();
//            LoginBtn.setStyle("-fx-background-color: #57b846;");
//        });
    }
}