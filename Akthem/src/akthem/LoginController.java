/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package akthem;

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
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author AKTHEM
 */

 



public class LoginController implements Initializable {

    /**
     * Initializes the controller class.
     */
       @FXML
    private JFXTextField password;

    @FXML
    private AnchorPane K1;

    @FXML
    private JFXTextField login;

    @FXML
    private AnchorPane login1;
      @FXML
    private Button logina;
   
    @FXML
    private void connecter(ActionEvent event) throws IOException
    {
        if ((login.getText().equals("akthem"))&(password.getText().equals("akthem")))
        {
        System.out.println("salem");

        
         Parent root=null;
        root = FXMLLoader.load(getClass().getResource("home.fxml"));
        
        Scene scene = new Scene(root);
        scene.getStylesheets().add(getClass().getResource("/css_produit/css_gestionProduit.css").toExternalForm());
        ((Node)event.getSource()).getScene().getWindow().hide();
        Stage stage=new Stage();
        stage.setScene(scene);
        stage.show();
        }
        else {System.out.println("non!");}
        
        
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
