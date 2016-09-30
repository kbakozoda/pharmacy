<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link rel="stylesheet" type="text/css" href="../style.css">

<html>
<head>
    <title>Welcome!</title>
</head>
<body>
 <div class="flex-container">
    <header>
    <h1>Welcome mister super user! Please choose your next actions</h1>
    </header>
    <nav class="nav">
        <li><a href="/superuser/requests.action">View requests</a></li>
        <li><a href="/superuser/users.action">View all users</a></li>
        <li><a href="/superuser/networks.action">View networks</a></li>
        <li><a href="/superuser/drugtypes.action">View drug types</a></li>
        <li><a href="/superuser/drugs.action">View drugs</a></li>
        <li><a href="/user/info">My credentials</a></li>
        <li><a href="logout.action">Logout</a></li>
    </nav>
<article class="article">
    This is a dashboard of a superuser.
</article>
 </div>
    <footer id="copyright">Copyright 2016, Loosers inc.</footer>
</body>
</html>
