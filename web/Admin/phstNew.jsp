<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link rel="stylesheet" type="text/css" href="../style.css">

<html>
<head>
    <title>New pharmacist</title>
</head>
<body>
<div class="flex-container">
<header>
        Create New Pharmacist
</header>
<nav class="nav">
        <ul>
                <li>
                        <a href="/admin/pharmacists.action">Pharmacists</a>
                        <a href="/admin/logout.action">Logout</a>
                </li>
        </ul>
</nav>
<article class="article">
        <s:actionerror/>

        <s:form action="doCreatePhst">
                <s:textfield label="Your name" name="pharmacist.name"></s:textfield>
                <s:textfield label="Your surname" name="pharmacist.surname"></s:textfield>
                <s:textfield label="Your username" name="pharmacist.username"></s:textfield>
                <s:textfield name="pharmacist.password" label="Password" type="password"></s:textfield>
                <s:textfield name="passwordconf" label="Confirm password" type="password"></s:textfield>
                <s:select list="phNmbList" label="Choose pharmacy" name="selPh" headerKey="-1"
                          headerValue="Select pharmacy"/>
                <s:submit value="Create"/>
        </s:form>
</article>
<footer id="copyright">
        Copyright 2016, Loosers inc.
</footer>

</div>
</body>
</html>
