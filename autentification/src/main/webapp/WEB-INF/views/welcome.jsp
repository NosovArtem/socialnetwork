<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="th" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Welcome</title>

    <link href="${contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>

<div class="container">

    <c:if test="${fn:length(user.avatarBase64) gt 50}">
        <img width="100px" src="${user.avatarBase64}" alt="avatar" />
    </c:if>

    <form id="logoutForm" method="POST" action="${contextPath}/logout">
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
    </form>

    <h2>Welcome ${pageContext.request.userPrincipal.name} | <a
            onclick="document.forms['logoutForm'].submit()">Logout</a>
    </h2>

    <h2>Friends List</h2>

    <c:if test="${!empty listFriends}">
        <table class="tg">
            <tr>
                <th width="80">ID</th>
                <th width="120">Login</th>
            </tr>
            <c:forEach items="${listFriends}" var="user">
                <tr>
                    <td><c:if test="${fn:length(user.avatarBase64) gt 50}">
                        <img width="50px" src="${user.avatarBase64}" alt="avatar" />
                    </c:if></td>
                    <td><a href="${contextPath}/friends/${user.id}">${user.username}</a></td>
                </tr>
            </c:forEach>
        </table>
    </c:if>

    <form method="POST" action="${contextPath}/doUpload?${_csrf.parameterName}=${_csrf.token}"
          enctype="multipart/form-data" class="form-signin">
        <h2 class="form-heading">Log in</h2>
        <input type="file" class="form-control" name="fileUpload" size="50"/>
        <button class="btn btn-lg btn-primary btn-block" type="submit">Log In</button>
    </form>

</div>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script src="${contextPath}/resources/js/bootstrap.min.js"></script>
</body>
</html>