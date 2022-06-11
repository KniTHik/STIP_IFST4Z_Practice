<%@ page language="java" contentType="text/html; charset=UTF-8"
 pageEncoding="UTF-8"%>
<html>
<body>
<html>
<head>
<title>Using JSP/POST Method to Read Form Data</title>
</head>
<body>
<h1>Использование JSP/POST Method to Read Form Data</h1>
<ul>
<li><b>Имя:</b>
 <%= request.getParameter("first_name")%>
</li>
<li><b>Фамилия:</b>
 <%= request.getParameter("last_name")%>
</li>
<%
String genderParam = request.getParameter("gender");
if (genderParam != null) {
String genderHtml = (genderParam.equalsIgnoreCase("male"))? ("<li><b>Пол:</b> Мужской</li>") : ("<li><b>Пол:</b>Женский</li>");
out.println(genderHtml);
}
%>
<li><b>Студент: </b>
<%= request.getParameter("student")%>
<li><b>Эмплой: </b>
<%= request.getParameter("employee")%>
<li><b>Другой: </b>
<%= request.getParameter("other")%>
</ul>
</body>
</html>
</body>
</html>