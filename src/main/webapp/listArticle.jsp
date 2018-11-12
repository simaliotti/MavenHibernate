<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Liste des Articles</title>
</head>
<body>
	<h1>Liste des Articles</h1>
	<br>
	<c:forEach var="article" items="${articles}">
		<h2>${article.designation} ${article.idArticle } (${article.categorie.nom})
			
			<form action="UpdateArticleServlet" method="GET">
			<input type="hidden" name="update" value="${article.idArticle}" /> 
			<input type="submit" value=" Modifier  " />
			</form>

	 		<form action="DeleteArticleServlet" method="POST">
			<input type="hidden" name="delete" value="${article.idArticle}" /> 
			<input type="submit" value="Supprimer" />
			</form> 
		
		</h2>
	</c:forEach>
	<br>
	<br>
	<p>Nombre total d'article(s): ${articles.size()}</p> </br>
		<a href="${pageContext.request.contextPath}/DeleteAllArticleServlet">Suprrimer tous les articles</a> <br />
		<a href="${pageContext.request.contextPath}/index"> Retour </a>
</body>
</html>
