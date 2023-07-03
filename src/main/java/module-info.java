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
    exports org.example.view;
    opens org.example.view to javafx.fxml;
    exports org.example.model;
    opens org.example.model to javafx.fxml;
    exports org.example.controller;
    opens org.example.controller;
    exports org.example.model.gameData;
    opens org.example.model.gameData;
}