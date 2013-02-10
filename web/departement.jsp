<%-- 
    Document   : departement
    Created on : 13 nov. 2012, 15:21:02
    Author     : Suiken
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="style/styles.css">

        <title>JSP Page</title>
    </head>
    <body>
        <h1>M&eacute;decins par d&eacute;partement</h1>
        <form method="POST" action="Control">
            <table>
                <c:forEach var="unDep" items="${lesDeps}">
                    <tr>
                        <td><input type="radio" name="choixDepartement" value="${unDep.num}"/></td>
                        <td>${unDep.num}</td>
                    </tr>
                </c:forEach>
            </table>
            <input type="submit" value="Voir"/>
        </form>
    </body>
</html>
