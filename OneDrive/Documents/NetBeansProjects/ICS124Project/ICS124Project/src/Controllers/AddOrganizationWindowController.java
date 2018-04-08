/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Model.DBConnection;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import java.sql.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.stage.StageStyle;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author drvid
 */
public class AddOrganizationWindowController implements Initializable {

    /**
     * Initializes the controller class.
     */
    double x, y;

    @FXML
    private JFXTextField orgName;
    @FXML
    private JFXComboBox<String> college;

    @FXML
    private JFXTextField yearEstablished;

    @FXML
    private JFXButton cancelBtn;

    @FXML
    private JFXButton saveBtn;

    private Connection conn;
    private static Statement stmt;

    public Connection getConnection() {
        try {
            conn = DriverManager.getConnection("jdbc:sqlite:C:\\Users\\drvid\\Desktop\\TeamPapsie.db");
            return conn;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    public void execute(String query, String message) {
        Connection con = DBConnection.getConnection();
        Statement st;
        try {
            st = con.createStatement();
            if ((st.executeUpdate(query)) == 1) {
                JOptionPane.showMessageDialog(null, "Data " + message + " Success");
            } else {
                JOptionPane.showMessageDialog(null, "Data not " + message);

            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @FXML
    public void saveBtnClicked(ActionEvent event) throws SQLException {
        String on = orgName.getText();
        String ye = yearEstablished.getText();
        String coll = college.getValue();

        Connection con = DBConnection.getConnection();
    

        PreparedStatement ps;
        ps = con.prepareStatement("INSERT INTO ORGANIZATION(name, year_established, is_uwide, code_college) VALUES (?,?,?,?)");
        ps.setString(1, on);
        ps.setString(2, ye);
        ps.setString(3, "FALSE");
        ps.setString(4, coll);
        ps.execute();
        
        
        ps.close();
        Alert a = new Alert(Alert.AlertType.INFORMATION);
        a.setTitle("Title of alert");
        a.initStyle(StageStyle.UNDECORATED);
        a.setContentText("Successfully stored a Local Organization");
        a.showAndWait();

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.close();
        
    }

    @FXML
    void cancelBtnClicked(MouseEvent event) {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.close();
    }

    @FXML
    void windowDragged(MouseEvent event) {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setX(event.getScreenX() - x);
        stage.setY(event.getScreenY() - y);
    }

    @FXML
    void windowPressed(MouseEvent event) {
        x = event.getSceneX();
        y = event.getSceneY();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ObservableList<String> john = FXCollections.observableArrayList(
                "Eccleastical Faculties",
                "Faculty of Civil Law",
                "Faculty of Medicine & Surgery",
                "Faculty of Pharmacy",
                "Faculty of Arts & Letters",
                "Faculty of Engineering",
                "Institute of Physical Education & Athletics",
                "Institute of Information & Computing Sciences",
                "UST Senior High School",
                "UST Junior High School",
                "UST Education High School",
                "UST Graduate School",
                "College of Education",
                "College of Architecture",
                "College of Commerce & Business Administration",
                "Conservatory of Music",
                "College of Nursing",
                "College of Rehabilitation Science",
                "College of Fine Arts & Design",
                "College of Tourism",
                "College of Science");
        college.setItems(john);

    }
}
