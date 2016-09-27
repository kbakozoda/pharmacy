<%@taglib uri="/struts-tags" prefix="s" %>
<link rel="stylesheet" type="text/css" href="style.css">
<html>
<head>
    <title>Edit Pharmacy</title>
</head>
<body>
<div class="flex-container">
    <header>
        <h1>Edit pharmacy info</h1>
    </header>
    <nav class="nav">
        <ul>
            <li><a href="/admin/welcome.action">Dashboard</a> </li>
            <li><a href="/admin/welcome.action">Cancel</a> </li>
        </ul>
    </nav>
    <article class="article">
    <s:actionerror/>
    <s:form action="doedit">
        <s:push value="pharmacy">
            <s:hidden name="pharmacy.id" />
            <s:hidden name="pharmacy.networkId"/>
            <s:hidden name="pharmacy.pharmacistId" />
            <s:textfield label="It's number" type="number" min="100" max="1000000" name="pharmacy.number" />
            <s:textfield label="Enter address" name="pharmacy.address"></s:textfield>
            <s:submit value="Submit"/>
        </s:push>
    </s:form>
    </article>
    <footer>
        <p id="copyright">Copyright 2016, Loosers inc.</p>
    </footer>
</div>
</body>
</html>