package demofab1;

import java.util.List;
import metier.Client;
import metier.Commande;
import metier.Lot;
import metier.Article;

public class DemoFab1 {

	public static void main(String[] args) {
		
		/***** Article *****/

		// Initialiser Article
		// Article article = new Article();
		// article.setIdArticle(8);
		// article.setDesignation("Ecran plat");
		// article.setPrixUnit(500);
		// article.setQtestock(10);

		// Insertion
		// dao.DaoArticle.insert(article);

		// Deletion
		// dao.DaoArticle.delete(article);

		// Update stock
		// article.setIdArticle(8);
		// article.setQtestock(20);
		// dao.DaoArticle.updateStock(article);

		// Get all designations
		// List<Article> listArticles =
		// dao.DaoArticle.getAllArticleDesignations();
		// for(Article art : listArticles){
		// System.out.println(art.getDesignation());
		// }

		
		/***** Commande *****/

		// Initialiser Commande et Client
		// Commande commande = new Commande();
		// commande.setNumCom(20);
		// Client client = new Client();
		// client.setIdClient(1);

		// Insertion
		// dao.DaoCommande.delete(commande);
		// dao.DaoCommande.insert(client, commande);

		// Deletion
		// dao.DaoCommande.delete(commande);
		// Update
		// Get articles
		// dao.DaoCommande.setListLotsByNumcom(commande);
		// for(Lot lot : commande.getListLots()){
		// System.out.println("article : "+lot.getArticle().getDesignation() + "
		// qtecom : "+lot.getQteCom());
		// }

		
		/***** Client *****/

		// Initialiser Client
		// Client client = new Client();
		// client.setIdClient(1);

		// Insertion
		// Deletion

		// Remplir liste de commandes par client
		// dao.DaoClient.setListCommandesByIdclient(client);
		// Remplir liste de lots par commande
		// for(Commande c : client.getListCommandes()){
		// dao.DaoCommande.setListLotsByNumcom(c);
		// }
		// Parcours de la liste et print de chaque article
		// for(Commande c : client.getListCommandes()){
		// System.out.println("commande : "+c.getNumCom());
		// for(Lot lot : c.getListLots()){
		// System.out.println("article : "+lot.getArticle().getDesignation() + "
		// qtecom : " +lot.getQteCom());
		// }
		// }

		// Parcours de la liste et print du numero de commande
		// for(Commande com : client.getListCommandes()){
		// System.out.println(com.getNumCom());
		// }

		
		/***** Lot *****/
		// Initialiser Article
		// Article article = new Article();
		// article.setIdArticle(11);
		// article.setDesignation("Clé usb");
		// article.setPrixUnit(30);
		// article.setQtestock(10);

		// Initialiser Lot
		// Lot lot = new Lot();
		// lot.setArticle(article);
		// lot.setQteCom(5);

		// Initialiser Commande
		// Commande commande = new Commande();
		// commande.setNumCom(10);
		// commande.setIdClient(1);
		// commande.setDateCom(null);
		// commande.getListLots().add(lot);

		// Deletions - insertions
		// dao.DaoLot.delete(commande, lot);
		// dao.DaoCommande.delete(commande);
		// dao.DaoArticle.delete(article);
		// dao.DaoArticle.insert(article);
		// dao.DaoCommande.insert(commande);
		// dao.DaoLot.insert(commande, lot);
	}
}
