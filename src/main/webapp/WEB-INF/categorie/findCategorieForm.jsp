<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Formulaire création article</title>
</head>
<body>
<h1>Rechercher une categorie </h1>

	<form action="FindCategorieServlet" method="POST">
		
		
		<input type="text" id="name" name="nom" />
		<label for="name">Nom</label>  <br/>
		
		
	<input type="submit" id="name3" value="Valider" /> </br>
	
	
		
	</form>
	
	 ${msg} </br>
	<a href="${pageContext.request.contextPath}/index"> Retour </a>
</body>
</html>