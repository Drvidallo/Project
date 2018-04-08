/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Model.DBConnection;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author drvid
 */
public class AddUniwideOrganizationController implements Initializable {
     private static Statement stmt;
    @FXML
    private JFXTextField orgName;

    @FXML
    private JFXTextField yearEstablished;

    double x, y;
    @FXML
    private JFXButton uniwideSaveBtn;

    @FXML
    private JFXButton uniwideCancel;
    
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
    void saveUniwideClicked(ActionEvent event) throws SQLException {
        String on = orgName.getText();
        String ye = yearEstablished.getText();
        
        Connection con = DBConnection.getConnection();
         PreparedStatement ps;
        ps = con.prepareStatement("INSERT INTO ORGANIZATION(name, year_established, is_uwide) VALUES (?,?,?)");
        ps.setString(1, on);
        ps.setString(2, ye);
        ps.setString(3, "TRUE");
        ps.execute();        
        
        ps.close();
            
      Alert a = new Alert(AlertType.INFORMATION);
            a.setTitle("Title of alert");
            a.initStyle(StageStyle.UNDECORATED);
            a.setContentText("Successfully stored a Uniwide Organization");
            a.showAndWait();
      Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.close();
    }
  

    @FXML
    void uniwideCancelClicked(ActionEvent event) {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.close();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
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
}
