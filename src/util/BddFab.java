package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BddFab {
    private static String pilot = "oracle.jdbc.OracleDriver";
    private static String url = "jdbc:oracle:thin:@localhost:1521:XE";
    private static String user = "fab";
    private static String pswd = "fab";
    
    public static Connection connect(){
        Connection conn = null;
        try {
            Class.forName(pilot);
            conn = DriverManager.getConnection(url, user, pswd);
            System.out.println(">>> Connexion réussie <<<\n");
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(BddFab.class.getName()).log(Level.SEVERE, null, ex);
        }
        return conn;
    }
    
    public static void disconnect(Connection conn){
        try {
            conn.close();
            System.out.println("\n>>> Déconnecté <<<");
        } catch (SQLException ex) {
            Logger.getLogger(BddFab.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void commit(Connection conn){
        try {
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(BddFab.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
