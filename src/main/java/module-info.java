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
    exports org.example.gameMap.objectSetter;
    opens org.example.gameMap.objectSetter to javafx.fxml;
    exports org.example.gameMap.tileSetter;
    opens org.example.gameMap.tileSetter to javafx.fxml;
    exports org.example.gameMap.mouseHandling;
    opens org.example.gameMap.mouseHandling to javafx.fxml;
    exports org.example.gameMap.keyHandling;
    opens org.example.gameMap.keyHandling to javafx.fxml;
}