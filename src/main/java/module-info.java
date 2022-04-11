module agario.agario {
    requires javafx.controls;
    requires javafx.fxml;


    opens agario.agario to javafx.fxml;
    exports agario.agario;
}