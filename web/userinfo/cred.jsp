<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="/struts-tags" prefix="s" %>
<html>
<head>
    <title>Credentials</title>
</head>
<body>
<s:actionerror/>
<s:hidden name="user.password" value="user.password"/>
<s:hidden name="user.id" value="user.id"/>
<s:hidden name="user.role" value="user.role"/>
<s:hidden name="user.pharmacyId" value="user.pharmacyId"/>
<s:hidden name="user.networkdId" value="user.networkdId"/>
<s:form action="updateCredentials">
    <s:push value="user">
        <s:hidden name="user.id"/>
        <s:hidden name="user.role"/>
        <s:hidden name="user.password"/>
        <s:hidden name="user.pharmacyId"/>
        <s:hidden name="user.networkdId"/>
        <s:textfield label="Your name" name="user.name"></s:textfield>
        <s:textfield label="Your surname" name="user.surname"></s:textfield>
        <s:textfield label="Your username" name="user.username"></s:textfield>
        <s:submit/>
    </s:push>
</s:form>
</body>
</html>
