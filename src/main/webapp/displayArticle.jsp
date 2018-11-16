<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
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
			<%--<input type="submit" value="Supprimer" /> --%>
			<button type="submit" class="btn">Supprimer</button>
			
			<%--button type="submit" class="btn"  --%> <%--pour envoyer un form  --%>
			<%--button type="button" class="btn" --%>  <%--pour vers un lien  --%>
			</form> 
		
		</p>

	<br>
	<br>
	
		<a href="${pageContext.request.contextPath}/index"> Retour </a>
</body>
</html>
