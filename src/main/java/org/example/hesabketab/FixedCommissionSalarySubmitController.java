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
        super.NextSubmitBtnClicked(actionEvent);
        FixedCommissionSalary newFixedCommissionSalary = new FixedCommissionSalary(StartContractDateField.getValue(), LocalDate.now().plusMonths(Integer.parseInt(ContractPeriodField.getText())), managerBase , STATUS.ACTIVE , (short) 4,Integer.parseInt(BaseTextField.getText()) ,Integer.parseInt(SoldAmountTextField.getText()), Integer.parseInt(PercentageTextField.getText()) );
        SubmitInFile(newFixedCommissionSalary);
    }
}
