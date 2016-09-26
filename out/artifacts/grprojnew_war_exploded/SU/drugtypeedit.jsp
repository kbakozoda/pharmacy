<%@taglib uri="/struts-tags" prefix="s" %>
<html>
<head>
    <title>Edit</title>
</head>
<body>
<h1>Edit</h1>
<s:actionerror/>
<s:hidden name="drugType.id" value="%{drugType.id}"/>
<s:form action="updatedrugtype">
    <s:push value="drugType">
        <s:hidden name="drugType.id"/>
        <s:textfield label="Edit drug type name" name="drugType.name"></s:textfield>
        <s:submit value="Submit"/>
    </s:push>
</s:form>
</body>
</html>
