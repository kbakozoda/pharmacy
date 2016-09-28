<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="/struts-tags" prefix="s" %>
<html>
<head>
    <title>User info</title>
</head>
<body>
<div class="flex-container">
    <article class="article">
        <h1>Choose your next action:</h1>
        <s:property value="user.name"/>
        <s:property value="user.surname"/> <br>
        Username:
        <s:property value="user.username"/><br>
    </article>
    <nav class="nav">
        <ul>
            <li> <a href="/user/credentials.action">Edit Credentials</a> </li>
            <li> <a href="/user/pass.action">Edit Password</a> </li>
            <li> <a href="/user/redirect.action">Back to dashboard</a> </li>
            <li> <a href="/">Home</a></li>
        </ul>
    </nav>

    <footer id="copyright">
        Copyright 2016, Loosers inc.
    </footer>

</div>
</body>
</html>
