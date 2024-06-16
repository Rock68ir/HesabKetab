package org.example.hesabketab;

import io.github.palexdev.materialfx.controls.MFXCheckbox;
import io.github.palexdev.materialfx.controls.MFXComboBox;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import org.example.hesabketab.Employee.Employee;
import org.example.hesabketab.Employee.EmployeeDataManager;
import org.example.hesabketab.Salaries.Salary;
import org.example.hesabketab.Status.GENDER;
import org.example.hesabketab.Status.STATUS;

import java.security.SecureRandom;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public abstract class SubmitSalaryBaseController {
    public Button NextSubmitBtn;
    public MFXCheckbox ManagerCheckBox;
    public MFXComboBox<String> DepartmentManagerComboBox;
    protected final EmployeeDataManager fManager = new EmployeeDataManager();
    protected final SecureRandom random = new SecureRandom();
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
    protected void SubmitInFile(Salary in) throws Exception {
        Employee newEmp = new Employee(random.nextInt()%10000, empName , emplast , id , bd , new ArrayList<Salary>(List.of(in)) , ManagerCheckBox.isSelected() , STATUS.ACTIVE , gender);
        EmployeeDataManager.list.add(newEmp);
        System.out.printf("%s%n%s%n%d%nCommission" , empName , emplast , bd.getDayOfMonth());
        fManager.UpdateFile(EmployeeDataManager.list , "Employees.ser");
        ((BorderPane)NextSubmitBtn.getParent().getParent().getParent()).setCenter(null);
    }
    public abstract void NextSubmitBtnClicked(ActionEvent actionEvent) throws Exception;
}
