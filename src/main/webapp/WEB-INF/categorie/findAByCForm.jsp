<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>

<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
<meta charset="UTF-8">
<title>List articles by category</title>
</head>
<body>

	<h1>Lister les articles d'une categorie</h1>



	<form action="FindArticlesByCategorieServlet" method="POST">

		<select name="nom">

			<c:forEach items="${categories}" var="categorie">
				
				<option value="${categorie.nom}">${categorie.nom }</option>	
				
				
			</c:forEach>
			<br/>
		</select> <input type="submit" value="Rechercher" />



	</form>




	<br />

	<a href="${pageContext.request.contextPath}/index"> Retour </a>
	<br />

</body>
</html>