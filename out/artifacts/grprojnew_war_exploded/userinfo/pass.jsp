<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="/struts-tags" prefix="s" %>
<html>
<head>
    <title>Password change</title>
</head>
<s:actionerror/>
<body>
<s:form action="updatePass">
    <s:textfield name="oldPass" type="password" label="Old password"/>
    <s:textfield name="newPass" type="password" label="New password"/>
    <s:textfield name="newPassConf" type="password" label="Confirm it"/>
    <s:submit/>
</s:form>
</body>
</html>
