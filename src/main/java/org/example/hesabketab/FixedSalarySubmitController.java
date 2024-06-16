package org.example.hesabketab;

import io.github.palexdev.materialfx.controls.MFXTextField;
import javafx.event.ActionEvent;
import javafx.scene.layout.BorderPane;
import org.example.hesabketab.Employee.Employee;
import org.example.hesabketab.Employee.EmployeeDataManager;
import org.example.hesabketab.Salaries.FixedSalary;
import org.example.hesabketab.Salaries.Salary;
import org.example.hesabketab.Status.STATUS;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class FixedSalarySubmitController extends SubmitSalaryBaseController{
    public MFXTextField BaseSalaryTextField;

    @Override
    public void NextSubmitBtnClicked(ActionEvent actionEvent) throws Exception {
        FixedSalary newFixSalary = new FixedSalary(LocalDate.now() , LocalDate.now().minusMonths(1), 0 , STATUS.ACTIVE , (short) 1, Integer.parseInt(BaseSalaryTextField.getText()));
        SubmitInFile(newFixSalary);
    }
}
