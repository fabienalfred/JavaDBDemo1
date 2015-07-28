package metier;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class Commande {
    private int numCom;
    private Date dateCom;
    private int idClient;
    private List<Lot> listLots = new ArrayList<>();
    
    public Commande(){
    }
    
    public Commande(int numCom) {
		this.numCom = numCom ;
	}
    
    public Commande(int numCom, Date dateCom, Date dateLiv, int idClient){
        this.numCom = numCom;
        this.dateCom = dateCom;
        this.idClient = idClient;
    }

	public int getNumCom() {
        return numCom;
    }

    public void setNumCom(int idArticle) {
        this.numCom = idArticle;
    }

    public Date getDateCom() {
		return dateCom;
	}

	public void setDateCom(Date dateCom) {
		this.dateCom = dateCom;
	}

	public int getIdClient() {
        return idClient;
    }

    public void setIdClient(int qtestock) {
        this.idClient = qtestock;
    }

	public List<Lot> getListLots() {
		return listLots;
	}
    
}
