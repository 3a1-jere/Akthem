/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package akthem;

import Entities.produit;
import com.mysql.jdbc.Connection;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import database.DatabaseConnection;
import java.sql.Statement;
import javax.swing.JOptionPane;
import akthem.GestionProduitController;
import java.awt.Dialog;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author AKTHEM
 */
public class Akthem extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
        //Parent root = FXMLLoader.load(getClass().getResource("login.fxml"));
         Parent root = FXMLLoader.load(getClass().getResource("GestionProduitFXML.fxml"));
        Scene scene = new Scene(root);
        scene.getStylesheets().add(getClass().getResource("/css_produit/css_gestionProduit.css").toExternalForm());
        stage.setScene(scene); 
        stage.show();
       
    }
    
    private int idproduit;
    DatabaseConnection dbc = database.DatabaseConnection.getDatabaseConnection();
    Connection con= dbc.getConnection();
    
      
    public void ajouter(produit p)
            
    {
        //int id=p.getId();
        String nom=p.getNom();
        float prix=p.getPrix();
        int quantite=p.getQuantite();
        String image=p.getImage();
        String categorie=p.getCategorie();
        String type=p.getType();
        float prix_initial=p.getPrix();
        
     try {
         
            Statement smt = con.createStatement();
            smt.execute("insert into produits(nom,prix,prix_initial,quantite,image,categorie,type) values('"+nom+"',"+prix+","+prix_initial+","+quantite+",'"+image+"','"+categorie+"','"+type+"')");
            
            System.out.println("produit ajouté");
            
            
            smt.close();
        }
        catch (Exception ex)
        {System.out.println(ex);
            System.out.println("non!");}
        
    
    
    
    
    
    
    
    }
  public void Supprimer(int id)
  {     
     
  try {
            Statement smt = con.createStatement();
            smt.execute("Delete from produits where id ="+id);
            System.out.println("produit supprimé avec succes!");
              
            smt.close();
            }
        catch (Exception ex)
        {System.out.println("ex");;}

  
  
  }
    
    public void modifier (produit p, int pid)
    {
    
        int id=p.getId();
        String nom=p.getNom();
        float prix=p.getPrix();
        float prix_initiale=p.getPrix();
        int quantite=p.getQuantite();
        String image=p.getImage();
        String categorie=p.getCategorie();
        String type=p.getType();
        
        
     try {
         
            Statement smt = con.createStatement();
            
            smt.execute("update produits set nom='"+nom+"',prix="+prix+",prix_initial="+prix+",quantite="+quantite+",image='"+image+"',categorie='"+categorie+"',type='"+type+"' where id ="+pid );
            System.out.println("produit modifiée!");
            
            smt.close();
        }
        catch (Exception ex)
        {System.out.println(ex);
            System.out.println("non Modifié!");}
        
    
    
    
    
    }
    public void afficher_login() throws IOException
    {
    
      Parent root=null;
        root = FXMLLoader.load(getClass().getResource("login.fxml"));
        
        
        Scene scene = new Scene(root);
        scene.getStylesheets().add(getClass().getResource("/css_produit/css_gestionProduit.css").toExternalForm());
        Stage stage=new Stage();
        stage.setScene(scene);
    
    
    
    
    
    
    
    
    
    
    
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
