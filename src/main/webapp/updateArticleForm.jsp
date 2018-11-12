<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update Article</title>
</head>
<body>

<h1>Modifier l'article ${article.designation}</h1>

	
	
	<form action="UpdateArticleServlet" method="POST">
		
		<input type="hidden" value="${article.idArticle }" name="idArticle" />
		
		<input type="text" id="name" value="${article.designation }" name="designation" />
		<label for="name">Désignation</label>  <br/>
		
		<input type="text" id="name2" value="${article.nbPoints}" name="nbPoints" />
		<label for="name2">Nombre de points</label>  <br/>
		
		<input type="text" id="name3" value="${article.stock}" name="stock" />
		<label for="name3">Nombre de points</label>  <br/>
		
		<input type="text" id="name4" value="${article.categorie.nom}" name="categorie" />
		<label for="name4">Catégorie</label>  <br/>
		
		
	<input type="submit" id="name3" value="Valider" />
		
	</form>

</body>
</html>