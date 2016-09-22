<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="/struts-tags" prefix="s" %>
<html>
<head>
    <title>Welcome Admin!</title>
</head>
<body>
    <h1>Welcome <s:property value="username"></s:property></h1>
    <a href="logout.action">logout</a>
    <a href="pharmacies.action">View pharmacies in my network</a>
    <a href="requests.action">View requests</a>
</body>
</html>
