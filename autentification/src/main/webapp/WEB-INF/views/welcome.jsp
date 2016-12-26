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

<div class="row">
    <div class="col-md-1"></div>
    <div class="col-md-4"><h2>Welcome ${pageContext.request.userPrincipal.name}</h2></div>

    <div class="col-md-4"></div>

    <div class="col-md-3"><h2><a onclick="document.forms['logoutForm'].submit()">Logout</a></h2></div>

    <form id="logoutForm" method="POST" action="${contextPath}/logout">
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
    </form>
</div>

<div class="row">
    <div class="col-md-3"></div>
</div>

<div class="container">
    <div class="row">
        <div class="col-md-4">
            <!--Avatar-->
            <c:if test="${fn:length(user.avatarBase64) gt 50}">
                <img src="${user.avatarBase64}" class="img-thumbnail" width="130px" alt="avatar"/>
            </c:if>

            <c:if test="${fn:length(user.avatarBase64) < 50}">
                <form method="POST" action="${contextPath}/doUpload?${_csrf.parameterName}=${_csrf.token}"
                      enctype="multipart/form-data" class="form-signin">
                    <p>Select a photo to avtatara</p>
                    <input type="file" name="fileUpload" size="50"
                           placeholder="select avtatara"/>
                    <button class="btn btn-primary btn-md" type="submit">download</button>
                </form>
            </c:if>

            <%--<c:if test="${!empty listFriends}">--%>
            <div class="table-responsive">
                <table class="table">
                    <caption>Friends List</caption>
                    <a href="${contextPath}/managefriends">Edit list friends</a>
                    <c:if test="${!empty listFriends}">
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
                    </c:if>
                </table>
            </div>
            <%--   </c:if>--%>
        </div>


        <div class="col-md-2"></div>
        <div class="col-md-4">
            <c:if test="${!empty userInfoForm}">
                <div class="table-responsive">
                    <table class="table">
                        <caption>User information</caption>
                        <a href="${contextPath}/userinfo">Edit user info</a>
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