package org.example.hesabketab;

import io.github.palexdev.materialfx.controls.MFXCheckbox;
import io.github.palexdev.materialfx.controls.MFXComboBox;
import io.github.palexdev.materialfx.controls.MFXDatePicker;
import io.github.palexdev.materialfx.controls.MFXTextField;
import io.github.palexdev.materialfx.utils.others.FunctionalStringConverter;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.util.StringConverter;
import org.example.hesabketab.Department.Department;
import org.example.hesabketab.Department.DepartmentDataManager;
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
    public MFXComboBox<Department> DepartmentManagerComboBox;
    public MFXDatePicker StartContractDateField;
    public MFXTextField ContractPeriodField;
    protected final EmployeeDataManager fManager = new EmployeeDataManager();
    protected final DepartmentDataManager dManager = new DepartmentDataManager();
    protected final SecureRandom random = new SecureRandom();
    String empName;
    String emplast;
    String id;
    LocalDate bd;
    GENDER gender;
    boolean isManager = false;
    int managerBase = 0;
    void initData(String firstName, String lastName, String codeID, LocalDate birthDate , GENDER gender) {
        this.empName = firstName;
        this.emplast = lastName;
        this.id = codeID;
        this.bd = birthDate;
        this.gender = gender;
        StringConverter<Department> converter = FunctionalStringConverter.to(department -> (department == null) ? "" : department.getName());
        DepartmentManagerComboBox.setItems(FXCollections.observableList(DepartmentDataManager.list));
        DepartmentManagerComboBox.setConverter(converter);
    }
    public void ManagerChecked(ActionEvent actionEvent) {
        isManager = !isManager;
    }
    protected void SubmitInFile(Salary in) throws Exception {
        Employee newEmp = new Employee(random.nextInt()%10000, empName , emplast , id , bd , new ArrayList<Salary>(List.of(in)) , ManagerCheckBox.isSelected() , STATUS.ACTIVE , gender , DepartmentManagerComboBox.getSelectedItem());
        if (ManagerCheckBox.isSelected())
        {
            DepartmentManagerComboBox.getSelectedItem().setManager(newEmp);
        }
        EmployeeDataManager.list.add(newEmp);
        fManager.UpdateFile(EmployeeDataManager.list , "Employees.ser");
        dManager.UpdateFile(DepartmentDataManager.list , "Departments.ser");
        ((BorderPane)NextSubmitBtn.getParent().getParent().getParent()).setCenter(null);
    }
    public void NextSubmitBtnClicked(ActionEvent actionEvent) throws Exception{
        if(isManager){
            managerBase = DepartmentManagerComboBox.getSelectedItem().getManagerBase();
        }
    };
}
