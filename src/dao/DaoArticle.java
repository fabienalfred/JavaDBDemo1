package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import metier.Article;
import util.BddFab;

public class DaoArticle {
    public static void insert(Article article){
        try {
            Connection conn = BddFab.connect();
            String query = "insert into Article values(?,?,?,?)";
            PreparedStatement pstmt = conn.prepareStatement(query);
            
            pstmt.setInt(1, article.getIdArticle());
            pstmt.setString(2, article.getDesignation());
            pstmt.setFloat(3, article.getPrixUnit());
            pstmt.setInt(4, article.getQtestock());
            
            pstmt.executeUpdate();
            System.out.println("Insertion complete");
            BddFab.commit(conn);
            BddFab.disconnect(conn);
        } catch (SQLException ex) {
            Logger.getLogger(DaoArticle.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void update(Article article){
        try {
            Connection conn = BddFab.connect();
            String query = "update Article "
                    + "set idarticle = ?, "
                    + "designation = ?, "
                    + "prixunit = ?, "
                    + "qtestock = ? "
                    + "where idarticle = ?";
            PreparedStatement pstmt = conn.prepareStatement(query);
            
            pstmt.setInt(1, article.getIdArticle());
            pstmt.setString(2, article.getDesignation());
            pstmt.setFloat(3, article.getPrixUnit());
            pstmt.setInt(4, article.getQtestock());
            pstmt.setInt(5, article.getIdArticle());
            
            if(pstmt.executeUpdate()==0)
                System.out.println("Aucun enregistrement correspondant");
            else
                System.out.println("Update complete");
            BddFab.commit(conn);
            BddFab.disconnect(conn);
        } catch (SQLException ex) {
            Logger.getLogger(DaoArticle.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void delete(Article article){
        try {
            Connection conn = BddFab.connect();
            String query = "delete from Article where idarticle=?";
            PreparedStatement pstmt = conn.prepareStatement(query);
            
            pstmt.setInt(1, article.getIdArticle());
            
            if(pstmt.executeUpdate()==0)
                System.out.println("Aucun enregistrement correspondant");
            else
                System.out.println("Deletion complete");
            BddFab.commit(conn);
            BddFab.disconnect(conn);
        } catch (SQLException ex) {
            Logger.getLogger(DaoArticle.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static List<Article> getAllArticleDesignations(){
        List<Article> listArticles = new ArrayList<>();
        try {
            Connection conn = BddFab.connect();
            String query = "select designation from article order by 1";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while(rs.next()){
                listArticles.add(new Article(rs.getString(1)));
            }
            BddFab.disconnect(conn);
        } catch (SQLException ex) {
            Logger.getLogger(DaoArticle.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listArticles;
    }
    
}
