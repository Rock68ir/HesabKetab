package org.example.hesabketab;

import io.github.palexdev.materialfx.controls.MFXComboBox;
import io.github.palexdev.materialfx.controls.MFXDatePicker;
import io.github.palexdev.materialfx.controls.MFXTextField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import org.example.hesabketab.Status.GENDER;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;

public class SubmitUserController {

    public Button NextSubmitBtn;
    public MFXComboBox<String> GenderComboBox;
    public MFXTextField employeeFirstField;
    public MFXTextField employeeLastField;
    public MFXTextField employeeNationalIDField;
    public MFXDatePicker employeeDateField;
    public MFXComboBox<String> SalaryComboBox;

    public void initialize() {
        ArrayList<String> strings = new ArrayList<>();
        strings.add("Male");
        strings.add("Female");
        ObservableList<String> observableList = FXCollections.observableList(strings);
        GenderComboBox.setItems(observableList);
        ArrayList<String> strings2 = new ArrayList<>();
        strings2.add("Fixed");
        strings2.add("PerHour");
        strings2.add("Commission");
        strings2.add("Fixed+Commission");
        ObservableList<String> observableList2 = FXCollections.observableList(strings2);
        SalaryComboBox.setItems(observableList2);
    }

    public void NextSubmitBtnClicked(ActionEvent actionEvent) throws IOException {
        String address = "";
        if(SalaryComboBox.getValue().equals("Fixed")) {
            address = address.concat("FixedSalarySubmit.fxml");
        }else if (SalaryComboBox.getValue().equals("PerHour"))
        {
            address = address.concat("PerHourSalarySubmit.fxml");
        }else if (SalaryComboBox.getValue().equals("Commission"))
        {
            address = address.concat("CommissionSalarySubmit.fxml");
        }else if (SalaryComboBox.getValue().equals("Fixed+Commission"))
        {
            address = address.concat("FixedCommissionSalarySubmit.fxml");
        }else {
            System.out.println("error");
        }
        FXMLLoader loader = new FXMLLoader(Objects.requireNonNull(DashboardController.class.getResource(address)));
        ((BorderPane)NextSubmitBtn.getParent().getParent().getParent()).setCenter(loader.load());
        SubmitSalaryBaseController controller = loader.getController();
        controller.initData(employeeFirstField.getText() , employeeLastField.getText() , employeeNationalIDField.getText() , employeeDateField.getValue() , GENDER.valueOf(GenderComboBox.getValue().toUpperCase()));
    }
}
