module com.pmc.privatemoviecollectionfinal {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.bootstrapfx.core;
    requires javafx.media;
    requires java.sql;
    requires java.desktop;
    requires com.microsoft.sqlserver.jdbc;
    requires java.naming;

    opens PrivateMovieCollectionFinal to javafx.fxml;
    opens PrivateMovieCollectionFinal.be to javafx.fxml;
    opens PrivateMovieCollectionFinal.gui.controllers to javafx.fxml;

    exports PrivateMovieCollectionFinal.be;
    exports PrivateMovieCollectionFinal;
    exports PrivateMovieCollectionFinal.gui.controllers;

}