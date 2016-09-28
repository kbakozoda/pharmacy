<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link rel="stylesheet" type="text/css" href="../style.css">
<html>
<head>
    <title>Pharmacy</title>
</head>
<body>
<div class="flex-container">
<header>
    Pharmacy info
</header>

<nav class="nav">
    <ul>
        <li>
            <a href="/admin/pharmacies.action">Back</a>
            <a href="/admin/logout.action">Logout</a>
        </li>
    </ul>
</nav>


<article class="article">
Name
<s:property value="pharmacy.name"/> <br>
Number
<s:property value="pharmacy.number"/> <br>
Pharmacist username
<s:property value="phUsername"/> <br>
Address
<s:property value="pharmacy.address"/> <br>
</article>
</div>
</body>
<footer id="copyright">
    Copyright 2016, Loosers inc.
</footer>
</html>
