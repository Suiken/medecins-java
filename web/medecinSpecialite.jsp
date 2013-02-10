<%-- 
    Document   : medecinSpecialite
    Created on : 27 nov. 2012, 15:46:38
    Author     : Suiken
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="style/styles.css">
        <title>M&eacute;decins par sp&eacute;cialit&eacute;</title>
    </head>
    <body>
        <h1>M&eacute;decins par sp&eacute;cialit&eacute; : ${laSpe}</h1>
        <table>
            <tr>
                <th>Nom</th>
                <th>Pr&eacute;nom</th>
                <th>Adresse</th>
                <th>T&eacute;l&eacute;phone</th>
                <th>D&eacute;partement</th>
            </tr>
        <c:forEach var="unMed" items="${lesMeds}">
            <tr>
                <td>${unMed.nom}</td>
                <td>${unMed.prenom}</td>
                <td>${unMed.adresse}</td>
                <td>${unMed.tel}</td>
                <td>${unMed.dep}</td>
            </tr>
        </c:forEach>
        </table>
    </body>
</html>
