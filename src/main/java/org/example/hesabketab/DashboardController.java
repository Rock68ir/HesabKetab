package org.example.hesabketab;

import javafx.animation.AnimationTimer;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import org.example.hesabketab.Employee.Employee;
import org.example.hesabketab.Employee.EmployeeDataManager;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public class DashboardController {
    public VBox dashboardMenu;
    public Pane DashboardTime;
    public Label timeLabel;
    public BorderPane DashboardBorderpane;
    public Button SubmitUserMenu;
    public Button NextSubmitBtn;
    public Button ManageEmployeeSideBtn;
    public Button AddDepartmentSideBtn;

    AnimationTimer timer = new AnimationTimer() {
        @Override
        public void handle(long now) {
            timeLabel.setText(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
        }
    };
    public void OnBurgerClicked(MouseEvent mouseEvent) throws IOException {

        if(DashboardBorderpane.getLeft() == null)
            DashboardBorderpane.setLeft(FXMLLoader.load(Objects.requireNonNull(DashboardController.class.getResource("MainSidebar.fxml"))));
        else
            DashboardBorderpane.setLeft(null);
    }
    public void initialize() {
        if(timeLabel != null)
            timer.start();
    }
    public void SubmitUserButtonClicked(MouseEvent actionEvent) throws IOException {
        ((BorderPane)dashboardMenu.getParent()).setCenter(FXMLLoader.load(Objects.requireNonNull(DashboardController.class.getResource("SubmitUser.fxml"))));
    }


    public void ManageEmployeeClicked(ActionEvent actionEvent) throws IOException {
        ((BorderPane)dashboardMenu.getParent()).setCenter(FXMLLoader.load(Objects.requireNonNull(DashboardController.class.getResource("ManageEmployee.fxml"))));
    }

    public void AddDepartmentClicked(ActionEvent actionEvent) throws IOException {
        ((BorderPane)dashboardMenu.getParent()).setCenter(FXMLLoader.load(Objects.requireNonNull(DashboardController.class.getResource("SubmitDepartment.fxml"))));
    }
}
