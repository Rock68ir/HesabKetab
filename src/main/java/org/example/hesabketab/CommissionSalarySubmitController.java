package org.example.hesabketab;

import javafx.event.ActionEvent;

public class CommissionSalarySubmitController extends SubmitSalaryBaseController{
    @Override
    public void NextSubmitBtnClicked(ActionEvent actionEvent) {
        System.out.printf("%s%n%s%n%d%nCommission" , empName , emplast , bd.getDayOfMonth());
    }
}
