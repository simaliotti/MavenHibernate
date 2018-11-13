<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
	<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update Article</title>
</head>
<body>

<h1>Modifier la catégorie ${categorie.nom}</h1>

	
	
	<form action="UpdateCategorieServlet" method="POST">
		
		<input type="hidden" value="${categorie.idCategorie }" name="idCategorie" />
		
		<input type="text" id="name" placeholder="${categorie.nom }" name="nom" />
		<label for="name">Nom</label>  <br/>
		
		
		
		
		
	<input type="submit" id="name3" value="Valider" />
	<p>${msg }</p>	
	</form>
	<a href="${pageContext.request.contextPath}/index"> Retour </a>
</body>
</html>