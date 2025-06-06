<%@page import="com.example.dao.StudentDao" %>
<html>

<body bgcolor="#f5367b ">
<jsp:useBean id="s1" class="com.example.bean.StudentBean">
<jsp:setProperty name="s1" property="*"/>
</jsp:useBean>
<% int rollno=Integer.parseInt(request.getParameter("rollno"));
out.println(StudentDao.deleteStudent(rollno)+" record deleted successfully...");%>
</body>
</html>