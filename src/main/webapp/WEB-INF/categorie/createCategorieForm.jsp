<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Formulaire cr�ation cat�gorie</title>
</head>
<body>
<h1>Cr�er une cat�gorie</h1>

	<form action="CreateCategorieServlet" method="POST">
		
		
		<input type="text" id="name" name="name" />
		<label for="name">Nom</label>  <br/>
		
		
		
		
	<input type="submit" id="name3" value="Valider" /> </br>
	<a href="${pageContext.request.contextPath}/index"> Retour </a>
		
	</form>

</body>
</html>