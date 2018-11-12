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
	<h1>Article recherché :</h1>
<p>	Désignation : ${article.designation } </br>
	Id : ${article.idArticle } </br>
	Nombre de points : ${article.nbPoints } </br>
	Stock : ${article.stock } </br>
</p>	
<a href="${pageContext.request.contextPath}/index"> Retour </a>
</body>
</html>
