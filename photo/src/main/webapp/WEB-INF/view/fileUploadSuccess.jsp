<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<html>
<body>
<h2>Spring MVC file upload example</h2>

FileName : "
<strong> ${fileName} </strong>" - Uploaded Successful.

<form method="GET" action="/fileUploadForm">
    <table>
        <tr>
            <td>
                <input type="submit" value="Upload new photo"/>
            </td>
        </tr>
    </table>
</form>

</body>
</html>