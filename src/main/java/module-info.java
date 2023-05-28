module project {
    requires javafx.controls;
    requires javafx.fxml;
    requires jdk.internal.le;
    requires org.json;



    opens org.example.view.userView to javafx.fxml;
    exports org.example.view.userView;
}