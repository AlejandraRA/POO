package hotelmanagment;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDialog;
import com.jfoenix.controls.JFXDialogLayout;
import com.jfoenix.controls.JFXPasswordField;
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
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;
import org.controlsfx.control.Notifications;

/**
 * FXML Controller class
 *
 * @author david
 */
public class LoginScreenController implements Initializable {

    @FXML
    private JFXTextField username;
    @FXML
    private JFXPasswordField password;
    @FXML
    private StackPane stackepane;
   
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void loginButton(MouseEvent event) {
        
        if(username.getText().toString().equals("")){
            Image image=new Image("img/delete.png");
            Notifications notification=Notifications.create()
                    .title("ERROR")
                    .text("Debes llenar todos los campos")
                    .hideAfter(Duration.seconds(3))
                    .position(Pos.CENTER)
                    .graphic(new ImageView(image));
            notification.show();            
        }
        else if(password.getText().toString().equals("")){
            Image image=new Image("img/delete.png");
            Notifications notification=Notifications.create()
                    .title("ERROR")
                    .text("Debes llenar todos los campos")
                    .hideAfter(Duration.seconds(3))
                    .position(Pos.CENTER)
                    .graphic(new ImageView(image));
            notification.show();            
        }
        
        else {
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
                    
                    if (UserType.equals("Admin")) {
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
            else{
                Image image=new Image("img/delete.png");
            Notifications notification=Notifications.create()
                    .title("ERROR")
                    .text("Datos incorrectos!!")
                    .hideAfter(Duration.seconds(3))
                    .position(Pos.CENTER)
                    .graphic(new ImageView(image));
            
            notification.show();     
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(LoginScreenController.class.getName()).log(Level.SEVERE, null, ex);
        }
        }   
                
        
        

    }
    
    @FXML 
    private void cancelBtn(MouseEvent event){
        
        JFXDialogLayout dialogLayout= new JFXDialogLayout();
        dialogLayout.setHeading(new Text("Cerrar"));
        dialogLayout.setBody(new Text("¿Estás seguro de querer salir?"));
        
        JFXButton Ok= new JFXButton("OK");
        JFXButton Cancelar= new JFXButton("Cancelar");    
        JFXDialog dialog = new JFXDialog(stackepane, dialogLayout, JFXDialog.DialogTransition.CENTER);
        
        Ok.setOnAction (new javafx.event.EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
              System.exit(0);
            }
        });

        Cancelar.setOnAction(new javafx.event.EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                dialog.close();
            }
        });
        
        dialogLayout.setActions(Ok,Cancelar);
        dialog.show();
    }
    
    
}