<%-- 
    Document   : medecinNom
    Created on : 19 nov. 2012, 11:33:27
    Author     : Suiken
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="style/styles.css">
        <title>M&eacute;decins par nom</title>
    </head>
    <body>
        <center><img src="images/logo.jpg"></center>
        <h1>M&eacute;decins par Nom: ${leNom}</h1>
        <table>
            <tr>
                <th>Nom</th>
                <th>Pr&eacute;nom</th>
                <th>Adresse</th>
                <th>T&eacute;l&eacute;phone</th>
                <th>Sp&eacute;cialit&eacute;</th>
                <th>D&eacute;partement</th>
            </tr>
            <c:forEach var="unMedecin" items="${lesMeds}">
                <tr>
                    <td>${unMedecin.nom}</td>
                    <td>${unMedecin.prenom}</td>
                    <td>${unMedecin.adresse}</td>
                    <td>${unMedecin.tel}</td>
                    <td>${unMedecin.spe}</td>
                    <td>${unMedecin.dep}</td>
                </tr>
            </c:forEach>
        </table>
</html>
