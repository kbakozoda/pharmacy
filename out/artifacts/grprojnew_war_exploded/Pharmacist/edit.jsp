<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit existing content</title>
</head>
<body>
<h1>Edit stock content</h1>
<s:actionerror/>
<s:hidden name="stockElement.id" value="stockElement.id"/>
<s:hidden name="stockElement.drugId" value="stockElement.drugId"/>
<s:hidden name="stockElement.pharmacyId" value="stockElement.pharmacyId"/>
<s:hidden name="stockElement.networkId" value="stockElement.networkId"/>
<s:form action="doEdit">
    <s:push value="stockElement">
        <s:hidden name="stockElement.id"/>
        <s:hidden name="stockElement.drugId"/>
        <s:hidden name="stockElement.pharmacyId"/>
        <s:hidden name="stockElement.networkId"/>
        <s:textfield label="Enter price of single" type="number" min="0" max="1000000" name="stockElement.priceOfSingle"/>
        <s:textfield label="Enter amount" type="number" min="0" max="1000000" name="stockElement.amount"/>
        <s:submit value="Save"/>
    </s:push>
</s:form>
</body>
</html>
