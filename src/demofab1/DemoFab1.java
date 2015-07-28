package demofab1;

import java.util.List;
import metier.Client;
import metier.Commande;
import metier.Article;

public class DemoFab1 {

    public static void main(String[] args) {
    	/***** Article *****/
    	
        // Initialiser Article
//        Article article = new Article();
//        article.setIdArticle(8);
//        article.setDesignation("Ecran plat");
//        article.setPrixUnit(500);
//        article.setQtestock(10);

        //Insertion
//       dao.DaoArticle.insert(article);
        
        //Deletion
//        dao.DaoArticle.delete(article);
        
        //Update stock
//        article.setIdArticle(8);
//        article.setQtestock(20);
//        dao.DaoArticle.updateStock(article);
       
       //Get all designations
//       List<Article> listArticles = dao.DaoArticle.getAllArticleDesignations();
//       for(Article art : listArticles){
//           System.out.println(art.getDesignation());
//       }
    	
    	
    	/***** Commande *****/
    	
    	//Initialiser Commande
    	Commande commande = new Commande();
    	commande.setNumCom(1);
    	//Insertion
    	//Deletion
    	//Update
    	//Get articles
    	List<Article> listArticles = dao.DaoCommande.getArticlesByNumcom(commande);
    	for(Article art : listArticles){
          System.out.println(art.getDesignation());
    	}
    	
    	
    	/***** Client *****/
    	
    	//Initialiser Client
//    	Client client = new Client();
//    	client.setIdclient(1);
    	
    	//Insertion
    	//Deletion
    	
    	//Get commandes
//    	List<Commande> listCommandes = dao.DaoClient.getCommandesByIdclient(client);
//    	for(Commande com : listCommandes){
//          System.out.println(com.getNumCom());
//    	}
       
    }

}
