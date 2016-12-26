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

    <title>Friend</title>

    <link href="${contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
    <link href="${contextPath}/resources/css/common.css" rel="stylesheet">


    <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
</head>
<body>
<div class="row">
    <div class="col-md-3"><h2><a href="${contextPath}/">Back on main page</a></h2></div>
</div>

<div class="container">
    <div class="row">
        <div class="col-md-4">
            <!--Avatar-->
            <c:if test="${fn:length(user.avatarBase64) gt 50}">
                <img src="${user.avatarBase64}" class="img-thumbnail" width="130px" alt="avatar"/>
            </c:if>
            <h1>${user.username}</h1>

            <c:if test="${!empty listFriends}">
            <div class="table-responsive">
                <table class="table">
                    <caption>Friends List</caption>
                        <tr>
                            <th width="80">Photo</th>
                            <th width="120">Login</th>
                        </tr>
                        <c:forEach items="${listFriends}" var="userDTO">
                            <tr>
                                <td><c:if test="${fn:length(userDTO.avatarBase64) gt 50}">
                                    <img src="${userDTO.avatarBase64}" class="img-circle" alt="avatar" width="50"
                                         height="50">
                                </c:if></td>
                                <td><h3><a href="${contextPath}/friends/${userDTO.id}">${userDTO.username}</a></h3></td>
                            </tr>
                        </c:forEach>
                </table>
            </div>
            </c:if>
        </div>


        <div class="col-md-2"></div>
        <div class="col-md-4">
            <c:if test="${!empty userInfoForm}">
                <div class="table-responsive">
                    <table class="table">
                        <caption>User information</caption>
                        <tr class="">
                            <th width="80">Name</th>
                            <td>${userInfoForm.firstName}</td>
                        </tr>
                        <tr>
                            <th width="120">Last Name</th>
                            <td>${userInfoForm.lastName}</td>
                        </tr>
                        <tr>
                            <th width="120">City</th>
                            <td>${userInfoForm.city}</td>
                        </tr>
                        <tr>
                            <th width="120">Phone</th>
                            <td>${userInfoForm.mobilePhone}</td>
                        </tr>
                        <tr>
                            <th width="120">Religion</th>
                            <td>${userInfoForm.religion}</td>
                        </tr>
                        <tr>
                            <th width="120">Language</th>
                            <td>${userInfoForm.nativeLanguage}</td>
                        </tr>
                        <tr>
                            <th width="120">Book</th>
                            <td>${userInfoForm.favoriteBook}</td>
                        </tr>
                        <tr>
                            <th width="120">Film</th>
                            <td>${userInfoForm.favoriteFilm}</td>
                        </tr>
                        <tr>
                            <th width="120">Music</th>
                            <td>${userInfoForm.favoriteMusic}</td>
                        </tr>
                    </table>
                </div>
            </c:if>
        </div>
    </div>
</div>


<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script src="${contextPath}/resources/js/bootstrap.min.js"></script>
</body>
</html>
