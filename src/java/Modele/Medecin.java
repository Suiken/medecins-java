/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Modele;

/**
 *
 * @author Suiken
 */
public class Medecin implements Comparable{
    private String nom;
    private String prenom;
    private String adresse;
    private String tel;
    private String spe;
    private String id;
    private String dep;
    
    public Medecin(String nom, String prenom, String adresse, String tel, String spe, String id, String dep){
        this.nom = nom;
        this.prenom = prenom;
        this.adresse = adresse;
        this.tel = tel;
        this.spe = spe;
        this.id = id;
        this.dep = dep;
    }
    
    public String getAdresse(){
        return this.adresse;
    }
    
    public String getNom(){
        return this.nom;
    }
    
    public String getPrenom(){
        return this.prenom;
    }
    
    public String getTel(){
        return this.tel;
    }
    
    public String getSpe(){
        return this.spe;
    }

    public String getId() {
        return this.id;
    }
    
    public String getDep(){
        return this.dep;
    }
    
    @Override
    public int compareTo(Object t){
        if(this.nom.compareTo(((Medecin)t).getNom())==0){
            return this.id.compareTo(((Medecin)t).getId());
        }else{
            return this.nom.compareTo(((Medecin)t).getNom());
        }
    }
}
