/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Modele;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Suiken
 */
public class Connect {

    private static Connection connection = null;

    public static Connection open() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("Pilote mal installé ..." + e);
        }
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost/cours_gsb", "root", "Cupidon1291");
        } catch (SQLException e) {
            System.out.println("Erreur SQL :" + e);
        }
        return connection;
    }

    public static Connection get() {
        try {
            if (connection == null || connection.isClosed()) {
                connection = Connect.open();
            }
        } catch (SQLException ex) {
            Logger.getLogger(Connect.class.getName()).log(Level.SEVERE, null, ex);
        }
        return connection;
    }

    public static void close() {
        try {
            connection.close();
        } catch (SQLException e) {
            System.out.println("Erreur SQL :" + e);
        }
    }
}
