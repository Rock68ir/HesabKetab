package org.example.hesabketab;

import io.github.palexdev.materialfx.controls.MFXCheckbox;
import io.github.palexdev.materialfx.controls.MFXComboBox;
import javafx.event.ActionEvent;
import org.example.hesabketab.Status.GENDER;

import java.time.LocalDate;

public class FixedSalarySubmitController extends SubmitSalaryBaseController{
    @Override
    public void NextSubmitBtnClicked(ActionEvent actionEvent) {
        System.out.printf("%s%n%s%n%d%nFixed" , empName , emplast , bd.getDayOfMonth());
    }
}
