<%@taglib uri="/struts-tags" prefix="s" %>
<html>
<head>
    <title>Edit</title>
</head>
<body>
<h1>Edit</h1>
<s:actionerror/>

<s:hidden value="drug.id" name="drug.id"></s:hidden>
<s:hidden value="drug.typeid" name="drug.typeId"></s:hidden>

<s:form action="drugupdate">
    <s:push value="drug">
        <s:hidden name="drug.id"/>
        <s:hidden name="drug.typeId"/>
        <s:textfield label="Enter drug name" name="drug.name"></s:textfield>
        <s:select list="drTypeNameList" name="selType" headerValue="Select its type" headerKey="nll"/>
        <s:textfield label="Age restriction" type="number" min="0" max="18" name="drug.ageRestrict" />
        <s:textarea label="Instruction" name="drug.instruction"/>
        <s:submit value="Submit"/>
    </s:push>
</s:form>
</body>
</html>