module com.example.calisma_04_01_2022 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires mysql.connector.java;


    opens com.example.java_proje to javafx.fxml;
    exports com.example.java_proje;
}