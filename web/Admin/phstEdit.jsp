<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit pharmacist</title>
</head>
<body>
<header>
    Edit Pharmacist info
</header>
<s:actionerror/>

<s:hidden name="pharmacist.password" value="pharmacist.password"/>
<s:hidden name="pharmacist.id" value="pharmacist.id"/>
<s:hidden name="pharmacist.role" value="pharmacist.role"/>
<s:hidden name="pharmacist.pharmacyId" value="pharmacist.pharmacyId"/>
<s:hidden name="pharmacist.networkdId" value="pharmacist.networkdId"/>
<s:form action="doPhstEdit">
    <s:push value="pharmacist">
        <s:hidden name="pharmacist.id"/>
        <s:hidden name="pharmacist.role"/>
        <s:hidden name="pharmacist.password"/>
        <s:hidden name="pharmacist.pharmacyId"/>
        <s:hidden name="pharmacist.networkdId"/>
        <s:textfield label="Your name" name="pharmacist.name"></s:textfield>
        <s:textfield label="Your surname" name="pharmacist.surname"></s:textfield>
        <s:textfield label="Your username" name="pharmacist.username"></s:textfield>
        <s:submit value="Save"/>
    </s:push>
</s:form>
</body>
</html>
