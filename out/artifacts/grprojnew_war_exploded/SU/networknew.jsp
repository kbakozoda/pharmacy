<%@taglib uri="/struts-tags" prefix="s" %>
<html>
<head>
    <title>Create new Network</title>
</head>
<body>
<s:actionerror/>
<h1>Create new drug type</h1>
<s:form action="docreatenet">
    <s:textfield label="Enter network's name" name="network.name"></s:textfield>
    <s:submit value="Submit"/>
</s:form>
</body>
</html>
