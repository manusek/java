package com.example.fxproject;


import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.TextField;

import javax.swing.*;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.ResourceBundle;


public class HelloController implements Initializable {

    @FXML
    private TableView<Student> table;

    @FXML
    private TableColumn<Student, Integer> albumNumber;

    @FXML
    private TableColumn<Student, Date> creationDate;

    @FXML
    private TableColumn<Student, String> city;

    @FXML
    private TableColumn<Student, Integer> id;

    @FXML
    private TableColumn<Student, String> name;

    @FXML
    private TableColumn<Student, String> scndName;

    @FXML
    private TextField album_txt;

    @FXML
    private TextField city_txt;

    @FXML
    private TextField name_txt;

    @FXML
    private TextField ndname_txt;

    @FXML
    private TextField id_txt;

    @FXML
    private TextField date_txt;

    @FXML
    private TextField search_txt;


    @FXML
    private Label name_error;
    @FXML
    private Label city_error;
    @FXML
    private Label ndname_error;

    @FXML
    private Label nr_error;


    ObservableList<Student> listM;
    ObservableList<Student> dataList;
    int index = -1;

    Connection conn = null;
    ResultSet rs = null;
    PreparedStatement pst = null;

    public void addUser() throws Exception {
        try {
            conn = ConnectDB.getConnection();

            String sql = "insert into students (name, scndname, city, albumnumber)values(?,?,?,? )";

            String name = name_txt.getText();
            String scnd = ndname_txt.getText();
            String cityy = city_txt.getText();
            String numberalbum = album_txt.getText();

            isInputEmpty();

            int nmbr = Integer.parseInt(numberalbum);
            if (name.isEmpty() || scnd.isEmpty() || cityy.isEmpty() || isLetter(name) == false || isLetter(scnd) == false || isLetter(cityy) == false || nmbr < 0 || inputLenght(nmbr) != 6) {
                throw new Exception("imie puste");
            }

            pst = conn.prepareStatement(sql);

            pst.setString(1, name);
            pst.setString(2, scnd);
            pst.setString(3, cityy);
            pst.setInt(4, Integer.parseInt(numberalbum));

            pst.execute();

            JOptionPane.showMessageDialog(null, "Student dodany");
            updateTable();
            searchUser();

            id_txt.setText("");
            name_txt.setText("");
            ndname_txt.setText("");
            city_txt.setText("");
            album_txt.setText("");
            date_txt.setText("");


        } catch (Exception e) {
            //JOptionPane.showMessageDialog(null, "Wprowadzono nieprawidłowe dane!", "Błąd", JOptionPane.ERROR_MESSAGE);
        }
        conn.close();
    }

    public void selectTextFields(javafx.scene.input.MouseEvent mouseEvent) {
        index = table.getSelectionModel().getSelectedIndex();
        if (index <= -1) {
            return;
        }

        id_txt.setText(id.getCellData(index).toString());
        name_txt.setText(name.getCellData(index).toString());
        ndname_txt.setText(scndName.getCellData(index).toString());
        city_txt.setText(city.getCellData(index).toString());
        album_txt.setText(albumNumber.getCellData(index).toString());
        date_txt.setText(creationDate.getCellData(index).toString());
    }

    public void editUser() throws Exception {
        try {

            conn = ConnectDB.getConnection();

            String value1 = id_txt.getText();
            String value2 = name_txt.getText();
            String value3 = ndname_txt.getText();
            String value4 = city_txt.getText();
            String value5 = album_txt.getText();

            isInputEmpty();

            int nmbr = Integer.parseInt(value5);

            if (value2.isEmpty() || value3.isEmpty() || value4.isEmpty() || isLetter(value2) == false || isLetter(value3) == false || isLetter(value4) == false || nmbr < 0 || inputLenght(nmbr) != 6) {
                throw new Exception("imie puste");
            }

            String sql = "update students set name= '" + value2 + "',scndname= '" +
                    value3 + "',city= '" + value4 + "',albumnumber= " + value5 + " where id=" + value1 + " ";

            pst = conn.prepareStatement(sql);
            pst.execute();

            JOptionPane.showMessageDialog(null, "Student zedytowany");
            updateTable();
            searchUser();
            id_txt.setText("");
            name_txt.setText("");
            ndname_txt.setText("");
            city_txt.setText("");
            album_txt.setText("");
            date_txt.setText("");


        } catch (Exception e) {
            //JOptionPane.showMessageDialog(null, "Wprowadzono nieprawidłowe dane!", "Błąd", JOptionPane.ERROR_MESSAGE);
        }
        conn.close();
    }

    public void deleteUser() throws SQLException {
        try {
            conn = ConnectDB.getConnection();

            String id = id_txt.getText();

            String sql = "delete from students where id =" + id;

            pst = conn.prepareStatement(sql);

            pst.execute();

            JOptionPane.showMessageDialog(null, "Student usunięty");
            updateTable();
            searchUser();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Student nie istnieje", "Błąd", JOptionPane.ERROR_MESSAGE);
        }
        conn.close();
    }

    public void updateTable() {
        id.setCellValueFactory(new PropertyValueFactory<Student, Integer>("id"));
        name.setCellValueFactory(new PropertyValueFactory<Student, String>("name"));
        scndName.setCellValueFactory(new PropertyValueFactory<Student, String>("scndName"));
        city.setCellValueFactory(new PropertyValueFactory<Student, String>("city"));
        albumNumber.setCellValueFactory(new PropertyValueFactory<Student, Integer>("albumNumber"));
        creationDate.setCellValueFactory(new PropertyValueFactory<Student, Date>("creationDate"));

        listM = ConnectDB.getDatausers();
        table.setItems(listM);
    }

    @FXML
    public void searchUser() {
        id.setCellValueFactory(new PropertyValueFactory<Student, Integer>("id"));
        name.setCellValueFactory(new PropertyValueFactory<Student, String>("name"));
        scndName.setCellValueFactory(new PropertyValueFactory<Student, String>("scndName"));
        city.setCellValueFactory(new PropertyValueFactory<Student, String>("city"));
        albumNumber.setCellValueFactory(new PropertyValueFactory<Student, Integer>("albumNumber"));

        dataList = ConnectDB.getDatausers();

        table.setItems(dataList);
        FilteredList<Student> filteredData = new FilteredList<>(dataList, b -> true);
        search_txt.textProperty().addListener((observable, oldValue, newValue) -> {
            filteredData.setPredicate((Student person) -> {
                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }

                String lowerCaseFilter = newValue.toLowerCase();

                if (String.valueOf(person.getId()).indexOf(lowerCaseFilter) != -1) {
                    return true;
                } else if (person.getName().toLowerCase().indexOf(lowerCaseFilter) != -1) {
                    return true;
                } else if (person.getScndName().toLowerCase().indexOf(lowerCaseFilter) != -1) {
                    return true;
                } else if (person.getCity().toLowerCase().indexOf(lowerCaseFilter) != -1) {
                    return true;
                } else if (String.valueOf(person.getAlbumNumber()).indexOf(lowerCaseFilter) != -1) {
                    return true;
                } else if (String.valueOf(person.getCreationDate()).indexOf(lowerCaseFilter) != -1)
                    return true;
                else
                    return false;
            });
        });

        SortedList<Student> sortedData = new SortedList<>(filteredData);
        sortedData.comparatorProperty().bind(table.comparatorProperty());
        table.setItems(sortedData);
    }

    @FXML
    private void isInputEmpty() {

        String v1 = album_txt.getText();
        String v2 = name_txt.getText();
        String v3 = ndname_txt.getText();
        String v4 = city_txt.getText();

        if (name_txt.getText().isEmpty() || isLetter(v2) == false) {
            name_txt.setStyle("-fx-border-color: red ; -fx-border-width: 2px ; -fx-border-radius: 3 ;");
            new animatefx.animation.Shake(name_txt).play();
            name_error.setText("Nieprawidłowe imie");
        } else {
            name_txt.setStyle(null);
            name_error.setText("");
        }

        if (city_txt.getText().isEmpty() || isLetter(v4) == false) {
            city_txt.setStyle("-fx-border-color: red ; -fx-border-width: 2px ; -fx-border-radius: 3 ;");
            new animatefx.animation.Shake(city_txt).play();
            city_error.setText("Nieprawidłowe miasto");
        } else {
            city_txt.setStyle(null);
            city_error.setText("");
        }

        if (ndname_txt.getText().isEmpty() || isLetter(v3) == false) {
            ndname_txt.setStyle("-fx-border-color: red ; -fx-border-width: 2px ; -fx-border-radius: 3 ;");
            new animatefx.animation.Shake(ndname_txt).play();
            ndname_error.setText("Nieprawidłowe nazwisko");
        } else {
            ndname_txt.setStyle(null);
            ndname_error.setText("");
        }

        if (album_txt.getText().isEmpty() || isNumber(v1) == false || inputLenght(Integer.parseInt(v1)) != 6) {
            album_txt.setStyle("-fx-border-color: red ; -fx-border-width: 2px ; -fx-border-radius: 3 ;");
            new animatefx.animation.Shake(album_txt).play();
            nr_error.setText("Nieprawidłowy nr albumu");
        } else {
            album_txt.setStyle(null);
            nr_error.setText("");
        }
    }

    public void clearTextField() {
        id_txt.setText("");
        name_txt.setText("");
        ndname_txt.setText("");
        city_txt.setText("");
        album_txt.setText("");
        date_txt.setText("");

        name_txt.setStyle(null);
        name_error.setText("");

        city_txt.setStyle(null);
        city_error.setText("");

        ndname_txt.setStyle(null);
        ndname_error.setText("");

        album_txt.setStyle(null);
        nr_error.setText("");


    }

    public static boolean isNumber(String value) {
        return value.matches("\\d+");
    }

    public static boolean isLetter(String input) {
        for (int i = 0; i < input.length(); i++) {
            if (!Character.isLetter(input.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    static int inputLenght(int input) {
        String charNumber = Integer.toString(input);

        return charNumber.length();
    }

    public void initialize(URL url, ResourceBundle resourceBundle) {
        updateTable();
        searchUser();
    }

}