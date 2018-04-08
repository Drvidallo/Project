/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;


import java.sql.Connection;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.event.Event;
import javafx.scene.Parent;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.fxml.FXMLLoader;
import javafx.scene.image.Image;
       

/**
 *
 * @author drvid
 */
public class LoginPage extends Application{
    
    Connection con = null;
    
    @Override
    public void start(Stage primaryStage) throws Exception{
     
        FXMLLoader loader = new FXMLLoader(getClass().getResource("LoginPage.fxml"));
        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("FXML/LoginPage.fxml"));
        primaryStage.getIcons().add(new Image("/Images/TOOD-Logo.png"));
        primaryStage.setTitle("Thomasian Officers and Organization Database");
        primaryStage.setScene(new Scene(root,850,600));
        
        
    primaryStage.show();
    
    }
    
    public static void main(String[] args){
        launch(args);
    
    }
    
}
