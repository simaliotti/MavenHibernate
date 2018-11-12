<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>

<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
<meta charset="UTF-8">
<title>Delete list article</title>
</head>
<body>

	<h1>Selectionner l'article que vous souhaitez supprimer</h1>



	<form action="DeleteArticleServlet" method="POST">

		<select name="delete">

			<c:forEach items="${articles}" var="article">
				
				<option value="${article.idArticle}">${article.designation }</option>	
				
				
			</c:forEach>
			<br/>
		</select> <input type="submit" value="Supprimer" />



	</form>




	<br />

	<a href="${pageContext.request.contextPath}/index"> Retour </a>
	<br />

</body>
</html>