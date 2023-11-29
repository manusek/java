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
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.io.File;
import java.sql.*;

import static com.sun.glass.ui.CommonDialogs.showFileChooser;


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

        Button buttonRefresh = new Button("LOAD");
        FileChooser load = new FileChooser();
        buttonRefresh.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent actionEvent) {
                load.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("bazy", "*.db"));
                File selected = load.showOpenDialog(new Stage());
                try {
                    refreshTable();
                } catch (ClassNotFoundException e) {
                    throw new RuntimeException(e);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        //final Label label = new Label("tabela miesjowosc");


        final Label label = new Label("GMINY");
        label.setFont(new Font("Arial", 20));

        TableColumn idM = new TableColumn("ID");
        idM.setMinWidth(170);
        TableColumn name = new TableColumn("NAZWA");
        name.setMinWidth(170);
        table.getColumns().addAll(idM, name);
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
        ResultSet result = statement.executeQuery("SELECT id_gminy, nazwa_gminy FROM \"gmina\"");

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

//    private void showFileChooser() {
//        // Create a file chooser
//        JFileChooser fileChooser = new JFileChooser();
//
//        // Show the file chooser dialog and get the user's selection
//        int result = fileChooser.showOpenDialog(this);
//
//        // Check if the user selected a file
//        if (result == JFileChooser.APPROVE_OPTION) {
//            // Get the selected file
//            java.io.File selectedFile = fileChooser.getSelectedFile();
//
//            // Display the selected file path
//            JOptionPane.showMessageDialog(this, "Selected file: " + selectedFile.getAbsolutePath());
//        }
//    }
}