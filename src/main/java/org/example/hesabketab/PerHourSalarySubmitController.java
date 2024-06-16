package org.example.hesabketab;

import io.github.palexdev.materialfx.controls.MFXTextField;
import javafx.event.ActionEvent;
import javafx.scene.layout.BorderPane;
import org.example.hesabketab.Employee.Employee;
import org.example.hesabketab.Employee.EmployeeDataManager;
import org.example.hesabketab.Salaries.FixedSalary;
import org.example.hesabketab.Salaries.PerHourSalary;
import org.example.hesabketab.Salaries.Salary;
import org.example.hesabketab.Status.STATUS;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class PerHourSalarySubmitController extends SubmitSalaryBaseController{
    public MFXTextField PerHourTextField;
    public MFXTextField WorkedHourTextField;

    @Override
    public void NextSubmitBtnClicked(ActionEvent actionEvent) throws Exception {
        PerHourSalary newPerHourSalary = new PerHourSalary(LocalDate.now() , LocalDate.now().minusMonths(1), 0 , STATUS.ACTIVE , (short) 2, 0, Integer.parseInt(PerHourTextField.getText()) , Integer.parseInt(WorkedHourTextField.getText()));
        SubmitInFile(newPerHourSalary);
    }
}
