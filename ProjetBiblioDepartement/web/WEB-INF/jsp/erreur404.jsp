<%-- 
    Document   : erreur404
    Created on : 21-Dec-2017, 4:37:24 PM
    Author     : Vengor
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="${pageContext.request.contextPath}/resources/css/site.css" rel="stylesheet">
        <title>Erreur 404</title>
    </head>
    <body>
        <h1>Erreur 404</h1>
        <hr>
        <p>La page que vous tentez d'acc&eacute;der n'existe pas</p>
        <a href="${pageContext.request.contextPath}/book/catalogue">Retourner &agrave; l'accueil</a>
    </body>
</html>
