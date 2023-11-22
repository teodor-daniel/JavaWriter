module example.javawriter {
    requires javafx.controls;
    requires javafx.fxml;


    opens App.javawriter to javafx.fxml;
    exports App.javawriter;
}