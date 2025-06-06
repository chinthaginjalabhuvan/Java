<%@page import="com.railway.dao.RailwayCrossingDao"%>

<%@page import="com.railway.bean.RegisterBean"%>

<html>
	<body>	
		<%String name=request.getParameter("name");		
		String email=request.getParameter("email");		
		String password=request.getParameter("pass");		
		RegisterBean rb=new RegisterBean();		
		rb.setName(name);		
		rb.setEmail(email);		
		rb.setPassword(password);		
		if(RailwayCrossingDao.register(rb).equals("SUCCESS"))		
		{%>		
			<jsp:forward page="Login.jsp"/>		
		<%}		
		else{%>		
		<jsp:forward page="Register.jsp"/>		
		<%} %>
	</body>
</html>