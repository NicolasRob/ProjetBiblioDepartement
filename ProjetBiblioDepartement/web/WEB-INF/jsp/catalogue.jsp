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
        <link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/v/bs/dt-1.10.16/datatables.min.css"/>
        <script type="text/javascript" src="https://cdn.datatables.net/v/bs/dt-1.10.16/datatables.min.js"></script>
        <link href="${pageContext.request.contextPath}/resources/css/site.css" rel="stylesheet">
        <title>Catalogue</title>
    </head>
    <body>
        <h1>Catalogue</h1>
        <hr>
        <h3><a href="${pageContext.request.contextPath}/book/ajout">Ajouter un livre</a></h3>
        <br>
        <h5 class="text-success">${param.message}</h5>
        <table id="catalogue" class="table table-striped">
            <thead>
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
            </thead>
            <tbody>
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
            </tbody>
        </table>
        <script>
            $(document).ready(function() {
                $('#catalogue').DataTable({
                    "language": {
                        "url": "//cdn.datatables.net/plug-ins/1.10.16/i18n/French.json"
                    }
                });
            });
        </script>
    </body>
</html>
