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
import metier.Client;
import metier.Commande;
import util.BddFab;

public class DaoClient {
	public static void insert(Client client) {
		try {
			Connection conn = BddFab.connect();
			String sql = "insert into client values (?,?,?,?,?,?, null)";
			java.sql.PreparedStatement stat = conn.prepareStatement(sql);

			stat.setInt(1, client.getIdclient());
			stat.setString(2, client.getRaisonsociale());
			stat.setString(3, client.getAdresse());
			stat.setString(4, client.getCodepostal());
			stat.setString(5, client.getVille());
			stat.setString(6, client.getTelephone());

			stat.executeUpdate();
			System.out.println("Une ligne inserée.");
			BddFab.commit(conn);
			BddFab.disconnect(conn);
			;
		} catch (SQLException ex) {
			Logger.getLogger(DaoClient.class.getName()).log(Level.SEVERE, null, ex);
		}

	}

	public static void update(Client client) {
		try {
			Connection conn = BddFab.connect();
			String sql = "update client set adresse = ?, codepostal = ?, ville = ?, telephone =? where idclient = ? ";
			java.sql.PreparedStatement stat = conn.prepareStatement(sql);

			stat.setString(1, client.getAdresse());
			stat.setString(2, client.getCodepostal());
			stat.setString(3, client.getVille());
			stat.setString(4, client.getTelephone());
			stat.setInt(5, client.getIdclient());

			stat.executeUpdate();
			System.out.println("Une ligne updatée.");
			BddFab.commit(conn);
			BddFab.disconnect(conn);
		} catch (SQLException ex) {
			Logger.getLogger(DaoClient.class.getName()).log(Level.SEVERE, null, ex);
		}

	}

	public static void delete(Client client) {
		try {
			Connection conn = BddFab.connect();
			String sql = "delete from client where idclient = ? ";
			java.sql.PreparedStatement stat = conn.prepareStatement(sql);

			stat.setInt(1, client.getIdclient());

			stat.executeUpdate();
			System.out.println("Une ligne supprimée.");
			BddFab.commit(conn);
			BddFab.disconnect(conn);
		} catch (SQLException ex) {
			Logger.getLogger(DaoClient.class.getName()).log(Level.SEVERE, null, ex);
		}

	}

	public static int selectIdByName(String rs) {
		try {
			Connection conn = BddFab.connect();
			String sql = "select idclient from client where raisonsociale = '" + rs + "'";
			java.sql.PreparedStatement stat = conn.prepareStatement(sql);

			ResultSet res = stat.executeQuery(sql);
			res.next();
			int id = res.getInt("idclient");

			BddFab.commit(conn);
			BddFab.disconnect(conn);
			return id;
		} catch (SQLException ex) {
			Logger.getLogger(DaoClient.class.getName()).log(Level.SEVERE, null, ex);
			return 0;
		}

	}

	public static List<Client> selectAllNames() {
		List<Client> listeClient = new ArrayList<>();
		try {

			Connection conn = BddFab.connect();
			String sql = "SELECT raisonsociale FROM client order by 1";
			Statement stat = conn.createStatement();
			ResultSet res = stat.executeQuery(sql);

			while (res.next()) {
				Client client = new Client(res.getString(1));
				listeClient.add(client);
			}

			BddFab.disconnect(conn);

		} catch (SQLException ex) {
			Logger.getLogger(DaoClient.class.getName()).log(Level.SEVERE, null, ex);
		}
		return listeClient;

	}
    
    public static List<Commande> getCommandesByIdclient(Client client){
        List<Commande> listCommandes = new ArrayList<>();
        try {
            Connection conn = BddFab.connect();
            String query = "select numcom from Commande where idclient=? order by 1";
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setInt(1, client.getIdclient());
            ResultSet rs = pstmt.executeQuery();
            while(rs.next()){
                listCommandes.add(new Commande(rs.getInt(1)));
            }
            BddFab.disconnect(conn);
        } catch (SQLException ex) {
            Logger.getLogger(DaoCommande.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listCommandes;
    }

}
