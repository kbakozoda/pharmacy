<%@taglib uri="/struts-tags" prefix="s" %>
<html>
<head>
    <title>Edit</title>
</head>
<body>
<h1>Edit</h1>
<s:form action="updatedrugtype">
    <s:textfield label="Edit drug type name" name="name" value="NewName"></s:textfield>
    <s:submit value="Submit"/>
</s:form>
</body>
</html>
