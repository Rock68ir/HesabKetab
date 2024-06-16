package org.example.hesabketab;

import io.github.palexdev.materialfx.controls.MFXTextField;
import javafx.event.ActionEvent;
import javafx.scene.layout.BorderPane;
import org.example.hesabketab.Employee.Employee;
import org.example.hesabketab.Employee.EmployeeDataManager;
import org.example.hesabketab.Salaries.CommissionSalary;
import org.example.hesabketab.Salaries.FixedSalary;
import org.example.hesabketab.Salaries.PerHourSalary;
import org.example.hesabketab.Salaries.Salary;
import org.example.hesabketab.Status.STATUS;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class CommissionSalarySubmitController extends SubmitSalaryBaseController{
    public MFXTextField SoldAmountTextField;
    public MFXTextField PercentageTextField;

    @Override
    public void NextSubmitBtnClicked(ActionEvent actionEvent) throws Exception {
        CommissionSalary newCommissionSalary = new CommissionSalary(LocalDate.now() , LocalDate.now().minusMonths(1), 0 , STATUS.ACTIVE , (short) 3, Integer.parseInt(SoldAmountTextField.getText()), Integer.parseInt(PercentageTextField.getText()) );
        SubmitInFile(newCommissionSalary);
    }
}
