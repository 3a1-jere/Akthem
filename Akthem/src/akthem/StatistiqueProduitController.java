/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package akthem;

import com.mysql.jdbc.Connection;
import database.DatabaseConnection;
import java.io.IOException;
import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author AKTHEM
 */
public class StatistiqueProduitController implements Initializable {

    @FXML
    private BarChart<String, Integer> barchart;
    @FXML
    private Button load;
    @FXML
    private Button back;
    
    /**
     * Initializes the controller class.
     */
    @FXML
    private void loadchart(ActionEvent event) {
        XYChart.Series<String, Integer> series = new XYChart.Series<>();
        DatabaseConnection dbc = database.DatabaseConnection.getDatabaseConnection();
        try {
            Connection con = dbc.getConnection();
            String sql = "SELECT nom,quantite FROM produits ORDER BY id";
            PreparedStatement stat = con.prepareStatement(sql);
            ResultSet rs = stat.executeQuery();
            while (rs.next()) {
                System.out.println("ok");
                series.getData().add(new XYChart.Data<>(rs.getString(1), rs.getInt(2)));

            }
            barchart.getData().add(series);
        } catch (Exception ex) {
            System.out.println(ex);
            System.out.println("non!");
        }

    }
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
    

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

}
