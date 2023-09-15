module to.grindelf.circuitclash {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires net.synedra.validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires com.almasb.fxgl.all;
    requires annotations;

    opens to.grindelf.circuitclash to javafx.fxml;
    exports to.grindelf.circuitclash;
    exports to.grindelf.circuitclash.controllers;
    opens to.grindelf.circuitclash.controllers to javafx.fxml;

    exports to.grindelf.circuitclash.domain;
}