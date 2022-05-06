<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%@ include file="menu.jsp" %>
	<p><c:out value="Bonjourno jstl"/></p>
	<p>Bonjour ! ${ empty name ? '' : name } 
	<!-- verifie avec un bool si vide ou non puis condition ternaire ? = si et : = else -->
	<!-- meme effet qu'en dessous mais ne rend pas de null quand l'info ne transite pas -->
	<%
		String name = (String) request.getAttribute("name");
		out.println(name);
	%>
	</p>
	<p>
	${ noms[1] } ${ auteur.prenom }
	</p>
	<p>${7*1}
	<% 
		String heure = (String) request.getAttribute("heure");
		if (heure.equals("jour")){
			out.println("Bonjour");
		}else{
			out.println("Bonsoir");
		}
	%>
	</p>
	<p>
	<% 
		String variable = (String) request.getAttribute("variable");
		out.println(variable);
	%>
	</p>
	<p>
	<% 
		for (int i=0; i<20; i++){
			out.println("new ligne <br/>");
		}
	%>
	</p>
</body>
</html>