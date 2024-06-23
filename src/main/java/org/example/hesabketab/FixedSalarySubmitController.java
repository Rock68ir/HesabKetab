package org.example.hesabketab;

import io.github.palexdev.materialfx.controls.MFXTextField;
import javafx.event.ActionEvent;
import org.example.hesabketab.Salaries.FixedSalary;
import org.example.hesabketab.Status.STATUS;

import java.time.LocalDate;

public class FixedSalarySubmitController extends SubmitSalaryBaseController{
    public MFXTextField BaseSalaryTextField;

    @Override
    public void NextSubmitBtnClicked(ActionEvent actionEvent) throws Exception {
        super.NextSubmitBtnClicked(actionEvent);
        FixedSalary newFixSalary = new FixedSalary(StartContractDateField.getValue(), LocalDate.now().plusMonths(Integer.parseInt(ContractPeriodField.getText())), managerBase , STATUS.ACTIVE , (short) 1, Integer.parseInt(BaseSalaryTextField.getText()));
        SubmitInFile(newFixSalary);
    }
}
