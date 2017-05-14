<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Remain drops</title>
    </head>
    <body>
        <h1>Remain drops</h1>
        How many drops can remain if your relief will have following heights:
        <form action="${pageContext.request.contextPath}/resources/volume/" method="post">
            <input type="text" name="relief" id="relief" />
            <input type="submit" />
        </form>
    </body>
</html>
