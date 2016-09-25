<%@taglib uri="/struts-tags" prefix="s" %>
<html>
<head>
    <title>Edit network</title>
</head>
<body>
<s:actionerror/>
<s:hidden name="network.id" value="network.id"></s:hidden>
<s:hidden name="network.adminId" value="network.adminId"></s:hidden>
<h1>Edit net info</h1>
<s:form action="updateNet">
    <s:push value="network">
    <s:hidden name="network.id" />
    <s:hidden name="network.adminId" />
    <s:textfield label="Enter network's name" name="network.name"></s:textfield>
    <s:submit value="Submit"/>
    </s:push>
</s:form>
</body>
</html>