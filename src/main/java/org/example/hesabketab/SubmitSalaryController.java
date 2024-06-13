package org.example.hesabketab;

import io.github.palexdev.materialfx.controls.MFXComboBox;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;

import java.util.ArrayList;

public class SubmitSalaryController {

    public MFXComboBox<String> SalaryComboBox;

    public void initialize() {
        ArrayList<String> strings = new ArrayList<>();
        strings.add("Fixed");
        strings.add("PerHour");
        strings.add("Commission");
        strings.add("Fixed+Commission");
        ObservableList<String> observableList = FXCollections.observableList(strings);
        SalaryComboBox.setItems(observableList);
    }
    public void NextSubmitBtnClicked(ActionEvent actionEvent) {
        System.out.println("sss");
    }
}
