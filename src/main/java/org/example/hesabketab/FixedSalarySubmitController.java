package org.example.hesabketab;

import javafx.event.ActionEvent;

public class FixedSalarySubmitController extends SubmitSalaryBaseController{
    @Override
    public void NextSubmitBtnClicked(ActionEvent actionEvent) {
        System.out.printf("%s%n%s%n%d%nFixed" , empName , emplast , bd.getDayOfMonth());
    }
}
