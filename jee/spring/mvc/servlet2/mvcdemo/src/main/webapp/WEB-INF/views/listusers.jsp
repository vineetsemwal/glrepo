<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!doctype html>

<body>

<h1> Listing all users </h1>

<ul>
<c:forEach items="${users}" var="user">
<li>

Userid: <c:out  value="${user.id}"  />
,
Username: <c:out  value="${user.name}"  />


</li>

</c:forEach>
</ul>

</body>

</html>
