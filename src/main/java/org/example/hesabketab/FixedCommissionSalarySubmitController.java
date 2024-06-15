package org.example.hesabketab;

import javafx.event.ActionEvent;

public class FixedCommissionSalarySubmitController extends SubmitSalaryBaseController{
    public void NextSubmitBtnClicked(ActionEvent actionEvent) {
        System.out.printf("%s%n%s%n%d%nFixedCommission" , empName , emplast , bd.getDayOfMonth());
    }
}
