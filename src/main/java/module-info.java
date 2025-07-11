module com.example.laberinto {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;
    requires static lombok;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires net.synedra.validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
//    requires eu.hansolo.tilesfx;
    requires com.almasb.fxgl.all;
    requires com.fasterxml.jackson.databind;
    requires com.fasterxml.jackson.core;
    requires java.desktop;

    opens com.example.laberinto to javafx.fxml;
    exports com.example.laberinto;
    exports com.example.laberinto.model;
}