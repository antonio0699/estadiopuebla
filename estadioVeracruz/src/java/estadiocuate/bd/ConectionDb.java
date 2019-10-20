/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estadiocuate.bd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author DELL-W8
 */
public class ConectionDb {

    private Connection con;

    public Connection conectar() {

        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/estadiopuebla", "root", "vertrigo");

        } catch (ClassNotFoundException ex) {

            Logger.getLogger(ConectionDb.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ConectionDb.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return con;
    }
}
