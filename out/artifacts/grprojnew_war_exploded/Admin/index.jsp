<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="/struts-tags" prefix="s" %>
<html>
<head>
    <title>Welcome Admin!</title>
</head>
<body>
    <h1>Welcome <s:property value="username"></s:property></h1>
    <a href="logout.action">logout</a> <br>
    <a href="pharmacies.action">View pharmacies in my network</a> <br>
    <a href="requests.action">View requests</a> <br>
    <a href="/user/info">My credentials</a> <br>
    <a href="pharmacists.action">Pharmacists</a>
</body>
</html>
