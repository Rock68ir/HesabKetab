package org.example.hesabketab;

import io.github.palexdev.materialfx.controls.MFXComboBox;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;

public class SubmitUserController {

    public Button NextSubmitBtn;
    public MFXComboBox<String> GenderComboBox;

    public void initialize() {
        ArrayList<String> strings = new ArrayList<>();
        strings.add("Male");
        strings.add("Female");
        ObservableList<String> observableList = FXCollections.observableList(strings);
        GenderComboBox.setItems(observableList);
    }

    public void NextSubmitBtnClicked(ActionEvent actionEvent) throws IOException {
        ((BorderPane)NextSubmitBtn.getParent().getParent().getParent()).setCenter(FXMLLoader.load(Objects.requireNonNull(DashboardController.class.getResource("SubmitSalary.fxml"))));
    }
}
