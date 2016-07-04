<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2016/6/28
  Time: 10:26
  To change this template use File | Settings | File Templates.
--%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form:form commandName="student" action="/valid/signup" method="post">
        <form:errors path="*"></form:errors>
        <br/>
        <form:label path="name">用户名：</form:label>
        <form:input path="name"></form:input>
        <form:errors path="name"></form:errors>
    </form:form>
</body>
</html>
