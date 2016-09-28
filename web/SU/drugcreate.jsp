<%@taglib uri="/struts-tags" prefix="s" %>
<html>
<head>
    <title>Create new drug type</title>
</head>
<body>
<div class="flex-container">
    <header>
        <h1>Create new drug</h1>
    </header>
<article class="article">
    <s:form action="adddrug">
        <s:actionerror/>
        <s:textfield label="Enter drug name" name="drug.name"></s:textfield>
        <s:select list="drTypeNameList" name="selType" headerValue="Select its type" headerKey="nll"/>
        <s:textfield label="Age restriction" type="number" min="0" max="18" name="drug.ageRestrict" />
        <s:textarea label="Instruction" name="drug.instruction"/>
        <s:submit value="Submit"/>
    </s:form>
</article>
    <nav class="nav">
        <ul>
            <li>
                <a href="/superuser/drugs.action">Back</a>
                <a href="/superuser/logout.action">Logout</a>
            </li>
        </ul>
    </nav>
    <footer id="copyright">Copyright 2016, Loosers inc.</footer>
</div>
</body>
</html>
