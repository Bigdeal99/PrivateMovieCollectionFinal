module com.pmc.privatemoviecollectionfinal {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.bootstrapfx.core;
    requires javafx.media;

    opens com.pmc.privatemoviecollectionfinal to javafx.fxml;
    exports com.pmc.privatemoviecollectionfinal;
    exports com.pmc.privatemoviecollectionfinal.gui.controllers;
    opens com.pmc.privatemoviecollectionfinal.gui.controllers to javafx.fxml;
}