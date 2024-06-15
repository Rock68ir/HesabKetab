package org.example.hesabketab;

import io.github.palexdev.materialfx.controls.MFXCheckbox;
import io.github.palexdev.materialfx.controls.MFXComboBox;
import javafx.event.ActionEvent;
import org.example.hesabketab.Status.GENDER;

import java.time.LocalDate;

public class PerHourSalarySubmitController {
    public MFXCheckbox ManagerCheckBox;
    public MFXComboBox<String> DepartmentManagerComboBox;
    private String empName;
    private String emplast;
    private String id;
    private LocalDate bd;
    private GENDER gender;
    void initData(String firstName, String lastName, String codeID, LocalDate birthDate , GENDER gender) {
        this.empName = firstName;
        this.emplast = lastName;
        this.id = codeID;
        this.bd = birthDate;
        this.gender = gender;
    }
    public void NextSubmitBtnClicked(ActionEvent actionEvent) {
        System.out.printf("%s%n%s%n%d" , empName , emplast , bd.getDayOfMonth());
    }

    public void ManagerChecked(ActionEvent actionEvent) {
        DepartmentManagerComboBox.setDisable(!DepartmentManagerComboBox.isDisable());
        DepartmentManagerComboBox.setVisible(!DepartmentManagerComboBox.isVisible());
    }
}
