/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotelmanagment;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDialog;
import com.jfoenix.controls.JFXDialogLayout;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * FXML Controller class
 *
 * @author david
 */
public class HomeScreenController implements Initializable {

    @FXML
    private Pane panel1;
    @FXML
    private Pane panel2;
    @FXML
    private Pane panel3;
    @FXML
    private Pane panel4;
    @FXML
    private Pane panel5;
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
    private void exited_1(MouseEvent event) {
        panel1.setStyle("-fx-background-color: white; -fx-background-radius: 6px;");
    }

    @FXML
    private void hover_1(MouseEvent event) {
        panel1.setStyle("-fx-background-color: #377ce8; -fx-background-radius: 6px;");
    }

    @FXML
    private void exited_2(MouseEvent event) {
        panel2.setStyle("-fx-background-color:white ; -fx-background-radius: 6px;");
    }

    @FXML
    private void hover_2(MouseEvent event) {
        panel2.setStyle("-fx-background-color: #377ce8; -fx-background-radius: 6px;");
    }

    @FXML
    private void exited_3(MouseEvent event) {
        panel3.setStyle("-fx-background-color: white; -fx-background-radius: 6px;");
    }

    @FXML
    private void hover_3(MouseEvent event) {
        panel3.setStyle("-fx-background-color: #377ce8; -fx-background-radius: 6px;");
    }

    @FXML
    private void exited_4(MouseEvent event) {
        panel4.setStyle("-fx-background-color: white; -fx-background-radius: 6px;");
    }

    @FXML
    private void hover_4(MouseEvent event) {
        panel4.setStyle("-fx-background-color: #377ce8; -fx-background-radius: 6px;");
    }

    @FXML
    private void exited_5(MouseEvent event) {
        panel5.setStyle("-fx-background-color: white; -fx-background-radius: 6px;");
    }

    @FXML
    private void hover_5(MouseEvent event) {
        panel5.setStyle("-fx-background-color: #377ce8; -fx-background-radius: 6px;");
    }

    @FXML
    private void Reservacion(MouseEvent event) {
        Stage reserva= new Stage();
        Parent root= null;
        try {
            root=FXMLLoader.load(getClass().getResource("ReservacionScreen.fxml"));
        } catch (IOException ex) {
            Logger.getLogger(AdminScreenController.class.getName()).log(Level.SEVERE,null,ex);
        }
              
        Stage current =(Stage)panel1.getScene().getWindow();
        Scene scene = new Scene (root);
        
        reserva.setScene(scene);
        reserva.initStyle(StageStyle.TRANSPARENT);
        
        current.hide();
        reserva.show();

    }
    

    @FXML
    private void Habitacion(MouseEvent event) {
        Stage habitacion= new Stage();
        Parent root= null;
        try {
            root=FXMLLoader.load(getClass().getResource("HabitacionScreen.fxml"));
        } catch (IOException ex) {
            Logger.getLogger(AdminScreenController.class.getName()).log(Level.SEVERE,null,ex);
        }
              
        Stage current =(Stage)panel1.getScene().getWindow();
        Scene scene = new Scene (root);
        
        habitacion.setScene(scene);
        habitacion.initStyle(StageStyle.TRANSPARENT);
        
        current.hide();
        habitacion.show();
    }

    @FXML
    private void Clientes(MouseEvent event) {
        Stage clientes= new Stage();
        Parent root= null;
        try {
            root=FXMLLoader.load(getClass().getResource("ClientesScreen.fxml"));
        } catch (IOException ex) {
            Logger.getLogger(AdminScreenController.class.getName()).log(Level.SEVERE,null,ex);
        }
              
        Stage current =(Stage)panel1.getScene().getWindow();
        Scene scene = new Scene (root);
        
        clientes.setScene(scene);
        clientes.initStyle(StageStyle.TRANSPARENT);
        
        current.hide();
        clientes.show();
        
    }

    @FXML
    private void CerrarS(MouseEvent event) {
        JFXDialogLayout dialogLayout= new JFXDialogLayout();
        dialogLayout.setHeading(new Text("Cerrar"));
        dialogLayout.setBody(new Text("¿Estás seguro de querer cerrar sesión?"));
        
        JFXButton Ok= new JFXButton("OK");
        JFXButton Cancelar= new JFXButton("Cancelar");    
        JFXDialog dialog = new JFXDialog(stackepane, dialogLayout, JFXDialog.DialogTransition.CENTER);
        
        Ok.setOnAction (new javafx.event.EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Stage home= new Stage();
        Parent root= null;
        try {
            root=FXMLLoader.load(getClass().getResource("LoginScreen.fxml"));
        } catch (IOException ex) {
            Logger.getLogger(AdminScreenController.class.getName()).log(Level.SEVERE,null,ex);
        }
              
        Stage current =(Stage)panel1.getScene().getWindow();
        Scene scene = new Scene (root);
        
        home.setScene(scene);
        home.initStyle(StageStyle.TRANSPARENT);
        
        current.hide();
        home.show();
              
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

    @FXML
    private void Salir(MouseEvent event) {
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
