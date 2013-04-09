<%-- 
    Document   : index
    Created on : 12 nov. 2012, 11:15:15
    Author     : Suiken
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="style/styles.css">
        <title>Pays</title>
    </head>
    <body>
        <center><img src="images/logo.jpg"></center>
        <h1>France</h1>
        <form method="POST" action="Control">
            <table>
                <tr>
                    <td><input type="radio" name="choix" value="departement"/></td>
                    <td>Liste des m&eacute;decins par d&eacute;partement</td>
                </tr>
                <tr>
                    <td><input type="radio" name="choix" value="nom"/></td>
                    <td>Liste des m&eacute;decins par nom</td>
                </tr>
                <tr>
                    <td><input type="radio" name="choix" value="specialite"</td>
                    <td>Liste des m&eacute;decins par sp&eacute;cialit&eacute;</td>
                </tr>
            </table>
            <input type="submit" value="Valider"/>
        </form>
    </body>
</html>
