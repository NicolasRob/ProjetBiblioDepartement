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
        <nav class="navbar navbar-inverse">
          <div class="container-fluid">
            <div class="navbar-header">
                <a class="navbar-brand" href="#">Biblioth&egrave;que de d&eacute;partement</a>
            </div>
            <ul class="nav navbar-nav">
              <li class="active"><a href="#">Catalogue</a></li>
              <li><a href="${pageContext.request.contextPath}/book/ajout">Ajouter un livre</a></li>
            </ul>
            <ul class="nav navbar-nav navbar-right">
              <li><a href="${pageContext.request.contextPath}/user/logout"><span class="glyphicon glyphicon-log-out"></span>Déconnexion</a></li>
            </ul>
          </div>
        </nav>
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
                        <td>${unLivre.isbn}</td>
                        <td>${unLivre.author}</td>
                        <td>${unLivre.title}</td>
                        <td>${unLivre.nbPages}</td>
                        <td>${unLivre.edition}</td>
                        <td>${unLivre.year}</td>
                        <td>${unLivre.language}</td>
                        <td>${unLivre.description}</td>
                        <td>${unLivre.keywords}</td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
        <script>
            <!-- Utilisation d'un composant JS Datatables pour offrir pagination, trie, recherche -->
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
