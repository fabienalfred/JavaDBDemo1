package demofab1;

import java.util.List;

import metier.Article;

public class DemoFab1 {

    public static void main(String[] args) {
        // Initialiser Article
        Article article = new Article();
        article.setIdArticle(8);
        article.setDesignation("Ecran plat");
        article.setPrixUnit(500);
        article.setQtestock(10);

        //Insertion
       dao.DaoArticle.insert(article);
        
        //Deletion
//        dao.DaoArticle.delete(article);
        
        //Update
//        article.setIdArticle(8);
//        article.setDesignation("Clé usb");
//        article.setPrixUnit(20);
//        article.setQtestock(40);
//        dao.DaoArticle.update(article);
       
       //Get all designations
       List<Article> listArticles = dao.DaoArticle.getAllArticleDesignations();
       for(Article art : listArticles){
           System.out.println(art.getDesignation());
       }
       
    }

}
