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
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author drvid
 */
public class AddOfficerUniwideController implements Initializable {

   private static Statement stmt;
   @FXML
    private JFXComboBox<String> college;

    @FXML
    private JFXTextField firstname;

    @FXML
    private JFXTextField acadyear;

    @FXML
    private JFXTextField yearsec;

    @FXML
    private JFXButton cancelBtn;

    @FXML
    private JFXTextField degree;

    @FXML
    private JFXTextField middlename;

    @FXML
    private JFXTextField lastname;

    @FXML
    private JFXTextField dateofBirth;

    @FXML
    private JFXTextField emailAddress;

    @FXML
    private JFXTextField studno;

    @FXML
    private JFXTextField orgPosition;
    
    @FXML
    private JFXTextField organization;

    @FXML
    private JFXButton saveBtn;
    double x, y;
    private Connection conn;
    
     public Connection getConnection() 
    {
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
    void saveBtnClicked(ActionEvent event) throws SQLException {
        String sn = studno.getText();
        String fn = firstname.getText();
        String ln = lastname.getText();
        String mn = middlename.getText();
        String db = dateofBirth.getText();
        String em = emailAddress.getText();
        String d = degree.getText();
        String ys = yearsec.getText();
        String co = college.getValue();
        String org = organization.getText();
        String op = orgPosition.getText();
        String ay = acadyear.getText();
        Connection con = DBConnection.getConnection();
        
        PreparedStatement ps;
        ps = con.prepareStatement("INSERT INTO OFFICERS(studno, firstname, lastname, middlename,dateofBirth,emailAddress,degree,yearsec,college,organization,orgPosition,acadyear,is_uniwide) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)");
        ps.setString(1, sn);
        ps.setString(2, fn);
        ps.setString(3, ln);
        ps.setString(4, mn);
        ps.setString(5, db);
        ps.setString(6, em);
        ps.setString(7, d);
        ps.setString(8, ys);
        ps.setString(9, co);
        ps.setString(10, org);
        ps.setString(11, op);
        ps.setString(12, ay);
        ps.setString(13, "TRUE");
        ps.execute();
        
        Alert a = new Alert(Alert.AlertType.INFORMATION);
            a.setTitle("Title of alert");
            a.initStyle(StageStyle.UNDECORATED);
            a.setContentText("Successfully stored in the Officer Table");
            a.showAndWait();
            
      Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.close();
    }

    @FXML
    void cancelBtnClicked(ActionEvent event) {
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
        ObservableList<String> courses= FXCollections.observableArrayList(
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
        college.setItems(courses);
    }    
}
