/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Modele;

import java.util.Collection;
import java.util.TreeSet;

/**
 *
 * @author Suiken
 */
public class Specialite implements Comparable{
    private String spe;
    private Collection<Medecin> lesMeds = new TreeSet<Medecin>();
    
    public Specialite(String spe){
        this.spe = spe;
    }
    
    public String getSpecialite(){
        return this.spe;
    }
    
    public void addMed(Medecin unMed){
        lesMeds.add(unMed);
    }
    
    public void addMeds(Collection<Medecin> lesMeds){
        this.lesMeds = lesMeds;
    }
    
    public Collection<Medecin> getLesMeds(){
        return this.lesMeds;
    }

    @Override
    public int compareTo(Object t) {
            return this.spe.compareTo(((Specialite)t).getSpecialite());
    }
}
