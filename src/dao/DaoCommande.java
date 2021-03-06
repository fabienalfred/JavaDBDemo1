package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import metier.Article;
import metier.Client;
import metier.Commande;
import metier.Lot;
import util.BddFab;

public class DaoCommande {
	public static void insert(Client client, Commande commande) {
		try {
			Connection conn = BddFab.connect();
			String query = "insert into Commande values(?,?,?)";
			PreparedStatement pstmt = conn.prepareStatement(query);

			pstmt.setInt(1, commande.getNumCom());
			pstmt.setInt(2, client.getIdClient());
			pstmt.setDate(3, commande.getDateCom());

			if (pstmt.executeUpdate() == 0)
				System.out.println("Aucun enregistrement correspondant");
			else
				System.out.println("Insertion complete");
			System.out.println("Insertion complete");
			BddFab.commit(conn);
			BddFab.disconnect(conn);
		} catch (SQLException ex) {
			Logger.getLogger(DaoCommande.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

	public static void update(Client client, Commande commande) {
		try {
			Connection conn = BddFab.connect();
			String query = "update Commande " + "set idclient = ? " + "set datecom = ?" + "where numcom = ?";
			PreparedStatement pstmt = conn.prepareStatement(query);

			pstmt.setInt(1, client.getIdClient());
			pstmt.setDate(2, commande.getDateCom());
			pstmt.setInt(3, commande.getNumCom());

			if (pstmt.executeUpdate() == 0)
				System.out.println("Aucun enregistrement correspondant");
			else
				System.out.println("Update complete");
			BddFab.commit(conn);
			BddFab.disconnect(conn);
		} catch (SQLException ex) {
			Logger.getLogger(DaoCommande.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

	public static void delete(Commande commande) {
		try {
			Connection conn = BddFab.connect();
			String query = "delete from Commande where numcom=?";
			PreparedStatement pstmt = conn.prepareStatement(query);

			pstmt.setInt(1, commande.getNumCom());

			if (pstmt.executeUpdate() == 0)
				System.out.println("Aucun enregistrement correspondant");
			else
				System.out.println("Deletion complete");
			BddFab.commit(conn);
			BddFab.disconnect(conn);
		} catch (SQLException ex) {
			Logger.getLogger(DaoCommande.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

	
	/** Remplit la liste de lots d'une commande donnée **/
	public static void setListLotsByNumcom(Commande commande) {
		try {
            Connection conn = BddFab.connect();
            String query = "select idarticle, designation, qtecom from Ligne_com "
            				+ "join Article using(idarticle) where numcom=? order by 1";
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setInt(1, commande.getNumCom());
            ResultSet rs = pstmt.executeQuery();
            while(rs.next()){
            	commande.getListLots().add(new Lot(new Article(rs.getInt(1),rs.getString(2)),rs.getInt(3)));
            }
            BddFab.disconnect(conn);
        } catch (SQLException ex) {
            Logger.getLogger(DaoCommande.class.getName()).log(Level.SEVERE, null, ex);
        }
	}
	
	

}
