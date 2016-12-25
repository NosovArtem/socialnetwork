<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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

    <title>Manage Friends</title>

    <link href="${contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
    <link href="${contextPath}/resources/css/common.css" rel="stylesheet">


    <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>

</head>
<body>
<h2 class="form-signin-heading">Add friends</h2>

<div>
    <h2>Manage Friends</h2>
    <table class="table">
        <tr>
            <th>Foto</th>
            <th>Username</th>
            <th>Action</th>
        </tr>
        <c:forEach items="${users}" var="userDTO">
            <tr>
                <td><c:if test="${fn:length(userDTO.user.avatarBase64) gt 50}">
                    <img width="50px" src="${userDTO.user.avatarBase64}" alt="avatar"/>
                </c:if></td>
                <td><a href="${contextPath}/friends/${userDTO.user.id}">${userDTO.user.username}</a></td>
                <td>
                    <form method="POST" action="${contextPath}/managefriends" class="form-signin">
                        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                        <input type="hidden" name="userId" value="${userDTO.user.id}"/>
                        <c:if test="${!userDTO.friend}">
                            <button class="btn btn-success" name="add" type="submit">Add</button>
                        </c:if>
                        <c:if test="${userDTO.friend}">
                            <button class="btn btn-danger" name="remove" type="submit">Remove</button>
                        </c:if>
                    </form>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>
