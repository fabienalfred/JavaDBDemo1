package metier;

public class Lot {
	private Article article;
	private int qteStock;
	
	public Lot() {
		
	}
	
	public Lot(Article article, int qteStock){
		this.article = article;
		this.qteStock = qteStock;
	}

	public Article getArticle() {
		return article;
	}

	public void setArticle(Article article) {
		this.article = article;
	}

	public int getQteStock() {
		return qteStock;
	}

	public void setQteStock(int qteStock) {
		this.qteStock = qteStock;
	}
	
	
}
