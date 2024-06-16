package org.example.hesabketab;

import io.github.palexdev.materialfx.controls.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import org.example.hesabketab.Employee.Employee;
import org.example.hesabketab.Employee.EmployeeDataManager;

import java.util.Objects;

public class HelloController {
    public BorderPane mainBorderPane;
    public MFXButton mfxLoginBtn;
    public MFXTextField textField;
    public MFXPasswordField passwordField;

    public void LoginClicked(ActionEvent mouseEvent) throws Exception {
        if (textField.getText().equals("") && passwordField.getText().equals("")) {
            EmployeeDataManager fManager = new EmployeeDataManager();
            EmployeeDataManager.list = fManager.ReadFile("Employees.ser");
            Stage window = (Stage) (mainBorderPane.getScene().getWindow());
            window.setScene(new Scene(FXMLLoader.load(Objects.requireNonNull(HelloApplication.class.getResource("Dashboard.fxml")))));
        }
    }
}