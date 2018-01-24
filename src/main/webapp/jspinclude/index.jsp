<%--
  Created by IntelliJ IDEA.
  User: hanchao
  Date: 2018/1/17
  Time: 18:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<jsp:include page="include.jsp" flush="true">
    <jsp:param name="name" value="${name}"/>
    <jsp:param name="sex" value="${sex}"/>
</jsp:include>
<head>
    <title>测试jsp include</title>
    <h3>name:${name}</h3>
    <h3>sex:${sex}</h3>
</head>
<body>


</body>
</html>
