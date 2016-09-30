<<<<<<< Updated upstream
<%@taglib uri="/struts-tags" prefix="s" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<link rel="stylesheet" type="text/css" href="../style.css">
<html>

    <head>
        <title>Welcome Admin!</title>
    </head>

<div class="flex-container">
    <header>
        <h1>Welcome <s:property value="username"></s:property></h1>
    </header>

    <nav class="nav">
        <ul>
            <li><a href="pharmacies.action">View pharmacies in my network</a></li>
            <li><a href="requests.action">View requests</a> </li>
            <li><a href="/user/info">My credentials</a></li></li>
            <li> <a href="pharmacists.action">Pharmacists</a></li>
            <li> <a href="logout.action">logout</a></li>
        </ul>
    </nav>

    <article class="article">
        About our web-site.
        Lorem impsum dolor, etc. To be filled-in<br>
        Lorem impsum dolor, etc. To be filled-in<br>
        Lorem impsum dolor, etc. To be filled-in<br>
        Lorem impsum dolor, etc. To be filled-in<br>
        Lorem impsum dolor, etc. To be filled-in<br>
        Lorem impsum dolor, etc. To be filled-in<br>
        Lorem impsum dolor, etc. To be filled-in<br>
        Lorem impsum dolor, etc. To be filled-in<br>
        Lorem impsum dolor, etc. To be filled-in<br>
        Lorem impsum dolor, etc. To be filled-in<br>
        Lorem impsum dolor, etc. To be filled-in<br>
    </article>

    <footer>
        <p id="copyright">Copyright 2016, Loosers inc.</p>
    </footer>
 </div>
</html>

=======
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="/struts-tags" prefix="s" %>
<html>
<head>
    <title>Welcome Admin!</title>
</head>
<body>
    <h1>Welcome <s:property value="username"></s:property></h1>
    <a href="logout.action">logout</a>
    <a href="pharmacies.action">View pharmacies in my network</a>
    <a href="requests.action">View requests</a>
</body>
</html>
>>>>>>> Stashed changes
