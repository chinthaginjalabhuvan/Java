<html>

<body bgcolor="#1cd18f">

<% 

int n1=Integer.parseInt(request.getParameter("num1"));

%>

<table border="4">

<tr><th>Number</th><th>Value</th><th>Result</th></tr>

<%for(int i=1;i<=10;i++){ %>

<tr><td><%=n1 %></td><td><%=i %></td><td><%=(i*n1) %></td></tr>

<%} %>

</table>



</body>

</html>