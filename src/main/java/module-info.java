module org.example.gagrics_admin_app {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.json;
    requires okhttp3;
    requires annotations;


    opens org.example.gagrics_admin_app to javafx.fxml;
    exports org.example.gagrics_admin_app;
}