<%@taglib uri="/struts-tags" prefix="s" %>
<link rel="stylesheet" type="text/css" href="../style.css">

<html>
<head>
    <title>Sign Up</title>
</head>
<body>

<header>
    <h1>Sign Up</h1>
</header>
<nav class="nav">
    <ul>
        <li><a href="/index.jsp">Homepage</a> </li>
    </ul>
</nav>
<article class="article">
    <s:form action="adminsignup">
        <s:textfield name="username" label="Login"></s:textfield>
        <s:textfield name="password" label="Password" type="password"></s:textfield>
        <s:textfield name="passwordconf" label="Confirm password" type="password"></s:textfield>
        <s:textfield name="name" label="Enter your name"></s:textfield>
        <s:textfield name="surname" label="Enter your last name"></s:textfield>
        <s:select list="netwNameList" name="selNetw"
                  headerValue="Select network" headerKey="nll" />
        <s:submit value="Sign me Up!" onclick="alert('Now you will have to wait until admin approves your request');"></s:submit>
    </s:form>
</article>
<footer id="copyright">
    Copyright 2016, Loosers inc.
</footer>

</body>
</html>
