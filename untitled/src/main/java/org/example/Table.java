package org.example;

import javafx.application.Application;
import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.sql.*;


public class Table extends Application {

    private static String DRIVER = "org.sqlite.JDBC";
    private static String DB_URL = "jdbc:sqlite:C:\\baza_miejscowosci.db";
    private static Connection CONNECTION;
    private TableView<ObservableList<String>> table = new TableView<>();

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Tabela");

        Button buttonRefresh = new Button("Odśwież");
        buttonRefresh.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                try {
                    refreshTable();
                } catch (ClassNotFoundException e) {
                    throw new RuntimeException(e);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        });


        final Label label = new Label("Tabela miejscowości");
        label.setFont(new Font("Arial", 20));

        TableColumn idM = new TableColumn("ID");
        idM.setMinWidth(170);
        TableColumn name = new TableColumn("NAZWA");
        name.setMinWidth(170);
        TableColumn id = new TableColumn("ID_POWIATU");
        id.setMinWidth(170);
        table.getColumns().addAll(idM, name, id);
        BorderPane panel = new BorderPane();
        panel.setTop(label);
        panel.setBottom(buttonRefresh);
        panel.setCenter(table);

        table.setPlaceholder(
                new Label("BRAK REKORDÓW !"));

        Scene scene = new Scene(panel, 600, 600);
        primaryStage.setScene(scene);

        primaryStage.show();
    }

    private void refreshTable() throws ClassNotFoundException, SQLException {
        table.getItems().clear();
        table.getColumns().clear();

        Class.forName(DRIVER);
        CONNECTION = DriverManager.getConnection(DB_URL);

        Statement statement = CONNECTION.createStatement();
        ResultSet result = statement.executeQuery("SELECT * FROM \"miejscowosc\"");

        ResultSetMetaData metaData = result.getMetaData();
        int columnCount = metaData.getColumnCount();

        for (int i = 1; i <= columnCount; i++) {
            final int j = i - 1;
            TableColumn<ObservableList<String>, String> column = new TableColumn<>(metaData.getColumnName(i));
            column.setCellValueFactory(param -> new ReadOnlyStringWrapper(param.getValue().get(j)));
            table.getColumns().add(column);
        }

        while (result.next()) {
            ObservableList<String> row = FXCollections.observableArrayList();
            for (int i = 1; i <= columnCount; i++) {
                row.add(result.getString(i));
            }
            table.getItems().add(row);
        }
    }


}