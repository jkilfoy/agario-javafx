module agario {
    requires javafx.controls;
    requires javafx.fxml;

    exports agario;
    opens agario to javafx.fxml;
}