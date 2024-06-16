package org.example.hesabketab;

import io.github.palexdev.materialfx.controls.MFXTextField;
import javafx.event.ActionEvent;
import org.example.hesabketab.Salaries.FixedCommissionSalary;
import org.example.hesabketab.Status.STATUS;

import java.time.LocalDate;

public class FixedCommissionSalarySubmitController extends SubmitSalaryBaseController{
    public MFXTextField PercentageTextField;
    public MFXTextField SoldAmountTextField;
    public MFXTextField BaseTextField;

    public void NextSubmitBtnClicked(ActionEvent actionEvent) throws Exception {
        FixedCommissionSalary newFixedCommissionSalary = new FixedCommissionSalary(LocalDate.now() , LocalDate.now().minusMonths(1), 0 , STATUS.ACTIVE , (short) 4,Integer.parseInt(BaseTextField.getText()) ,Integer.parseInt(SoldAmountTextField.getText()), Integer.parseInt(PercentageTextField.getText()) );
        SubmitInFile(newFixedCommissionSalary);
    }
}
