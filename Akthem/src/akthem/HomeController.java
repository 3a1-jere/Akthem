/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package akthem;

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
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author AKTHEM
 */
public class HomeController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    private Button gestionProduit;
    @FXML
    private ImageView image;
    @FXML
    public void back(ActionEvent event) throws IOException
    {
    
    
    Parent root=null;
        root = FXMLLoader.load(getClass().getResource("GestionProduitFXML.fxml"));
        
        Scene scene = new Scene(root);
        scene.getStylesheets().add(getClass().getResource("/css_produit/css_gestionProduit.css").toExternalForm());
        ((Node)event.getSource()).getScene().getWindow().hide();
        Stage stage=new Stage();
        stage.setScene(scene);
        stage.show();
    
    
    
    
    
    
    
    
    
    }
    @FXML
    private Button deconnecter;
     
    @FXML
    private void deconnecter(ActionEvent event) throws IOException {
     
            Parent root=null;
             
        root = FXMLLoader.load(getClass().getResource("login.fxml"));
        
        Scene scene = new Scene(root);
        scene.getStylesheets().add(getClass().getResource("/css_produit/css_gestionProduit.css").toExternalForm());
        ((Node)event.getSource()).getScene().getWindow().hide();
        Stage stage=new Stage();
        stage.setScene(scene);
  
        //jdid
        
   
        
        //jdid
        
        stage.show();
         
        
}
    
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
