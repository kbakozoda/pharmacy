<%@tag description="Overall Page template" pageEncoding="UTF-8"%>
<%@attribute name="header" fragment="true" %>
<%@attribute name="footer" fragment="true" %>
<%@attribute name="nav" fragment="true" %>
<link rel="stylesheet" type="text/css" href="../../style.css">
<html>
<body>
<div id="pageheader" class="header">
    <jsp:invoke fragment="header"/>
</div>

<div id="nav" class="nav">
    <jsp:invoke fragment="nav"/>
</div>
<div id="body" class="article">
    <jsp:doBody/>
</div>
<div id="pagefooter">
    <jsp:invoke fragment="footer"/>
</div>
</body>
</html>