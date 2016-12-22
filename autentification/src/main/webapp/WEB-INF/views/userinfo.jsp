<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Create an account</title>

    <link href="${contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
    <link href="${contextPath}/resources/css/common.css" rel="stylesheet">


    <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>

</head>

<body>

<div class="container">

    <form:form method="POST" modelAttribute="userInfoForm" class="form-signin">
        <h2 class="form-signin-heading">Create your account</h2>
        <spring:bind path="firstName">
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <form:input type="text" path="firstName" class="form-control" placeholder="firstName"
                            autofocus="true"></form:input>
                <form:errors path="firstName"></form:errors>
            </div>
        </spring:bind>
        <spring:bind path="lastName">
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <form:input type="text" path="lastName" class="form-control" placeholder="lastName"
                            autofocus="true"></form:input>
                <form:errors path="lastName"></form:errors>
            </div>
        </spring:bind>
        <spring:bind path="city">
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <form:input type="text" path="city" class="form-control" placeholder="city"
                            autofocus="true"></form:input>
                <form:errors path="city"></form:errors>
            </div>
        </spring:bind>
        <spring:bind path="mobilePhone">
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <form:input type="text" path="mobilePhone" class="form-control" placeholder="mobilePhone"
                            autofocus="true"></form:input>
                <form:errors path="mobilePhone"></form:errors>
            </div>
        </spring:bind>
        <spring:bind path="nativeLanguage">
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <form:input type="text" path="nativeLanguage" class="form-control" placeholder="nativeLanguage"
                            autofocus="true"></form:input>
                <form:errors path="nativeLanguage"></form:errors>
            </div>
        </spring:bind>
        <spring:bind path="religion">
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <form:input type="text" path="religion" class="form-control" placeholder="religion"
                            autofocus="true"></form:input>
                <form:errors path="religion"></form:errors>
            </div>
        </spring:bind>
        <spring:bind path="interests">
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <form:input type="text" path="interests" class="form-control" placeholder="interests"
                            autofocus="true"></form:input>
                <form:errors path="interests"></form:errors>
            </div>
        </spring:bind>
        <spring:bind path="favoriteMusic">
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <form:input type="text" path="favoriteMusic" class="form-control" placeholder="favoriteMusic"
                            autofocus="true"></form:input>
                <form:errors path="favoriteMusic"></form:errors>
            </div>
        </spring:bind>
        <spring:bind path="favoriteBook">
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <form:input type="text" path="favoriteBook" class="form-control" placeholder="favoriteBook"
                            autofocus="true"></form:input>
                <form:errors path="favoriteBook"></form:errors>
            </div>
        </spring:bind>
        <spring:bind path="favoriteFilm">
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <form:input type="text" path="favoriteFilm" class="form-control" placeholder="favoriteFilm"
                            autofocus="true"></form:input>
                <form:errors path="favoriteFilm"></form:errors>
            </div>
        </spring:bind>

        <button class="btn btn-lg btn-primary btn-block" type="submit">Submit</button>
    </form:form>

</div>
<!-- /container -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script src="${contextPath}/resources/js/bootstrap.min.js"></script>
</body>
</html>