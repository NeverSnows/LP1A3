module com.example.javafx_newproject {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.javafx_newproject to javafx.fxml;
    exports com.example.javafx_newproject;
}