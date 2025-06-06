<%@page import="com.example.dao.StudentDao" %>
<html>

<body bgcolor="#8cb6f3 ">
<jsp:useBean id="s1" class="com.example.bean.StudentBean">
<jsp:setProperty name="s1" property="*"/>
</jsp:useBean>
<%=StudentDao.updateStudent(s1)+" record updated successfully..." %>
</body>
</html>