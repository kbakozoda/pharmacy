<%@taglib uri="/struts-tags" prefix="s" %>
<link rel="stylesheet" type="text/css" href="style.css">

<html>
<head>
    <title>Error</title>
</head>
<body>
<div class="flex-container">
    <header> <h1>Error!!!</h1> </header>
    <nav class="nav">
        <ul>
            <li><a href="devs.action">View developers</a></li>
            <li> <a href="superuser/welcome">I am Super User!</a></li>
            <li> <a href="admin/welcome">I am an Admin</a></li></li>
            <li> <a href="pharm/index">I am a Pharmacist</a></li>
            <li> <a href="regadmin">Register new admin</a></li>
            <li> <a href="regpharm">Register new pharmacist</a></li>
            <li> <a href="regsu">Register new superuser</a></li>
        </ul>
    </nav>

    <article>
        <s:actionerror/>
        This error is caused by wrong request or an internal server error.
    </article>

    <footer class="footer">

    </footer>
</div>

</body>
</html>