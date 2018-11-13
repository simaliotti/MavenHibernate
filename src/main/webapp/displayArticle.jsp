<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Article</title>
</head>
<body>
	<h1>Article</h1>
	
	
	<p> Nom : ${article.designation} </br>
		id : ${article.idArticle}  </br>
		catégorie : ${article.categorie.nom}  </br>
			
			<form action="UpdateArticleServlet" method="GET">
			<input type="hidden" name="update" value="${article.idArticle}" /> 
			<input type="submit" value=" Modifier  " />
			</form>

	 		<form action="DeleteArticleServlet" method="POST">
			<input type="hidden" name="delete" value="${article.idArticle}" /> 
			<input type="submit" value="Supprimer" />
			</form> 
		
		</p>

	<br>
	<br>
	
		<a href="${pageContext.request.contextPath}/index"> Retour </a>
</body>
</html>
