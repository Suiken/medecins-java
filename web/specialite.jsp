<%-- 
    Document   : specialite
    Created on : 26 nov. 2012, 10:54:46
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
        <center><img src="images/logo.jpg"></center>
        <form action="Control" method="post">
            <table>
                <c:forEach var="uneSpe" items="${lesSpe}">
                    <tr>
                        <td>
                            <input type="radio" name="choixSpe" value="${uneSpe.specialite}">
                        </td>
                        <td>
                            ${uneSpe.specialite}
                        </td>
                    </tr>
                </c:forEach>
            </table>
            <input type="submit" value="Valider">
        </form>
    </body>
</html>
