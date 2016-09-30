<%@taglib uri="/struts-tags" prefix="s" %>
<link rel="stylesheet" type="text/css" href="style.css">
<html>
<head>
    <title>Edit network</title>
</head>
<body>
<div class="flex-container">
    <header><h1>Edit network<h1></header>
    <nav class="nav">
        <li><a href="/superuser/welcome.action">Dashboard</a> </li>
        <li><a href="/superuser/requests.action">View requests</a></li>
        <li><a href="/superuser/users.action">View all users</a></li>
        <li><a href="/superuser/networks.action">View networks</a></li>
        <li><a href="/superuser/drugtypes.action">View drug types</a></li>
        <li><a href="/superuser/drugs.action">View drugs</a></li>
        <li><a href="/user/info">My credentials</a></li>
        <li><a href="logout.action">Logout</a></li>
    </nav>
    <article class="article">
        <s:actionerror/>
        <s:hidden name="network.id" value="network.id"></s:hidden>
        <s:hidden name="network.adminId" value="network.adminId"></s:hidden>
        <h1>Edit net info</h1>
        <s:form action="updateNet">
            <s:push value="network">
            <s:hidden name="network.id" />
            <s:hidden name="network.adminId" />
            <s:textfield label="Enter network's name" name="network.name"></s:textfield>
            <s:submit value="Submit"/>
            </s:push>
        </s:form>
    </article>
    </div>
<footer id="copyright">Copyright 2016, Loosers inc.</footer>
</body>
</html>