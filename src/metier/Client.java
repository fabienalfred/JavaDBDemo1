/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metier;

import java.util.ArrayList;
import java.util.List;

public class Client {
    private int idClient;
    private String raisonsociale;
    private String adresse;
    private String codepostal;
    private String ville;
    private String telephone;
    private List<Commande> listCommandes = new ArrayList<>();

    public Client() {
    }

    public Client(int idClient){
    	this.idClient = idClient;
    }
    
    public Client(String raisonsociale) {
        this.raisonsociale = raisonsociale;
    }

    public Client(int idclient, String raisonsociale, String adresse, String codepostal, String ville, String telephone) {
        this.idClient = idclient;
        this.raisonsociale = raisonsociale;
        this.adresse = adresse;
        this.codepostal = codepostal;
        this.ville = ville;
        this.telephone = telephone;
    }

    public int getIdClient(){
    	return this.idClient;
    }
    
    public void setIdClient(int idclient) {
        this.idClient = idclient;
    }

    public void setRaisonsociale(String raisonsociale) {
        this.raisonsociale = raisonsociale;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public void setCodepostal(String codepostal) {
        this.codepostal = codepostal;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public int getIdclient() {
        return idClient;
    }

    public String getRaisonsociale() {
        return raisonsociale;
    }

    public String getAdresse() {
        return adresse;
    }

    public String getCodepostal() {
        return codepostal;
    }

    public String getVille() {
        return ville;
    }

    public String getTelephone() {
        return telephone;
    }

	public List<Commande> getListCommandes() {
		return listCommandes;
	}














}



