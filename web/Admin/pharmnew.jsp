<<<<<<< Updated upstream
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="/struts-tags" prefix="s" %>
<link rel="stylesheet" type="text/css" href="../style.css">
<html>
<head>
    <title>Create new pharmacy</title>
</head>
<body>
<div class="flex-container">
<header>
    <h1>Create new pharmacy</h1>
</header>
<nav class="nav">
    <ul>
        <li><a href="/admin/pharmacies.action">Cancel</a> </li>
        <li><a href="/admin/logout.action">Logout</a> </li>
    </ul>
</nav>
<article class="article">
    <s:form action="docreateph">
        <s:actionerror/>
        <s:textfield label="It's number" type="number" min="100" max="1000000" name="pharmacy.number" />
        <s:textfield label="Enter address" name="pharmacy.address"></s:textfield>
        <s:submit value="Submit"/>
    </s:form>
</article>

<footer id="copyright">
    Copyright 2016, Loosers inc.
</footer>
</div>
</body>
</html>
=======
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="/struts-tags" prefix="s" %>
<html>
<head>
    <title>Create new pharmacy</title>
</head>
<body>
<h1>Create new drug</h1>
<s:form action="docreateph">
    <s:actionerror/>
    <s:textfield label="It's number" type="number" min="100" max="1000000" name="pharmacy.number" />
    <s:textfield label="Enter address" name="pharmacy.address"></s:textfield>
    <s:submit value="Submit"/>
</s:form>
</body>
</html>
>>>>>>> Stashed changes
