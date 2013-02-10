<%-- 
    Document   : nom
    Created on : 13 nov. 2012, 15:20:50
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
        <h1>M&eacute;decins par nom</h1>
        <form action="Control" method="POST">
            <input type="text" name="choixNom"/>
            <input type="submit" value="Valider"/>
        </form>
    </body>
</html>
