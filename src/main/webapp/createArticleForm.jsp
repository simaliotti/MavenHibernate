<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
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
		<label for="name">Designation*</label>  <br/>
		<input type="text" id="name2" name="nbPoints" />
		<label for="name2">nbPoints*</label>  <br/>
		<input type="text" id="name3" name="stock" />
		<label for="name3">stock*</label>  <br/>
	
		
			<select name="categorieName" >
			<c:forEach items="${categories}" var="categorie">
				<option value="${categorie.nom}">${categorie.nom}</option>	
			</c:forEach>
		</select>
		
		
	<input type="submit" id="name3" value="Valider" /> </br>
	<p><font color="red"><em>${msg }</em></font></p>
	<a href="${pageContext.request.contextPath}/index"> Retour </a>
		
	</form>

</body>
</html>