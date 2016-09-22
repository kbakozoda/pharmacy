<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="/struts-tags" prefix="s" %>
<html>
<head>
    <title>Create new pharmacy</title>
</head>
<body>
<h1>Create new drug</h1>
<s:form action="docreateph">
    <s:actionerror/>
    <s:textfield label="It's number" type="number" min="100" max="1000000" name="pharmacy.number" />
    <s:textfield label="Enter address" name="pharmacy.address"></s:textfield>
    <s:submit value="Submit"/>
</s:form>
</body>
</html>
