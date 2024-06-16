package org.example.hesabketab;

import io.github.palexdev.materialfx.controls.MFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.BorderPane;
import org.example.hesabketab.Employee.Employee;
import org.example.hesabketab.Employee.EmployeeDataManager;
import org.example.hesabketab.Salaries.FixedSalary;
import org.example.hesabketab.Salaries.Salary;
import org.example.hesabketab.Status.STATUS;

import java.security.SecureRandom;
import java.time.LocalDate;
import java.util.ArrayList;

public class FixedSalarySubmitController extends SubmitSalaryBaseController{
    public MFXTextField BaseSalaryTextField;
    private final EmployeeDataManager fManager = new EmployeeDataManager();
    private final SecureRandom random = new SecureRandom();

    @Override
    public void NextSubmitBtnClicked(ActionEvent actionEvent) throws Exception {
        FixedSalary newFixSalary = new FixedSalary(LocalDate.now() , LocalDate.now().minusMonths(1), 0 , STATUS.ACTIVE , (short) 1, Integer.parseInt(BaseSalaryTextField.getText()));
        ArrayList<Salary> temp = new ArrayList<>();
        temp.add(newFixSalary);
        Employee newEmp = new Employee(random.nextInt()%10000, empName , emplast , id , bd , temp , ManagerCheckBox.isSelected() , STATUS.ACTIVE , gender);
        EmployeeDataManager.list.add(newEmp);
        System.out.printf("%s%n%s%n%d%nFixed" , empName , emplast , bd.getDayOfMonth());
        fManager.UpdateFile(EmployeeDataManager.list , "Employees.ser");
        ((BorderPane)NextSubmitBtn.getParent().getParent().getParent()).setCenter(null);
    }
}
