<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f" %>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@taglib uri="http://www.springframework.org/tags" prefix="s" %>
<!DOCTYPE html>
<html>

<div>
    <jsp:include page="include/menu.jsp"/>
</div>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>User Registration</title>
    <link href="static/css/style_index.css" rel="stylesheet" type="text/css"/>
</head>
<body>

<div id="main">
    <p>Some text 1 <a href="#">register </a>For register click here.</p>

</div>
<div id="footer">
    <footer>
        <jsp:include page="include/footer.jsp"/>
    </footer>
</div>
</body>
</html>
