package metier;

public class Lot {
	private Article article;
	private int qteCom;
	
	public Lot() {
		
	}
	
	public Lot(Article article, int qteStock){
		this.article = article;
		this.qteCom = qteStock;
	}

	public Article getArticle() {
		return article;
	}

	public void setArticle(Article article) {
		this.article = article;
	}

	public int getQteCom() {
		return qteCom;
	}

	public void setQteCom(int qteStock) {
		this.qteCom = qteStock;
	}
	
	
}
