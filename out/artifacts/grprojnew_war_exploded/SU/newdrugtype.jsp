<%@taglib uri="/struts-tags" prefix="s" %>
<html>
<head>
    <title>Create new drug type</title>
</head>
<body>
<s:actionerror/>
    <h1>Create new drug type</h1>
    <s:form action="drugtypecreate">
        <s:textfield label="Enter drug type name" name="drugType.name"></s:textfield>
        <s:submit value="Submit"/>
    </s:form>
</body>
</html>
