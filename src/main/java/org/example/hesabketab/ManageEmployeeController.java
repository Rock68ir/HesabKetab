package org.example.hesabketab;

import io.github.palexdev.materialfx.controls.MFXButton;
import io.github.palexdev.materialfx.controls.MFXPaginatedTableView;
import io.github.palexdev.materialfx.controls.MFXTableColumn;
import io.github.palexdev.materialfx.controls.cell.MFXTableRowCell;
import io.github.palexdev.materialfx.filter.EnumFilter;
import io.github.palexdev.materialfx.filter.IntegerFilter;
import io.github.palexdev.materialfx.filter.StringFilter;
import io.github.palexdev.materialfx.filter.base.AbstractFilter;
import io.github.palexdev.materialfx.utils.StringUtils;
import io.github.palexdev.materialfx.utils.others.FunctionalStringConverter;
import io.github.palexdev.materialfx.utils.others.observables.When;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.util.StringConverter;
import org.example.hesabketab.Department.Department;
import org.example.hesabketab.Employee.Employee;
import org.example.hesabketab.Employee.EmployeeDataManager;
import org.example.hesabketab.Salaries.Salary;
import org.example.hesabketab.Status.GENDER;
import org.example.hesabketab.Status.STATUS;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.function.Function;
import java.util.function.Predicate;

public class ManageEmployeeController{
    public MFXButton LoadUserBtn;
    @FXML
    private MFXPaginatedTableView<Employee> paginated;
    public void initialize() {
        setupPaginated();

        paginated.autosizeColumnsOnInitialization();

        When.onChanged(paginated.currentPageProperty())
                .then((oldValue, newValue) -> paginated.autosizeColumns())
                .listen();
    }
    private void setupPaginated() {
        MFXTableColumn<Employee> idColumn = new MFXTableColumn<>("ID", false, Comparator.comparing(Employee::getCodeID));
        MFXTableColumn<Employee> firstNameColumn = new MFXTableColumn<>("First Name", false, Comparator.comparing(Employee::getFirstName));
        MFXTableColumn<Employee> lastNameColumn = new MFXTableColumn<>("Last Name", false, Comparator.comparing(Employee::getLastName));
        MFXTableColumn<Employee> birthDayColumn = new MFXTableColumn<>("Birthday", false, Comparator.comparing(Employee::getBirthDate));
        MFXTableColumn<Employee> genderColumn = new MFXTableColumn<>("Gender", false, Comparator.comparing(Employee::getGender));
        MFXTableColumn<Employee> statusColumn = new MFXTableColumn<>("Status", false, Comparator.comparing(Employee::getStatus));
        MFXTableColumn<Employee> managerColumn = new MFXTableColumn<>("Manager", false, Comparator.comparing(Employee::isManager));
        MFXTableColumn<Employee> salarycolumn = new MFXTableColumn<>("CurrentSalary", false);

        idColumn.setRowCellFactory(employee -> new MFXTableRowCell<>(Employee::getCodeID));
        firstNameColumn.setRowCellFactory(employee -> new MFXTableRowCell<>(Employee::getFirstName));
        lastNameColumn.setRowCellFactory(employee -> new MFXTableRowCell<>(Employee::getLastName));
        birthDayColumn.setRowCellFactory(employee -> new MFXTableRowCell<>(Employee::getBirthDate));
        genderColumn.setRowCellFactory(employee -> new MFXTableRowCell<>(Employee::getGender));
        statusColumn.setRowCellFactory(employee -> new MFXTableRowCell<>(Employee::getStatus));
        managerColumn.setRowCellFactory(employee -> new MFXTableRowCell<>(Employee::isManager));
        Function<Employee, String> filterFunction = s -> s.getSalaries().getLast().toString();
        salarycolumn.setRowCellFactory(employee -> new MFXTableRowCell<>(filterFunction));
        statusColumn.setAlignment(Pos.CENTER_RIGHT);

        paginated.getTableColumns().addAll(idColumn, firstNameColumn, lastNameColumn, birthDayColumn, genderColumn , statusColumn , managerColumn);
        paginated.getFilters().addAll(
                new IntegerFilter<>("ID", Employee::getID),
                new StringFilter<>("Firstname", Employee::getFirstName),
                new StringFilter<>("Lastname", Employee::getLastName),
                new EnumFilter<>("Gender", Employee::getGender, GENDER.class),
                new EnumFilter<>("Status" , Employee::getStatus , STATUS.class)
        );
        paginated.setItems(FXCollections.observableList(EmployeeDataManager.list));
    }

    public void LoadUserBtnClicked(ActionEvent actionEvent) throws IOException {
        if (paginated.getSelectionModel().getSelectedValue() != null) {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("UserPopupPage.fxml"));
            ((BorderPane)LoadUserBtn.getParent().getParent()).setCenter(fxmlLoader.load());
            UserPopupPageController controller = fxmlLoader.getController();
            controller.initData(paginated.getSelectionModel().getSelectedValue().getFirstName() , paginated.getSelectionModel().getSelectedValue().getLastName()
                    , paginated.getSelectionModel().getSelectedValue().getCodeID() , paginated.getSelectionModel().getSelectedValue().getBirthDate()
                    , paginated.getSelectionModel().getSelectedValue().getGender(), paginated.getSelectionModel().getSelectedValue().getSalaries()
                    , paginated.getSelectionModel().getSelectedValue().getStatus());
            System.out.println("Dd");
            System.out.println("You clicked on " + paginated.getSelectionModel().getSelectedValue().getSalaries().getFirst().CalcuteIncome());
        }
    }
}
