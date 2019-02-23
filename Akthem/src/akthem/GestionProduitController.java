/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package akthem;

import Entities.produit;
import com.mysql.jdbc.Connection;
import database.DatabaseConnection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import static java.rmi.Naming.list;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import static java.util.Collections.list;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.SortEvent;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
/**
 *
 * @author AKTHEM
 */
public class GestionProduitController implements Initializable {
    
    @FXML
    private Label label;
    Akthem a=new Akthem();
    
    @FXML
    private Button afficher;
    @FXML
    private Button affichers;
    @FXML
    private GridPane g;
    @FXML
    public TextField idtf;
    @FXML
    public TextField nomtf;
    @FXML
    public TextField prixtf;
    @FXML
    private TableView<produit> table;
    @FXML
    private TableColumn<produit,String> colnom;
    @FXML
    private TableColumn<produit,Float> colprix;
    @FXML
    private TableColumn<produit,Integer> colquan;
    @FXML
    private TableColumn<produit,String> colimage;
     @FXML
    private TableColumn<produit,String> colcategorie;
     @FXML
    private TableColumn<produit,Float> colprixin;
     @FXML
    private TableColumn<produit,String> coltype;
    @FXML
    public TextField quantitetf;
    public ImageView image;
    @FXML
   private Button aaa;
   @FXML
   private TextField ids;
   @FXML
   private CheckBox sup;
   private Label labels;
   
   //jdiiid
   ImageView imagview ;
   @FXML
   AnchorPane imageV ;
    Image image1;
    FileChooser fileChooser = new FileChooser();
    File selectedFile;
   
   TextArea textArea = new TextArea();
   TextField imagesource;
   
   //jdiiid
   
   
    public ObservableList<produit> data=FXCollections.observableArrayList();
    @FXML
    private Button brows;
    @FXML
    private Button Modifier;
    @FXML
    private Button fxml2;
   
    
    @FXML
    public void viewProduit(ActionEvent event)
    {
        
    DatabaseConnection dbc = database.DatabaseConnection.getDatabaseConnection();
    
    data.clear();
    try {
            Connection con = dbc.getConnection();
            String sql="SELECT * FROM produits";
            PreparedStatement stat=con.prepareStatement(sql);
            ResultSet rs=stat.executeQuery();
            while(rs.next()) {
                System.out.println("ok");
                data.add(new produit(rs.getInt(1),rs.getString(2),rs.getFloat(3),rs.getFloat(4),rs.getInt(5),rs.getString(6),rs.getString(7),rs.getString(8) ));
            }
            
            
        }
    
        catch (Exception ex)
        {System.out.println(ex);
         System.out.println("non!");}
        
    //colid.setCellValueFactory(new PropertyValueFactory<produit,Integer>("id"));
    colnom.setCellValueFactory(new PropertyValueFactory<produit,String>("nom"));
    colprix.setCellValueFactory(new PropertyValueFactory<produit,Float>("prix"));
    colprixin.setCellValueFactory(new PropertyValueFactory<produit,Float>("prix_initial"));
    colquan.setCellValueFactory(new PropertyValueFactory<produit,Integer>("quantite"));
    colimage.setCellValueFactory(new PropertyValueFactory<produit,String>("image"));
    colcategorie.setCellValueFactory(new PropertyValueFactory<produit,String>("categorie"));
    coltype.setCellValueFactory(new PropertyValueFactory<produit,String>("type"));
    table.setItems(data);
    
    
    
    }
    
    
  
    
    
    
    
    
    
    
    
    
    
    
    @FXML
    public void ajouterAction(ActionEvent event) {
       produit p = new produit();
        
        p.setNom(nomtf.getText());
        p.setQuantite(Integer.parseInt(quantitetf.getText()));
        p.setImage("file:///C://wamp64/www/produits/"+selectedFile.getName().toString());
        p.setPrix(Float.parseFloat(prixtf.getText()));
        p.setCategorie(comboboxx.getValue().toString());
        p.setPrix_initial(Float.parseFloat(prixtf.getText()));
        p.setType(typebox.getValue().toString());
        a.ajouter(p);
        try{cleartf(event);}
        catch (Exception ex)
        {System.out.println(ex);}
        viewProduit(event);
        imageV.getChildren().remove(imagview);
       
    }
    
    
    
    @FXML
    public void cleartf(ActionEvent event)
    {
        try {
    idtf.setText("");
    nomtf.setText("");
    prixtf.setText("");
    quantitetf.setText("");
    labels.setText("");
            System.out.println("c");
    ids.setText("");
            System.out.println("c");
    recherche.setText("");
    imageV.getChildren().remove(imagview);
        } catch (Exception e) {
            System.out.println("c bn");
        }
    
    
    
    
    }
    @FXML
    private Label verif;
    public void veriftf()
    {
      // quantitetf.getText().matches("^\d+$");
               
    }
    
  
     @FXML
    public void SupprimerAction(ActionEvent event) {
        
        
        int id=(Integer.parseInt(ids.getText()));
        if (sup.isSelected()) 
        {
         System.out.println("okkkk!");
        
         a.Supprimer(id);
        
        viewProduit(event);
        try{cleartf(event);}
        catch (Exception ex)
        {System.out.println(ex);}
        
        }
        
        
        
        
        
    }
    @FXML
    public ComboBox<String> comboboxx;
    ObservableList<String> list=FXCollections.observableArrayList("Plantes","Fleurs");
    @FXML
    public ComboBox<String> typebox;
    ObservableList<String> list1=FXCollections.observableArrayList("Alstroemeria","Amaryllis","Anthurium","Aster","Oiseau de paradis","Bupleurum","arbustes","arbres","plantes grimpantes et les lianes");
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        comboboxx.setItems(list);
        typebox.setItems(list1);
      
    }    

    @FXML
    private void Importimage(ActionEvent event) {
       
       Stage window = new Stage();
                 selectedFile = fileChooser.showOpenDialog(window);
                
                if(selectedFile!=null)
                {
                    
                    
                    textArea.setText(selectedFile.getAbsolutePath());
                    image1 = new Image(selectedFile.toURI().toString(),100,150,true,true);
                    imagview = new ImageView(image1);
                    imagview.setFitHeight(100);
                    imagview.setFitWidth(100);
                    imagview.setPreserveRatio(true);
                    
                    imageV.getChildren().addAll(imagview);
                    System.out.println(selectedFile.getName());
                }
        System.out.println("image imported ");
        
    }
    private produit p;

    @FXML
    public void selectitem()
    {p=table.getSelectionModel().getSelectedItem();
    if (p!=null)
    {
    idtf.setText(String.valueOf(p.getId()));
    nomtf.setText(p.getNom());
    recherche.setText(p.getNom());
    prixtf.setText(String.valueOf(p.getPrix()));
    quantitetf.setText(String.valueOf(p.getQuantite()));
    ids.setText(String.valueOf(p.getId()));
    comboboxx.setValue(p.getCategorie());
    typebox.setValue(p.getType());
        imagesource = new TextField(p.getImage());
         imagview= new ImageView(imagesource.getText());
        imagview.setFitHeight(100);
        imagview.setFitWidth(100);
        imageV.getChildren().setAll(imagview);
    
    }
    
    
    
    }
    

    @FXML
    private void ModifierAction(ActionEvent event) {
        p.setId(Integer.parseInt(idtf.getText()));
        p.setNom(nomtf.getText());
        p.setQuantite(Integer.parseInt(quantitetf.getText()));
        p.setPrix(Float.parseFloat(prixtf.getText()));
        p.setPrix_initial(Float.parseFloat(prixtf.getText()));
        p.setCategorie(comboboxx.getValue().toString());
        p.setType(typebox.getValue().toString());
        a.modifier(p, p.getId());
        viewProduit(event);
        try {
            cleartf(event);
        } catch (Exception e) {
            System.out.println(e);
            System.out.println("problem");
        }

        
        
    }
@FXML
    private Button deconnecter;

    @FXML
    private void showfxml2(ActionEvent event) throws IOException {
     
            Parent root=null;
            
        root = FXMLLoader.load(getClass().getResource("StatistiqueProduitFXML.fxml"));
        
        Scene scene = new Scene(root);
        scene.getStylesheets().add(getClass().getResource("/css_produit/css_gestionProduit.css").toExternalForm());
        ((Node)event.getSource()).getScene().getWindow().hide();
        Stage stage=new Stage();
        stage.setScene(scene);
  
        //jdid
        
   
        
        //jdid
        
        stage.show();
         
        
}
    

    
    
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

   @FXML
   private  Button pdfb;
   @FXML
   private  Label labelpdf;
   @FXML
   public void pdfc()
   { pdf p=new pdf();
   
   p.creation();
   labelpdf.setText("pdf crée avec succes !");
 }
   
   @FXML
   private Button rechercher;
   @FXML
   private TextField recherche;
   @FXML
   public void rechercher(ActionEvent event)
   { String nom=recherche.getText();
        
    DatabaseConnection dbc = database.DatabaseConnection.getDatabaseConnection();
    
    data.clear();
    try {
            Connection con = dbc.getConnection();
            String sql="SELECT * FROM produits where nom=?";
            
            PreparedStatement stat=con.prepareStatement(sql);
            stat.setString(1,nom);
            ResultSet rs=stat.executeQuery();
            while(rs.next()) {
                System.out.println("ok");
               data.add(new produit(rs.getInt(1),rs.getString(2),rs.getFloat(3),rs.getFloat(4),rs.getInt(5),rs.getString(6),rs.getString(7),rs.getString(8) ));
            }
            
            
        }
    
        catch (Exception ex)
        {System.out.println(ex);
         System.out.println("non!");}
        
     colnom.setCellValueFactory(new PropertyValueFactory<produit,String>("nom"));
    colprix.setCellValueFactory(new PropertyValueFactory<produit,Float>("prix"));
    colprixin.setCellValueFactory(new PropertyValueFactory<produit,Float>("prix_initial"));
    colquan.setCellValueFactory(new PropertyValueFactory<produit,Integer>("quantite"));
    colimage.setCellValueFactory(new PropertyValueFactory<produit,String>("image"));
    colcategorie.setCellValueFactory(new PropertyValueFactory<produit,String>("categorie"));
    coltype.setCellValueFactory(new PropertyValueFactory<produit,String>("type"));
    table.setItems(data);
    
   
   }
@FXML
private Button vider;
    

@FXML
    private Button back;
 @FXML
    public void back(ActionEvent event) throws IOException
    {
    
    
    Parent root=null;
        root = FXMLLoader.load(getClass().getResource("home.fxml"));
        
        Scene scene = new Scene(root);
        scene.getStylesheets().add(getClass().getResource("/css_produit/css_gestionProduit.css").toExternalForm());
        ((Node)event.getSource()).getScene().getWindow().hide();
        Stage stage=new Stage();
        stage.setScene(scene);
        stage.show();
    
    
    
    
    
    
    
    
    
    }

    @FXML
    private void verifNom(javafx.scene.input.KeyEvent event) {
       

    nomtf.textProperty().addListener(new ChangeListener<String>() {

        @Override
        public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
            if (oldValue.matches("[a-zA-Z]+")) {
           nomtf.setStyle("-fx-background-color: linear-gradient(#f0ff35, #a9ff00),\n" +
"        radial-gradient(center 50% -40%, radius 200%, #b8ee36 45%, #80c800 50%);");   
           afficher.setVisible(true);

        }
           else
            {
              nomtf.setStyle("-fx-background-color: red;"); 
              afficher.setVisible(false);

            }
    }

        });
}
   

 @FXML
    private void verifPrix(javafx.scene.input.KeyEvent event) {
       

    prixtf.textProperty().addListener(new ChangeListener<String>() {

        @Override
        public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
            if (oldValue.matches("^\\d+$")) {
           prixtf.setStyle("-fx-background-color: linear-gradient(#f0ff35, #a9ff00),\n" +
"        radial-gradient(center 50% -40%, radius 200%, #b8ee36 45%, #80c800 50%);");   
           afficher.setVisible(true);

        }
           else
            {
              prixtf.setStyle("-fx-background-color: red;"); 
              afficher.setVisible(false);

            }
    }

        });
}

@FXML
    private void verifQuantite(javafx.scene.input.KeyEvent event) {
       

    quantitetf.textProperty().addListener(new ChangeListener<String>() {

        @Override
        public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
            if (oldValue.matches("^\\d+$")) {
           quantitetf.setStyle("-fx-background-color: linear-gradient(#f0ff35, #a9ff00),\n" +
"        radial-gradient(center 50% -40%, radius 200%, #b8ee36 45%, #80c800 50%);");   
           afficher.setVisible(true);

        }
           else
            {
              quantitetf.setStyle("-fx-background-color: red;"); 
              afficher.setVisible(false);

            }
    }

        });
}























}

   
    
              
    

    

