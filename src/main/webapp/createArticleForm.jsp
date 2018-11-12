<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Formulaire création article</title>
</head>
<body>
<h1>Créer un article</h1>

	<form action="CreateArticleServlet" method="POST">
		
		
		<input type="text" id="name" name="designation" />
		<label for="name">Designation</label>  <br/>
		<input type="text" id="name2" name="nbPoints" />
		<label for="name2">nbPoints</label>  <br/>
		<input type="text" id="name3" name="stock" />
		<label for="name3">stock</label>  <br/>
		<input type="text" id="name4" name="categorieName" />
		<label for="name4">Categorie</label>  <br/>
		
		
	<input type="submit" id="name3" value="Valider" /> </br>
	<a href="${pageContext.request.contextPath}/index"> Retour </a>
		
	</form>

</body>
</html>