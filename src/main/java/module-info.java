module com.example.javafxpt2 {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.bootstrapfx.core;

    opens com.example.javafxpt2 to javafx.fxml;
    exports com.example.javafxpt2;
}