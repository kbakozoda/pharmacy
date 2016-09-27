<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create new content</title>
</head>
<body>
<s:actionerror/>

<s:form action="doCreate">
   <s:textfield type="number" label="Price for single" name="stockElement.priceOfSingle" value="stockElement.priceOfSingle"/>
   <s:textfield type="number" label="Amount" name="stockElement.amount" value="stockElement.amount"/>
   <s:select list="selectDrug" name="selected" headerValue="Select drug" headerKey="nll"/>
    <s:submit value="Add"/>
</s:form>
</body>
</html>
