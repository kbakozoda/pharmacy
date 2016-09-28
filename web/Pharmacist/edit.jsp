<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit existing content</title>
</head>
<body>
<div class="flex-container">
<header>
    <h1>Edit stock content</h1>
</header>
<nav class="nav">
    <ul>
        <li><a href="/pharm/index.action">Cancel</a> </li>
        <li><a href="/pharm/logout.action">Logout</a> </li>
    </ul>
</nav>
<article class="article">
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
</article>
<footer id="copyright">
    Copyright 2016, Loosers inc.
</footer>

</div>

</body>
</html>
<%--
<header>

</header>
<nav class="nav">
    <ul>
        <li></li>
    </ul>
</nav>
<article class="article">

</article>
<footer id="copyright">
        Copyright 2016, Loosers inc.
</footer>
--%>