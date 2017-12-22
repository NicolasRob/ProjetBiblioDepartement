<%-- 
    Document   : catalogue
    Created on : 11-Dec-2017, 1:22:15 PM
    Author     : Vengor
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <title>Catalogue</title>
    </head>
    <body>
        <h1>Catalogue</h1>
        <hr>
        <h5 class="text-success">${param.message}</h5>
        <table class="table table-striped">
            <tr>
                <td colspan="9"><a href="ajout">Ajouter un livre</a></td>
            </tr>
            <tr>
                <th>ISBN</th>
                <th>Auteur</th>
                <th>Titre</th>
                <th>Pages</th>
                <th>Édition</th>
                <th>Date de publication</th>
                <th>Langage</th>
                <th>Description</th>
                <th>Mot clé</th>
            </tr>
        <c:forEach items="${livres}" var="unLivre">
            <tr>
                <td>${unLivre.getIsbn()}</td>
                <td>${unLivre.getAuthor()}</td>
                <td>${unLivre.getTitle()}</td>
                <td>${unLivre.getNbPages()}</td>
                <td>${unLivre.getEdition()}</td>
                <td>${unLivre.getYear()}</td>
                <td>${unLivre.getLanguage()}</td>
                <td>${unLivre.getDescription()}</td>
                <td>${unLivre.getKeywords()}</td>
            </tr>
        </c:forEach>
        </table>
    </body>
</html>
