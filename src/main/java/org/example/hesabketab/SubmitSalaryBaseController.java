package org.example.hesabketab;

import io.github.palexdev.materialfx.controls.MFXCheckbox;
import io.github.palexdev.materialfx.controls.MFXComboBox;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import org.example.hesabketab.Status.GENDER;

import java.time.LocalDate;

public abstract class SubmitSalaryBaseController {
    public Button NextSubmitBtn;
    public MFXCheckbox ManagerCheckBox;
    public MFXComboBox<String> DepartmentManagerComboBox;
    String empName;
    String emplast;
    String id;
    LocalDate bd;
    GENDER gender;
    void initData(String firstName, String lastName, String codeID, LocalDate birthDate , GENDER gender) {
        this.empName = firstName;
        this.emplast = lastName;
        this.id = codeID;
        this.bd = birthDate;
        this.gender = gender;
    }
    public void ManagerChecked(ActionEvent actionEvent) {
        DepartmentManagerComboBox.setDisable(!DepartmentManagerComboBox.isDisable());
        DepartmentManagerComboBox.setVisible(!DepartmentManagerComboBox.isVisible());
    }
    public abstract void NextSubmitBtnClicked(ActionEvent actionEvent);
}
