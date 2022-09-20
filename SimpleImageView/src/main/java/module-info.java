module com.example.simpleimageview {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.simpleimageview to javafx.fxml;
    exports com.example.simpleimageview;
}