/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotelmanagment;

import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * FXML Controller class
 *
 * @author david
 */
public class LoginScreenController implements Initializable {

    @FXML
    private JFXTextField username;
    @FXML
    private JFXTextField password;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void loginButton(MouseEvent event) {
        
        
        boolean isExist = false;
        String userPass="";
        String UserType= "";
        String sql="select * from users where username= '"+username.getText().toString().trim()+"'";
        Connection connection = DBConnection.getconConnection();
        try {
            PreparedStatement ps =(PreparedStatement)connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
               isExist = true;
               userPass= rs.getString(3);
               UserType=rs.getString(9);
            }
            
            if (isExist) {
                if (password.getText().toString().trim().equals(userPass)) {
                    
                    if (UserType.equals("admin")) {
                        // if user admin -->Admin Screen
                         Stage adminScreen = new Stage();
                         Parent root = null;
                         
                        try {
                            root = FXMLLoader.load(getClass().getResource("AdminScreen.fxml"));
                        } catch (IOException ex) {
                            Logger.getLogger(LoginScreenController.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        
                        Stage current =(Stage) username.getScene().getWindow();
                        Scene scene= new Scene(root,1366,730);
                        
                        adminScreen.setScene(scene);
                        adminScreen.initStyle(StageStyle.TRANSPARENT);
                        
                        current.hide();
                        
                        adminScreen.show();
                    } else {
                        // if user normal -->Home Screen
                        Stage homeScreen = new Stage();
                         Parent root = null;
                         
                        try {
                            root = FXMLLoader.load(getClass().getResource("HomeScreen.fxml"));
                        } catch (IOException ex) {
                            Logger.getLogger(LoginScreenController.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        
                        Stage current =(Stage) username.getScene().getWindow();
                        Scene scene= new Scene(root,1366,730);
                        
                        homeScreen.setScene(scene);
                        homeScreen.initStyle(StageStyle.TRANSPARENT);
                        
                        current.hide();
                        
                        homeScreen.show();
                    }
                }
            }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(LoginScreenController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
