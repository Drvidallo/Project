/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Model.DBConnection;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author drvid
 */
public class ChangePasswordController implements Initializable {

    /**
     * Initializes the controller class.
     */
        double x, y;
     @FXML
    private JFXButton cancelBtn;

        @FXML
    private JFXPasswordField oldPassword;

    @FXML
    private JFXPasswordField newPassword;

    @FXML
    private JFXButton saveBtn;

    @FXML
    void saveBtnClicked(ActionEvent event) throws SQLException {
         String on = oldPassword.getText();
        String ye = newPassword.getText();
        
        Connection con = DBConnection.getConnection();
         PreparedStatement ps;
        ps = con.prepareStatement("update account set password=? where password='" + on + "'");
        ps.setString(1, ye);
        ps.execute();        
        
        ps.close();
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("SUCCESS");
                alert.setHeaderText(null);
                alert.setContentText("USER UPDATED SUCCESSFULLY");
                alert.showAndWait();
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
        @FXML
    void cancelBtnClicked(ActionEvent event) {
             Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.close();
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
