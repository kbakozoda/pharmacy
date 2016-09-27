<%@taglib uri="/struts-tags" prefix="s" %>
<link rel="stylesheet" type="text/css" href="../style.css">

<html>
<head>
    <title>Sign Up a Superuser</title>
</head>
<body>

<header>
    <h1>Sign Up a Superuser</h1>
</header>
<nav class="nav">
    <ul>
        <li><a href="/">Home</a> </li>
    </ul>
</nav>
<article class="article">
    <s:actionerror/>
    <s:form action="susignup">
        <s:textfield name="user.username" label="User Name"></s:textfield>
        <s:textfield name="user.password" label="Password" type="password"></s:textfield>
        <s:textfield name="passwordconf" label="Confirm password" type="password"></s:textfield>
        <s:textfield name="user.name" label="Enter your name"></s:textfield>
        <s:textfield name="user.surname" label="Enter your last name"></s:textfield>
        <s:submit value="Sign me Up!"></s:submit>
    </s:form>
</article>
<footer id="copyright">
    Copyright 2016, Loosers inc.
</footer>
</body>
</html>