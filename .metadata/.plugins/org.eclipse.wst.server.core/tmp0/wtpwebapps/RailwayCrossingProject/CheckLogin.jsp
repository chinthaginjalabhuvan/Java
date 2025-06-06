<%@page import="com.railway.dao.RailwayCrossingDao"%>

<html>

	<body>
		<%String email=request.getParameter("email");
		String pass=request.getParameter("pass");
		if(RailwayCrossingDao.checkLogin(email, pass).equals("Valid"))
		{
		%>
		<jsp:forward page="AdminHome.jsp"/>
		<%} else{%>
		<jsp:forward page="Login.jsp"/>
		<%} %>
	</body>

</html>

