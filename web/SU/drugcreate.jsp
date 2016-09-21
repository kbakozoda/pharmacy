<%@taglib uri="/struts-tags" prefix="s" %>
<html>
<head>
    <title>Create new drug type</title>
</head>
<body>
<h1>Create new drug</h1>
<s:form action="adddrug">
    <s:actionerror/>
    <s:textfield label="Enter drug name" name="name"></s:textfield>
    <s:select list="drTypeNameList" name="selType" headerValue="Select its type" headerKey="nll"/>
    <s:textfield label="Age restriction" type="number" min="0" max="18" name="agerestriction" />
    <s:textarea label="Instruction" name="instruction"/>
    <s:submit value="Submit"/>
</s:form>
</body>
</html>
