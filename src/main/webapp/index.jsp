<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
 <%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Index</title>
</head>
<body>

<h1>Index</h1>
			<a href="${pageContext.request.contextPath}/ArticleListOrdonnedServlet">Lister les articles</a> <br />
			<a href="${pageContext.request.contextPath}/CreateArticleServlet">Cr�er article</a> <br />
			<a href="${pageContext.request.contextPath}/FindArticleServlet">Rechercher un article</a> <br />
			<a href = "<c:url value="/DeleteArticleServlet"/>">Supprimer un article</a>
</body>
</html>