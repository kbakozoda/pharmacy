<%@taglib uri="/struts-tags" prefix="s" %>
<link rel="stylesheet" type="text/css" href="../style.css">
<html>
<head>
    <title>Edit</title>
</head>
<body>
<div class="flex-container">
<header>
<h1>Edit</h1>
</header>
    <article class="article">
<s:actionerror/>
<s:hidden name="drugType.id" value="%{drugType.id}"/>
<s:form action="updatedrugtype">
    <s:push value="drugType">
        <s:hidden name="drugType.id"/>
        <s:textfield label="Edit drug type name" name="drugType.name"></s:textfield>
        <s:submit value="Submit"/>
    </s:push>
</s:form>
    </article>
    </div>
<footer id="copyright">Copyright 2016, Loosers. inc</footer>
</body>
</html>
