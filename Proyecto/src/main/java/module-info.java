module com.proyectoprueba.proyecto {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.proyectoprueba.proyecto to javafx.fxml;
    exports com.proyectoprueba.proyecto;
}