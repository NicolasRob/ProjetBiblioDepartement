<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <link href="${pageContext.request.contextPath}/resources/css/site.css" rel="stylesheet">
    </head>
    <body>
        <h1>Inscription</h1>
        <hr>
        <h5 class="text-danger">${message}</h5>
        <form action="inscription" method="POST">
            <div class="form-group">
                <label for="courriel">Courriel: </label>
                <input type="text" name="courriel" id="courriel" class="form-control col-sm-10" value="${courriel}"/>
            </div>
            <div class="form-group">
                <label for="password">Mot de passe: </label>
                <input type="text" name="password" id="password" class="form-control col-sm-10" />
            </div>
            <button type="submit" class="btn btn-default">S'inscrire</button>
        </form>
        <a href="login">Retourner à la page de connection</a>
    </body>
</html>