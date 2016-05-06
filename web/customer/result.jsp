<%--
  Created by IntelliJ IDEA.
  User: dani
  Date: 4/7/2016
  Time: 9:20 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!--<%//@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>-->
<html>
<head>
    <title>Result</title>
</head>
<body>
    <p>
        The result is :
        <br>
        <%
            out.print(request.getAttribute("resultMessage") );
        %>
    </p>
</body>
</html>
