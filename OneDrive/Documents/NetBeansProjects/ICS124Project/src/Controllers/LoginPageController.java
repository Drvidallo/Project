/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * FXML Controller class
 *
 * @author drvid
 */
public class LoginPageController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    private JFXPasswordField password;

    @FXML
    private JFXButton login;



    @FXML
    private JFXTextField username;

    @FXML
    private void makeLogin(ActionEvent event) throws IOException {
        String user = username.getText();
        String pass = password.getText();

        if (user.equals("account") && pass.equals("password")) {

            Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("FXML/administratorPage.fxml"));
            Scene adminPageScene = new Scene(root);
            Alert a = new Alert(AlertType.INFORMATION);
            a.setTitle("Title of alert");
            a.setHeaderText(null);
            a.initStyle(StageStyle.UNDECORATED);
            a.setContentText("Admin successfully logged in");
            a.showAndWait();

            Stage adminStage;
            adminStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            adminStage.setTitle("Thomasian Officers and Organizations Database - Administrator Mode");
            adminStage.hide();
            adminStage.setScene(adminPageScene);
            adminStage.show();

        } else if (user.equals("guest") && pass.equals("password")) {

            Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("FXML/guestPage.fxml"));
            Scene guestPageScene = new Scene(root);
            Alert a = new Alert(AlertType.INFORMATION);
            a.setTitle("Title of alert");
            a.setHeaderText(null);
            a.initStyle(StageStyle.UNDECORATED);
            a.setContentText("Guest successfully logged in");
            a.showAndWait();
            Stage guestStage;
            guestStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            guestStage.setTitle("Thomasian Officers and Organizations Database - Guest Mode");
            guestStage.hide();
            guestStage.setScene(guestPageScene);
            guestStage.show();
            
        }else
        {
            Alert a = new Alert(AlertType.ERROR);
            a.setTitle("Title of alert");
            a.setHeaderText(null);
            a.initStyle(StageStyle.UNDECORATED);
            a.setContentText("Wrong Credentials");
            a.showAndWait();

        }

    }

    @FXML
    void enterUsername(ActionEvent event) {

    }

    @FXML
    void enterPassword(ActionEvent event) {

    }

  

    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

}
