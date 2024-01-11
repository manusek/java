package com.example.fxproject;


import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
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


    ObservableList<Student> listM;
    ObservableList<Student> dataList;


    int index = -1;

    Connection conn = null;
    ResultSet rs = null;
    PreparedStatement pst = null;

    public void Add_users() throws SQLException {
        conn = ConnectDB.getConnection();
        String sql = "insert into students (name, scndname, city, albumnumber)values(?,?,?,? )";
        try {
            String name = name_txt.getText();
            String scnd = ndname_txt.getText();
            String cityy = city_txt.getText();
            String numberalbum = album_txt.getText();
            int nmbr = Integer.parseInt(numberalbum);

            pst = conn.prepareStatement(sql);

            pst.setString(1, name);
            pst.setString(2, scnd);
            pst.setString(3, cityy);
            pst.setInt(4, nmbr);

            pst.execute();

            JOptionPane.showMessageDialog(null, "Users Add succes");
            updateTable();
            //search_user();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Wystąpił błąd. Opis: "+e.getMessage(), "Błąd", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void getSelected(javafx.scene.input.MouseEvent mouseEvent) {
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

    public void Edit() {
        try {
            conn = ConnectDB.getConnection();

            String value1 = id_txt.getText();
            String value2 = name_txt.getText();
            String value3 = ndname_txt.getText();
            String value4 = city_txt.getText();
            String value5 = album_txt.getText();

            //walidacja pól
            int yourNumber = Integer.valueOf(value5);


            String sql = "update students set name= '" + value2 + "',scndname= '" +
                    value3 + "',city= '" + value4 + "',albumnumber= " + value5 + " where id=" + value1 + " ";

            pst = conn.prepareStatement(sql);
            pst.execute();

            JOptionPane.showMessageDialog(null, "Update");
            updateTable();

            id_txt.setText("");
            name_txt.setText("");
            ndname_txt.setText("");
            city_txt.setText("");
            album_txt.setText("");
            date_txt.setText("");

            //search_user();
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, ex);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }

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

    public void initialize(URL url, ResourceBundle resourceBundle) {
        updateTable();
    }

}