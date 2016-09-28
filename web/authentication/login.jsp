<%@taglib uri="/struts-tags" prefix="s" %>
<link rel="stylesheet" type="text/css" href="../style.css">

<html>
<head>
    <title>Login</title>
</head>
<body>
<div class="flex-container">
<header>
    <h3>Welcome User, please login below</h3>
</header>
<nav class="nav">
    <ul>
        <li><a href="../index.jsp">Back to main page</a> </li>
    </ul>
</nav>
<article class="article">
    <s:form action="tryAuthorise">
        <s:textfield name="username" label="User Name"></s:textfield>
        <s:textfield name="password" label="Password" type="password"></s:textfield>
        <s:submit value="Login"></s:submit>
    </s:form>
</article>
<footer id="copyright">
    Copyright 2016, Loosers inc.
</footer>
    </div>
</body>
</html>
