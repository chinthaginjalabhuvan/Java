<html>

<body bgcolor="green">

<%String user=request.getParameter("user");

out.println("Hai "+user);

session.setAttribute("aaa", user);

%>

<a href="session3.jsp">Click me</a>

</body>

</html>