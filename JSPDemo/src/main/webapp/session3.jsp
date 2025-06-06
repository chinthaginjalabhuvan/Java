<html>

<body bgcolor="blue">

Hai <%=session.getAttribute("aaa") %>

<%session.invalidate(); %>

<br/>

<a href="session4.jsp">Click me</a>

</body>

</html>