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
		 
			<a href="${pageContext.request.contextPath}/OneArticleServlet?idArticle=${article.idArticle}">${article.designation}</a> <br />	
		
	
		
		
	</c:forEach>
	<br>
	<br>
	<p>Nombre total d'article(s): ${articles.size()}</p> </br>
		<a href="${pageContext.request.contextPath}/ArticleListOrdonnedServlet">Ordonner les articles par désignation</a> <br />
		<a href="${pageContext.request.contextPath}/DeleteAllArticleServlet">Suprrimer tous les articles</a> <br />
		<a href="${pageContext.request.contextPath}/index"> Retour </a>
</body>
</html>
