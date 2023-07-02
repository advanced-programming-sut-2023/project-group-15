package org.example.view;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.MapValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.util.Callback;
import javafx.util.StringConverter;
import org.example.Server.gameData.GameDataBase;

import java.util.HashMap;
import java.util.Map;

public class ScoreBoard extends Application {
    public static final String Column1MapKey = "rank";
    public static final String Column2MapKey ="Name";
    public static final String Column3MapKey = "HighScore";


    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        Scene scene = new Scene(new Group());
        stage.setTitle("scoreBoard");
        stage.setWidth(350);
        stage.setHeight(500);

        final Label label = new Label("ScoreBoard");
        label.setFont(new Font("Arial", 20));

        TableColumn<Map, String> firstDataColumn = new TableColumn<>("rank");
        TableColumn<Map, String> secondDataColumn = new TableColumn<>("name");
        TableColumn<Map , String> thirdDataColumn = new TableColumn<>("highScore");
        ;

        firstDataColumn.setCellValueFactory(new MapValueFactory(Column1MapKey));
        firstDataColumn.setMinWidth(30);
        secondDataColumn.setCellValueFactory(new MapValueFactory(Column2MapKey));
        secondDataColumn.setMinWidth(100);
        thirdDataColumn.setCellValueFactory(new MapValueFactory<>(Column3MapKey));
        thirdDataColumn.setMinWidth(100);



        javafx.scene.control.TableView tableView = new javafx.scene.control.TableView<>(generateDataInMap());

        tableView.setEditable(true);
        tableView.getSelectionModel().setCellSelectionEnabled(true);
        tableView.getColumns().setAll(firstDataColumn, secondDataColumn , thirdDataColumn);
        tableView.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

        Callback<TableColumn<Map, String>, TableCell<Map, String>>
                cellFactoryForMap = (TableColumn<Map, String> p) ->
                new TextFieldTableCell(new StringConverter() {
                    @Override
                    public String toString(Object t) {
                        return t.toString();
                    }
                    @Override
                    public Object fromString(String string) {
                        return string;
                    }
                });
        firstDataColumn.setCellFactory(cellFactoryForMap);
        secondDataColumn.setCellFactory(cellFactoryForMap);

        final VBox vbox = new VBox();

        vbox.setSpacing(1);
        vbox.setPadding(new Insets(10, 0, 0, 10));
        vbox.getChildren().addAll(label, tableView);

        ((Group) scene.getRoot()).getChildren().addAll(vbox);

        stage.setScene(scene);

        stage.show();
    }

    private ObservableList<Map> generateDataInMap() {
        int max = 2;
        ObservableList<Map> allData = FXCollections.observableArrayList();
        for (int i = 0; i < max; i++) {
            Map<String, String> dataRow = new HashMap<>();
            String rank = String.valueOf(i+1);
            String Name = GameDataBase.getAllUsers().get(i).getUsername();
            String value2 = String.valueOf(GameDataBase.getAllUsers().get(i).getHighScore());

            dataRow.put(Column1MapKey , rank);
            dataRow.put(Column2MapKey, Name);
            dataRow.put(Column3MapKey, value2);


            allData.add(dataRow);
        }
        return allData;
    }
}
