<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <link href="${pageContext.request.contextPath}/resources/css/site.css" rel="stylesheet">
        <title>JSP Page</title>
    </head>
    <body>
        <nav class="navbar navbar-inverse">
          <div class="container-fluid">
            <div class="navbar-header">
                <a class="navbar-brand" href="#">Biblioth&egrave;que de d&eacute;partement</a>
            </div>
            <ul class="nav navbar-nav">
              <li><a href="catalogue">Catalogue</a></li>
              <li class="active"><a href="#">Ajouter un livre</a></li>
            </ul>
            <ul class="nav navbar-nav navbar-right">
              <li><a href="${pageContext.request.contextPath}/user/logout"><span class="glyphicon glyphicon-log-out"></span>Déconnexion</a></li>
            </ul>
          </div>
        </nav>
        <h5 class="text-danger">${message}</h5>
        <form action="ajout" method="POST">
            <div class="form-group">
                <label for="isbn">ISBN: </label>
                <input type="text" name="isbn" id="isbn" class="form-control col-sm-10" value="${livre.isbn}"/>
            </div>
            <div class="form-group">
                <label for="title">Titre: </label>
                <input type="text" name="title" id="title" class="form-control col-sm-10" value="${livre.title}"/>
            </div>
            <div class="form-group">
                <label for="author">Auteur: </label>
                <input type="text" name="author" id="author" class="form-control col-sm-10" value="${livre.author}"/>
            </div>
            <div class="form-group">
                <label for="nbPages">Nombre de pages: </label>
                <input type="text" name="nbPages" id="nbPages" class="form-control col-sm-10" value="${livre.nbPages}"/>
            </div>
            <div class="form-group">
                <label for="edition">&Eacute;dition: </label>
                <input type="text" name="edition" id="edition" class="form-control col-sm-10" value="${livre.edition}"/>
            </div>
            <div class="form-group">
                <label for="year">Année de publication: </label>
                <input type="text" name="year" id="year" class="form-control col-sm-10" value="${livre.year}"/>
            </div>
            <div class="form-group">
                <label for="language">Langage: </label>
                <input type="text" name="language" id="language" class="form-control col-sm-10" value="${livre.language}"/>
            </div>
            <div class="form-group">
                <label for="description">Description: </label>
                <textarea name="description" id="description" class="form-control col-sm-10" rows="5">${livre.description}</textarea>
            </div>
            <div class="form-group">
                <label for="keywords">Mot-clé: </label>
                <input type="text" name="keywords" id="keywords" class="form-control col-sm-10" value="${livre.keywords}"/>
            </div>
            <button type="submit" class="btn btn-default">Ajouter</button>
        </form>
    </body>
</html>
