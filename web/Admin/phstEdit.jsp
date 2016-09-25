<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 25.09.2016
  Time: 22:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit pharmacist</title>
</head>
<body>
<s:actionerror/>

<s:hidden name="pharmacist.password" value="pharmacist.password"/>
<s:hidden name="pharmacist.id" value="pharmacist.id"/>
<s:hidden name="pharmacist.role" value="pharmacist.role"/>
<s:hidden name="pharmacist.pharmacyId" value="pharmacist.pharmacyId"/>
<s:hidden name="pharmacist.networkdId" value="pharmacist.networkdId"/>
<s:form action="phstEdit">
    <s:push value="pharmacist">
        <s:hidden name="pharmacist.id"/>
        <s:hidden name="pharmacist.role"/>
        <s:hidden name="pharmacist.password"/>
        <s:hidden name="pharmacist.pharmacyId"/>
        <s:hidden name="pharmacist.networkdId"/>
        <s:textfield label="Your name" name="pharmacist.name"></s:textfield>
        <s:textfield label="Your surname" name="pharmacist.surname"></s:textfield>
        <s:textfield label="Your username" name="pharmacist.username"></s:textfield>
        <s:select list="phNmbList" label="Choose pharmacy" name="selPh" headerKey="-1"
                  headerValue="Select pharmacy"/>
        <s:submit value="Save"/>
    </s:push>
</s:form>
</body>
</html>
