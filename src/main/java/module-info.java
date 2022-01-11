module com.pmc.privatemoviecollectionfinal {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.bootstrapfx.core;
    requires javafx.media;
    requires java.sql;
    requires java.desktop;

    opens PrivateMovieCollectionFinal to javafx.fxml;
    exports PrivateMovieCollectionFinal;
    exports PrivateMovieCollectionFinal.gui.controllers;
    opens PrivateMovieCollectionFinal.gui.controllers to javafx.fxml;
}