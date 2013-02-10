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
public class Departement implements Comparable{
    private String num;
    private Collection<Medecin> lesMeds = new TreeSet<Medecin>();
    
    public Departement(String num){
        this.num = num;
    }
    
    public String getNum(){
        return this.num;
    }
    
    public void addMedecin(Medecin unMed){
        this.lesMeds.add(unMed);
    }
    
    public int compteTo(Object t){
        return 0;
    }
    
    public Collection<Medecin> getLesMeds(){
        return this.lesMeds;
    }

    @Override
    public int compareTo(Object t) {
        return this.num.compareTo(((Departement)t).getNum());
    }
}
