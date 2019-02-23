/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package akthem;

/**
 *
 * @author AKTHEM
 */
import Entities.produit;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Font.FontFamily;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import com.mysql.jdbc.Connection;
import database.DatabaseConnection;
import java.awt.Color;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Date;



public class pdf {
    

    public void creation()
    { produit p=new produit();
        DatabaseConnection dbc = database.DatabaseConnection.getDatabaseConnection();
        try {

            OutputStream file = new FileOutputStream(new File("D:\\T.pdf"));


            Document document = new Document();

            PdfWriter.getInstance(document, file);


            document.open();
                    
            
            
          document.add(new Paragraph(new Date().toGMTString()));
          Font bold = new Font(FontFamily.COURIER, 12, Font.NORMAL, BaseColor.GREEN);
          Font b = new Font(FontFamily.COURIER, 12, Font.NORMAL, BaseColor.DARK_GRAY);
          Paragraph paragraph = new Paragraph("SHOPETAL",bold);
            paragraph.setAlignment(Element.ALIGN_RIGHT);
            document.add(paragraph);  
           paragraph = new Paragraph("Le produit le plus disponible",bold);
            paragraph.setAlignment(Element.ALIGN_CENTER);
            document.add(paragraph);
            
            paragraph = new Paragraph("\n");
     document.add(paragraph);
      paragraph = new Paragraph(" \n");
      document.add(paragraph);
       paragraph = new Paragraph(" \n");
       document.add(paragraph);
        paragraph = new Paragraph(" \n");
        document.add(paragraph);
         paragraph = new Paragraph(" \n");
         document.add(paragraph);
          paragraph = new Paragraph(" \n");
          document.add(paragraph);
            
                
    
    try {
            Connection con = dbc.getConnection();
            String sql="SELECT * FROM `produits` ORDER BY quantite DESC LIMIT 1";
            PreparedStatement stat=con.prepareStatement(sql);
            ResultSet rs=stat.executeQuery();
            while(rs.next()) {
                p.setId(rs.getInt(1));
                p.setNom(rs.getString(2));
                p.setPrix(rs.getFloat(3));
                p.setQuantite(rs.getInt(4));
                p.setImage(rs.getString(5));
                
               
            }
            paragraph = new Paragraph(p.toString(),b);
            paragraph.setAlignment(Element.ALIGN_LEFT);
            paragraph.setIndentationLeft(50);
            document.add(paragraph);
             
            
        }
    
        catch (Exception ex)
        {System.out.println(ex);
         System.out.println("non!");}
  
     paragraph = new Paragraph("\n");
     document.add(paragraph);
      paragraph = new Paragraph(" \n");
      document.add(paragraph);
       paragraph = new Paragraph(" \n");
       document.add(paragraph);
        paragraph = new Paragraph(" \n");
        document.add(paragraph);
         paragraph = new Paragraph(" \n");
         document.add(paragraph);
          paragraph = new Paragraph(" \n");
          document.add(paragraph);
     paragraph = new Paragraph("\n");
     document.add(paragraph);
      paragraph = new Paragraph(" \n");
      document.add(paragraph);
       paragraph = new Paragraph(" \n");
       document.add(paragraph);
        paragraph = new Paragraph(" \n");
        document.add(paragraph);
         paragraph = new Paragraph(" \n");
         document.add(paragraph);
          paragraph = new Paragraph(" \n");
          document.add(paragraph);
    paragraph = new Paragraph("Responsable stock",bold);
            paragraph.setAlignment(Element.ALIGN_RIGHT);
            document.add(paragraph);
            paragraph = new Paragraph("Akthem Arfaoui",b);
            paragraph.setAlignment(Element.ALIGN_RIGHT);
            document.add(paragraph);
            
            
            


            document.close();

            file.close();


        } catch (Exception e) {


            e.printStackTrace();

        }

    }

    }




   


    



