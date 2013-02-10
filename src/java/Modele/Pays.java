/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Modele;

import java.util.Collection;

/**
 *
 * @author Suiken
 */
public class Pays {
    private Collection<Departement> lesDeps;
    private Collection<Specialite> lesSpe;
    private Collection<Medecin> lesMeds;
    
    public Pays(){
        lesDeps = DAO.getLesDeps();
        lesSpe = DAO.getLesSpe();
        Collection<Medecin> lesMeds = DAO.getLesMeds();
        
        for(Medecin unMed : lesMeds){
            for(Departement unDep : lesDeps){
                if(unDep.getNum().equals(unMed.getDep())){
                    unDep.addMedecin(unMed);
                }
            }
            for(Specialite uneSpe : lesSpe){
                if(uneSpe.getSpecialite().equals(unMed.getSpe())){
                    uneSpe.addMed(unMed);
                }
            }
        }
    }
    
    public Collection<Departement> getLesDeps(){
        return this.lesDeps;
    }
    
    public Collection<Specialite> getLesSpe(){
        return this.lesSpe;
    }
    
    public Specialite getLaSpe(String spe){
        for(Specialite uneSpe : lesSpe){
            if(uneSpe.getSpecialite().equals(spe)){
                return uneSpe;
            }
        }
        return null;
    }
    
    public Departement getLeDep(String numDep){
        for(Departement unDep : lesDeps){
            if(unDep.getNum().equals(numDep)){
                return unDep;
            }
        }
        return null;
    }
}
