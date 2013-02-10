/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Modele;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Collection;
import java.util.HashSet;
import java.util.TreeSet;
import Modele.*;

/**
 *
 * @author Suiken
 */
public class DAO {

    public static Collection<Departement> getLesDeps() {
        Collection<Departement> lesDeps = new TreeSet<Departement>();
        try {
            Connection con = Modele.Connect.get();

            Statement reqDep;
            reqDep = con.createStatement();
            ResultSet rsDep = reqDep.executeQuery("select distinct(departement) from medecin");

            Medecin unMed;
            Departement leDep;
            while (rsDep.next()) {
                Statement reqMed;
                reqMed = con.createStatement();
                ResultSet rsMed = reqMed.executeQuery("select distinct(departement) from medecin");
                Collection<Medecin> lesMeds = new TreeSet<Medecin>();
                /*while (rsMed.next()) {
                    unMed = new Medecin(rsMed.getString("nom"), rsMed.getString("prenom"), rsMed.getString("adresse"),
                            rsMed.getString("tel"), rsMed.getString("specialiteComplementaire"), rsMed.getString("id"));
                    lesMeds.add(unMed);
                }*/
                leDep = new Departement(rsDep.getString("departement"));
                lesDeps.add(leDep);
            }
        } catch (SQLException e) {
            System.out.println("Erreur SQL:" + e);
        }
        return lesDeps;
    }

    public static Collection<Specialite> getLesSpe() {
        Collection<Specialite> lesSpe = new TreeSet<Specialite>();
        try {
            Connection con = Modele.Connect.get();

            Statement reqSpe;
            reqSpe = con.createStatement();
            ResultSet rsSpe = reqSpe.executeQuery("select distinct(specialiteComplementaire) from medecin where specialiteComplementaire is not null");

            while (rsSpe.next()) {
                Specialite laSpe = new Specialite(rsSpe.getString("specialiteComplementaire"));
                lesSpe.add(laSpe);
            }
        } catch (SQLException e) {
            System.out.println("Erreur SQL:" + e);
        }
        return lesSpe;
    }
    
    public static Collection<Medecin> getLesMeds(){
        Collection<Medecin> lesMeds = new TreeSet<Medecin>();
        try{
        Connection con = Modele.Connect.get();
        
        Statement reqMed = con.createStatement();
        ResultSet rsMed = reqMed.executeQuery("select * from medecin");
        
        while(rsMed.next()){
            Medecin unMed = new Medecin(rsMed.getString("nom"), rsMed.getString("prenom"), rsMed.getString("adresse"),
                    rsMed.getString("tel"), rsMed.getString("specialiteComplementaire"), rsMed.getString("id"),
                    rsMed.getString("departement"));
            lesMeds.add(unMed);
        }
        
        }catch(SQLException e){
            System.out.println("Erreur SQL:" + e);
        }
        return lesMeds;
    }
}
