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

<h1>Modifier l'article ${article.designation}</h1>

	
	
	<form action="UpdateArticleServlet" method="POST">
		
		<input type="hidden" value="${article.idArticle }" name="idArticle" />
		
		<input type="text" id="name" value="${article.designation }" name="designation" />
		<label for="name">Désignation</label>  <br/>
		
		<input type="text" id="name2" value="${article.nbPoints}" name="nbPoints" />
		<label for="name2">Nombre de points</label>  <br/>
		
		<input type="text" id="name3" value="${article.stock}" name="stock" />
		<label for="name3">Stock</label>  <br/>
		
		<select name="categorieName">
			<c:forEach items="${categories}" var="categorie">
				
				 				
          									 
		    	 <c:choose> 
				         <c:when test = "${categorie.nom eq article.categorie.nom}">
				         	<option value="${categorie.nom}" selected>${categorie.nom}</option>	
				         </c:when>
				         
				         
				         <c:otherwise>
				          <option value="${categorie.nom}" >${categorie.nom}</option>	
				         </c:otherwise>
				         </c:choose>
				        
				         	
				       
				
				
			</c:forEach>
		</select>
		
	<input type="submit" id="name3" value="Valider" />
	<p>${msg }</p>	
	</form>

</body>
</html>