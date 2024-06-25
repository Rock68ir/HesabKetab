package org.example.hesabketab;

import io.github.palexdev.materialfx.controls.MFXButton;
import io.github.palexdev.materialfx.controls.MFXFilterComboBox;
import io.github.palexdev.materialfx.controls.MFXTextField;
import io.github.palexdev.materialfx.utils.StringUtils;
import io.github.palexdev.materialfx.utils.others.FunctionalStringConverter;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.BorderPane;
import javafx.util.StringConverter;
import org.example.hesabketab.Department.Department;
import org.example.hesabketab.Department.DepartmentDataManager;
import org.example.hesabketab.Employee.Employee;
import org.example.hesabketab.Employee.EmployeeDataManager;
import org.example.hesabketab.Employee.EmployeeSearch;

import java.util.function.Function;
import java.util.function.Predicate;

public class SubmitDepartmentController {
    public MFXTextField departmentNameField;
    public MFXFilterComboBox<Employee> ManagerComboBox;
    public MFXTextField ManagerBaseSalaryField;
    public MFXButton NextSubmitBtn;
    private final EmployeeSearch searcher = new EmployeeSearch();
    public void initialize(){
        StringConverter<Employee> converter = FunctionalStringConverter.to(employee -> (employee == null) ? "" : employee.getLastName() + " " + employee.getCodeID());
        Function<String, Predicate<Employee>> filterFunction = s -> person -> StringUtils.containsIgnoreCase(converter.toString(person), s);
        ManagerComboBox.setItems(FXCollections.observableList(searcher.FindByManager(false)));
        ManagerComboBox.setConverter(converter);
        ManagerComboBox.setFilterFunction(filterFunction);
    }

    public void NextSubmitBtnClicked(ActionEvent actionEvent) throws Exception {
        Department newDep = new Department(ManagerComboBox.getSelectedItem(), departmentNameField.getText() , Integer.parseInt(ManagerBaseSalaryField.getText()));
        DepartmentDataManager.list.add(newDep);
        if(ManagerComboBox.getSelectedItem() != null){
            ManagerComboBox.getSelectedItem().setDepartment(newDep);
            ManagerComboBox.getSelectedItem().setManager(true);
            EmployeeDataManager fManager = new EmployeeDataManager();
            fManager.UpdateFile(EmployeeDataManager.list , "Employees.ser");
        }
        System.out.println("kk");
        DepartmentDataManager dManager = new DepartmentDataManager();
        dManager.UpdateFile(DepartmentDataManager.list , "Departments.ser");
        ((BorderPane)NextSubmitBtn.getParent().getParent().getParent()).setCenter(null);
    }
}
