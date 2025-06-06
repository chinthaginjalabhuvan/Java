<html>

<body>

<% String usr=request.getParameter("user");

String pss=request.getParameter("pass");

if((usr.equals("Admin"))&&(pss.equals("123")))

{

%>

<%@include file="Valid.html" %>

<%} 

else

{

%>

<%@include file="Invalid.html" %>

<%} %>

</body>

</html>