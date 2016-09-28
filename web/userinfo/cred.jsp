<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="/struts-tags" prefix="s" %>
<html>
<head>
    <title>Credentials</title>
</head>
<div class="flex-container">
<body>
<header> <h1>Credentials</h1> </header>
<nav class="nav">
    <ul>
        <li>
            <a href="/">Homepage</a>
            <a href="/user/info.action">Cancel</a>
        </li>
    </ul>
</nav>
<article class="article">
<s:actionerror/>
<s:hidden name="user.password" value="user.password"/>
<s:hidden name="user.id" value="user.id"/>
<s:hidden name="user.role" value="user.role"/>
<s:hidden name="user.pharmacyId" value="user.pharmacyId"/>
<s:hidden name="user.networkdId" value="user.networkdId"/>
<s:form action="updateCredentials">
    <s:push value="user">
        <s:hidden name="user.id"/>
        <s:hidden name="user.role"/>
        <s:hidden name="user.password"/>
        <s:hidden name="user.pharmacyId"/>
        <s:hidden name="user.networkdId"/>
        <s:textfield label="Your name" name="user.name"></s:textfield>
        <s:textfield label="Your surname" name="user.surname"></s:textfield>
        <s:textfield label="Your username" name="user.username"></s:textfield>
        <s:submit/>
    </s:push>
</s:form>
</article>
<footer id="copyright">Copyright 2016, Loosers inc.</footer>
</div>
</body>

</html>
