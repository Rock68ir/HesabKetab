package org.example.hesabketab;

import javafx.event.ActionEvent;

public class PerHourSalarySubmitController extends SubmitSalaryBaseController{
    @Override
    public void NextSubmitBtnClicked(ActionEvent actionEvent) {
        System.out.printf("%s%n%s%n%d%nPerHour" , empName , emplast , bd.getDayOfMonth());
    }
}
