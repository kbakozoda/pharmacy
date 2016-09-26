<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 25.09.2016
  Time: 17:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Pharmacy</title>
</head>
<body>
Name
<s:property value="pharmacy.name"/> <br>
Number
<s:property value="pharmacy.number"/> <br>
Pharmacist username
<s:property value="phUsername"/> <br>
Address
<s:property value="pharmacy.address"/> <br>

<a href="/admin/pharmacies.action">Pharmacy list</a>
</body>
</html>
