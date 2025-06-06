<%@page import="com.example.dao.StudentDao" %>
<html>

<body bgcolor="#c1f38c ">
<jsp:useBean id="s1" class="com.example.bean.StudentBean">
<jsp:setProperty name="s1" property="*"/>
</jsp:useBean>
<%=StudentDao.addStudent(s1)+" record inserted successfully..." %>
</body>
</html>