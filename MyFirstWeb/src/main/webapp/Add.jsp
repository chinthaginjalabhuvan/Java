<html>
<body bgcolor="#DAF7A6 ">
	<% 
		int n1 =Integer.parseInt(request.getParameter("first"));
		int n2 = Integer.parseInt(request.getParameter("second"));
		out.println("The addition of "+n1+" and "+n2+" is "+(n1+n2));
	%>
</body>
</html>