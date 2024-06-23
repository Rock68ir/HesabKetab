module org.example.hesabketab {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires net.synedra.validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;
    requires com.almasb.fxgl.all;
    requires MaterialFX;
    requires fr.brouillard.oss.cssfx;
    requires java.management;

    opens org.example.hesabketab to javafx.fxml;
    exports org.example.hesabketab;
    exports org.example.hesabketab.Employee;
    exports org.example.hesabketab.Department;
    opens org.example.hesabketab.Department to javafx.fxml;
}