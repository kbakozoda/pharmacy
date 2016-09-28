<%@taglib uri="/struts-tags" prefix="s" %>
<html>
<head>
    <title>Edit</title>
</head>
<body>
<div class="flex-container">
    <header><h1>Edit</h1></header>
    <nav class="nav">
        <ul>
            <li>
                <a href="/superuser/drugs.action">Drugs</a>
                <a href="/superuser/welcome.action">Dashboard</a>
                <a href="/superuser/logout.action">Logout</a>
            </li>
        </ul>
    </nav>

    <article class="article">
        <s:actionerror/>

        <s:hidden value="drug.id" name="drug.id"/>
        <s:hidden value="drug.typeid" name="drug.typeId"/>

        <s:form action="drugupdate">
            <s:push value="drug">
                <s:hidden name="drug.id"/>
                <s:hidden name="drug.typeId"/>
                <s:textfield label="Enter drug name" name="drug.name"/>
                <s:select list="drTypeNameList" name="selType" headerValue="Select its type" headerKey="nll"/>
                <s:textfield label="Age restriction" type="number" min="0" max="18" name="drug.ageRestrict" />
                <s:textarea label="Instruction" name="drug.instruction"/>
                <s:submit value="Submit"/>
            </s:push>
        </s:form>
    </article>

    <footer id="copyright">Copyright 2016, Loosers inc.</footer>
</div>

</body>
</html>