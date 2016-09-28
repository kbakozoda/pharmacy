<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create new content</title>
</head>
<body>
<div class="flex-container">
    <header><h1>Create new content</h1></header>
    <nav class="nav">
        <ui>
            <li><a href="welcome.action">Dashboard</a> </li>
        </ui>
    </nav>
    <article class="article">
    <s:actionerror/>

<s:form action="doCreate">
   <s:textfield type="number" label="Price for single" name="stockElement.priceOfSingle" value="stockElement.priceOfSingle"/>
   <s:textfield type="number" label="Amount" name="stockElement.amount" value="stockElement.amount"/>
   <s:select list="selectDrug" name="selected" headerValue="Select drug" headerKey="nll"/>
    <s:submit value="Add"/>
</s:form>
    </article>
<footer id="copyright">Copyright 2016, Soldiers inc.</footer>
</div>
</body>
</html>
