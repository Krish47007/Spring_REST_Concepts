<%--
  Created by IntelliJ IDEA.
  User: krish
  Date: 08/04/21
  Time: 9:53 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Spring REST</title>
</head>
<body>
    <h2>Spring REST Demo</h2>
    <hr />
    <a href="${pageContext.request.contextPath}/test/hello">Hello</a>
    <br />
    <a href="${pageContext.request.contextPath}/api/students">Get all students</a>
</body>
</html>
