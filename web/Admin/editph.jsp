<%@taglib uri="/struts-tags" prefix="s" %>
<html>
<head>
    <title>Edit Pharmacy</title>
</head>
<body>
<h1>Edit pharmacy info</h1>
<s:actionerror/>
<s:form action="doedit">
    <s:push value="pharmacy">
        <s:hidden name="pharmacy.id" />
        <s:hidden name="pharmacy.networkId"/>
        <s:hidden name="pharmacy.pharmacistId" />
        <s:textfield label="It's number" type="number" min="100" max="1000000" name="pharmacy.number" />
        <s:textfield label="Enter address" name="pharmacy.address"></s:textfield>
        <s:submit value="Submit"/>
    </s:push>
</s:form>
</body>
</html>