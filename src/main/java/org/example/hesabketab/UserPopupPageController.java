package org.example.hesabketab;

import io.github.palexdev.materialfx.controls.*;
import io.github.palexdev.mfxresources.fonts.MFXFontIcon;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import org.example.hesabketab.Salaries.Salary;
import org.example.hesabketab.Status.GENDER;

import java.time.LocalDate;
import java.util.ArrayList;

public class UserPopupPageController {
    public VBox UserPopupVbox;
    public Label employeeFirstField;
    public Label employeeLastField;
    public Label GenderComboBox;
    public Label employeeStateField;
    public Label employeeDateField;
    public Label employeeNationalIDField;
    public MFXPaginatedTableView<Salary> paginatedSalary;
    public MFXButton LoadUserBtn;
    public MFXFontIcon UserPopupCloseBtn;
    private double xOffset = 0;
    private double yOffset = 0;

    public void initialize(){
        UserPopupVbox.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                xOffset = event.getSceneX();
                yOffset = event.getSceneY();
            }
        });
        UserPopupVbox.setOnMouseDragged(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                UserPopupVbox.getScene().getWindow().setX(event.getScreenX() - xOffset);
                UserPopupVbox.getScene().getWindow().setY(event.getScreenY() - yOffset);
            }
        });
    }
    void initData(String firstName, String lastName, String codeID, LocalDate birthDate , GENDER gender , ArrayList<Salary> salaries) {
        employeeFirstField.setText("Firstname : " + firstName);
        employeeLastField.setText("Lastname : " + lastName);
        employeeNationalIDField.setText("NationalID : " + codeID);
        employeeDateField.setText("Birthday : " + birthDate.toString());
        GenderComboBox.setText("Gender : " + gender);
    }
    public void LoadUserBtnClicked(ActionEvent actionEvent) {
    }

    public void UserPopupCloseBtnClicked(MouseEvent mouseEvent) {
        ((Stage) UserPopupCloseBtn.getScene().getWindow()).close();
    }
}
