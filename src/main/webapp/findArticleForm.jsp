<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Formulaire cr�ation article</title>
</head>
<body>
<h1>Rechercher un article (utiliser une m�thode)</h1>

	<form action="FindArticleServlet" method="POST">
		
		
		<input type="text" id="name" name="designation" />
		<label for="name">Rechercher par d�signation</label>  <br/>
		
		<input type="text" id="name2" name="id" />
		<label for="name2">Recherche par Id</label>  <br/>
		
		<input type="text" id="name3" name="searchByDesignation" />
		<label for="name3">Recherche approximative par designation</label>  <br/>
		
		
		
		
	<input type="submit" id="name3" value="Valider" /> </br>
	
	
		
	</form>
	
	 ${msg} </br>
	<a href="${pageContext.request.contextPath}/index"> Retour </a>
</body>
</html>