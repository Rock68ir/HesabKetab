package org.example.hesabketab;

import io.github.palexdev.materialfx.controls.*;
import javafx.event.ActionEvent;
import org.example.hesabketab.Salaries.Salary;
import org.example.hesabketab.Status.GENDER;

import java.time.LocalDate;

public class UserPopupPageController {
    public MFXTextField employeeFirstField;
    public MFXTextField employeeLastField;
    public MFXComboBox<GENDER> GenderComboBox;
    public MFXTextField employeeStateField;
    public MFXDatePicker employeeDateField;
    public MFXTextField employeeNationalIDField;
    public MFXPaginatedTableView<Salary> paginatedSalary;
    public MFXButton LoadUserBtn;
    String empName;
    String emplast;
    String id;
    LocalDate bd;
    GENDER gender;
    void initData(String firstName, String lastName, String codeID, LocalDate birthDate , GENDER gender) {
        employeeFirstField.setText(firstName);
        employeeLastField.setText(lastName);
        employeeNationalIDField.setText(codeID);
        employeeDateField.setValue(birthDate);
        GenderComboBox.setText(String.valueOf(gender));

    }
    public void LoadUserBtnClicked(ActionEvent actionEvent) {
    }
}
