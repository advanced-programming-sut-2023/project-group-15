module project {
    requires javafx.controls;
    requires javafx.fxml;
//    requires jdk.internal.le;
    requires org.json;
    requires java.datatransfer;
    requires java.desktop;


    opens org.example.view.userView to javafx.fxml;
    exports org.example.view.userView;
    opens org.example.gameMap to javafx.fxml;
    exports org.example.gameMap;
}