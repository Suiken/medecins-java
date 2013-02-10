/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controleur;

import Modele.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;
import java.util.HashSet;
import java.util.TreeSet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Suiken
 */
public class Control extends HttpServlet {

    /**
     * Processes requests for both HTTP
     * <code>GET</code> and
     * <code>POST</code> methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    private Pays pays;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String choix = request.getParameter("choix");
        String choixDepartement = request.getParameter("choixDepartement");
        String choixNom = request.getParameter("choixNom");
        String choixSpe = request.getParameter("choixSpe");
        String laPage = null;
        if (choix != null) { //L'utilisateur a choisi un tri par nom ou par département
            if (choix.equals("departement")) { //L'utilisateur a choisi un tri par département
                Collection<Departement> lesDeps = pays.getLesDeps();
                request.setAttribute("lesDeps", lesDeps);
                laPage = "departement.jsp";
            } else if(choix.equals("nom")){  // L'utilisateur a choisi un tri par nom
                laPage = "nom.jsp";
            }else{ // L'utilisateur a choisi un tri par spécialité
                Collection<Specialite> lesSpe = pays.getLesSpe();
                request.setAttribute("lesSpe", lesSpe);
                laPage = "specialite.jsp";
            }
        } else if(choixDepartement!=null || choixNom!=null){ // L'utilisateur a choisi un département ou a saisi un nom
            if (choixDepartement != null) { // L'utilisateur a choisi un département
                Collection<Medecin> MedsDep = pays.getLeDep(choixDepartement).getLesMeds();
                request.setAttribute("leDep", choixDepartement);
                request.setAttribute("lesMeds", MedsDep);
                laPage = "medecinDepartement.jsp";
            } else { // L'utilisateur a saisi un nom
                Collection<Medecin> meds = new TreeSet<Medecin>();
                for (Departement unDep : pays.getLesDeps()) {
                    for (Medecin unMed : unDep.getLesMeds()) {
                        if (unMed.getNom().startsWith(choixNom)) {
                            meds.add(unMed);
                        }
                    }
                }
                request.setAttribute("leNom", choixNom);
                request.setAttribute("lesMeds", meds);
                laPage = "medecinNom.jsp";
            }
        }else if(choixSpe != null){ // L'utilisateur est censé avoir choisi une specialite
            Specialite uneSpe = pays.getLaSpe(choixSpe);
            Collection<Medecin> lesMeds = uneSpe.getLesMeds();
            request.setAttribute("laSpe", uneSpe.getSpecialite());
            request.setAttribute("lesMeds", lesMeds);
            laPage = "medecinSpecialite.jsp";
        }
        request.getRequestDispatcher(laPage).forward(request, response);
    }
// <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">

    /**
     * Handles the HTTP
     * <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP
     * <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        pays = new Pays();
    }
}
