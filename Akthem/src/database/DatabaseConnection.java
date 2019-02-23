/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package database;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author AKTHEM
 */
public class DatabaseConnection {
    private Connection con;
    private static DatabaseConnection dbc;
    private DatabaseConnection ()
    {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("driver loaded!");
            try {
                  con=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/produitsdb","root","");
                System.out.println("conected!");    
            } catch (SQLException ex) {
                System.out.println(ex);            }
            
            
        } catch (ClassNotFoundException ex) {
            System.out.println(ex);        }
    }
    public  static DatabaseConnection getDatabaseConnection()
    { if (dbc==null)
    {
    dbc = new DatabaseConnection();
    }
    return dbc;
    }
   
    public  Connection getConnection()
    { return con;
    }
}
