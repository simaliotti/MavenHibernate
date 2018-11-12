<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Liste des Catégories</title>
</head>
<body>
	<h1>Liste des catégories</h1>
	<br>
	<c:forEach var="categorie" items="${categories}">
		<p>${categorie.nom} ${categorie.idCategorie } 
			
			<form action="UpdateArticleServlet" method="GET">
			<input type="hidden" name="update" value="${categorie.idCategorie }" /> 
			<input type="submit" value=" Modifier  " />
			</form>

	 		<form action="DeleteArticleServlet" method="POST">
			<input type="hidden" name="delete" value="${categorie.idCategorie }" /> 
			<input type="submit" value="Supprimer" />
			</form> 
		
		</p>
	</c:forEach>
	<br>
	<br>
	<p>Nombre total de categorie(s): ${categories.size()}</p> </br>
		
		<a href="${pageContext.request.contextPath}/DeleteAllArticleServlet">Suprrimer tous les articles</a> <br /><br />
		<a href="${pageContext.request.contextPath}/index"> Retour </a>
</body>
</html>
