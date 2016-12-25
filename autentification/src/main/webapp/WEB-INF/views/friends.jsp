<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<c:if test="${fn:length(user.avatarBase64) gt 50}">
    <img width="100px" src="${user.avatarBase64}" alt="avatar" />
</c:if>
<h1>${user.username}</h1>


</body>
</html>
