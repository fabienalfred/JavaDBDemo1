package metier;

public class Article {
    private int idArticle;
    private String designation;
    private float prixUnit;
    private int qtestock;
    
    public Article(){
    }
    
    public Article(String des){
        this.designation = des;
    }
    
    public Article(int id, String des, int prix, int qte){
        this.idArticle = id;
        this.designation = des;
        this.prixUnit = prix;
        this.qtestock = qte;
    }

    /**
     * @return the idArticle
     */
    public int getIdArticle() {
        return idArticle;
    }

    /**
     * @param idArticle the idArticle to set
     */
    public void setIdArticle(int idArticle) {
        this.idArticle = idArticle;
    }

    /**
     * @return the designation
     */
    public String getDesignation() {
        return designation;
    }

    /**
     * @param designation the designation to set
     */
    public void setDesignation(String designation) {
        this.designation = designation;
    }

    /**
     * @return the prixUnit
     */
    public float getPrixUnit() {
        return prixUnit;
    }

    /**
     * @param prixUnit the prixUnit to set
     */
    public void setPrixUnit(float prixUnit) {
        this.prixUnit = prixUnit;
    }

    /**
     * @return the qtestock
     */
    public int getQtestock() {
        return qtestock;
    }

    /**
     * @param qtestock the qtestock to set
     */
    public void setQtestock(int qtestock) {
        this.qtestock = qtestock;
    }
    
    
}
